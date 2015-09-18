package controlador.cotizacion;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelo.CabeceraCotizacion;
import modelo.DetalleCotizacion;
import modelo.F0004;
import modelo.F0005;
import modelo.F0013;
import modelo.F0014;
import modelo.F4311;
import modelo.F4331;
import modelo.F554330;
import modelo.Usuario;
import modelo.pk.F4331PK;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Doublespinner;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.buscadores.BuscadorUDC;
import componentes.catalogos.CatalogoF0013;
import componentes.catalogos.CatalogoF0014;
import componentes.catalogos.CatalogoGenerico;
import componentes.utils.Convertidor;
import controlador.maestros.CGenerico;

public class CCotizacion extends CGenerico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox txtNumero;
	@Wire
	private Textbox txtCondicion;
	@Wire
	private Label lblCondicion;
	@Wire
	private Textbox txtComprador;
	@Wire
	private Datebox dtbFechaCotizacion;
	@Wire
	private Textbox txtMoneda1;
	@Wire
	private Label lblMoneda1;
	@Wire
	private Datebox dtbFechaRequerida;
	@Wire
	private Spinner spnDias;
	@Wire
	private Textbox txtAnexo;
	@Wire
	private Datebox dtbFechaVigencia;
	@Wire
	private Textbox txtComentario;
	@Wire
	private Radio rdoPorCargar;
	@Wire
	private Radio rdoCargada;
	@Wire
	private Radio rdoTodas;
	@Wire
	private Label lblLinea;
	@Wire
	private Doublebox txtTotal;
	@Wire
	private Combobox cmbEstado;
	@Wire
	private Div divVCotizacion;
	@Wire
	private Div botoneraCotizacion;
	@Wire
	private Div catalogoCotizacion;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Div divbuscador;
	@Wire
	private Listbox ltbLista;
	@Wire
	private Div divCatalogoF0014;
	@Wire
	private Div divCatalogoF0013;
	BuscadorUDC buscador;
	protected List<CabeceraCotizacion> listaGeneral = new ArrayList<CabeceraCotizacion>();
	protected List<DetalleCotizacion> listaDetalle = new ArrayList<DetalleCotizacion>();
	Botonera botonera;
	CatalogoGenerico<CabeceraCotizacion> catalogo;
	CatalogoGenerico<F0013> catalogoF0013;
	CatalogoGenerico<F0014> catalogoF0014;
	String an8 = "0";
	Double total = (double) 0;

	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> map = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (map != null) {
			if (map.get("tabsGenerales") != null) {
				tabs = (List<Tab>) map.get("tabsGenerales");
				titulo = (String) map.get("titulo");
				idArbol = (long) map.get("idArbol");
				map.clear();
				map = null;
			}
		}
		Usuario user = servicioUsuario.buscarPorId(nombreUsuarioSesion());
		if (user != null)
			if (user.getAn8() != null)
				an8 = user.getAn8().replace(".0", "");
		settearTituo(divVCotizacion, idArbol);
		buscador = new BuscadorUDC("Flete", 10, true, "55", "FR",
				servicioF0005, "25.5%", "27%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("55", "FR", buscador.obtenerCaja());
			}
		};
		divbuscador.appendChild(buscador);
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion(catalogo)) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						CabeceraCotizacion cabecera = catalogo
								.objetoSeleccionadoDelCatalogo();
						txtAnexo.setValue(cabecera.getAnexo());
						txtNumero.setValue(cabecera.getNumCotizacion());
						txtComprador.setValue(cabecera.getResponsable());
						try {
							dtbFechaCotizacion
									.setValue(Convertidor.formatoFecha2
											.parse(cabecera.getFechaEmision()));
							dtbFechaRequerida
									.setValue(Convertidor.formatoFecha2
											.parse(cabecera
													.getFechaVencimiento()));
						} catch (WrongValueException e) {
							e.printStackTrace();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						total = (double) 0;
						List<F554330> variables = servicioF554330
								.buscarPorExdocoAndExan8(new BigDecimal(
										cabecera.getNumCotizacion()), an8);
						if (!variables.isEmpty()) {
							F0005 udc = servicioF0005.buscar("55", "FR",
									"        " + variables.get(0).getExfrth());
							if (udc != null)
								buscador.settearForced(variables.get(0)
										.getExfrth(), udc.getDrdl01());
							txtComentario.setValue(variables.get(0)
									.getExstrngval());
							txtCondicion.setValue(variables.get(0).getExptc());
							F0014 condicion = servicioF0014.buscar(variables
									.get(0).getExptc());
							if (condicion != null)
								lblCondicion.setValue(condicion.getPnptd());

						}
						listaDetalle = servicioDetalleCotizacion.buscar(an8,
								txtNumero.getValue().replace(".0", ""), "t");
						for (int i = 0; i < listaDetalle.size(); i++) {
							total = total + listaDetalle.get(i).getTotal();
						}
						txtTotal.setValue(total);
						ltbLista.setModel(new ListModelList<DetalleCotizacion>(
								listaDetalle));
						if (!listaDetalle.isEmpty()) {
							spnDias.setValue(1);
							txtMoneda1
									.setValue(listaDetalle.get(0).getMoneda());
							F0013 mon = servicioF0013.buscar(listaDetalle
									.get(0).getMoneda());
							if (mon != null)
								lblMoneda1.setValue(mon.getCvdl01());
							dtbFechaVigencia.setValue(listaDetalle.get(0)
									.getFecha());
						}
						lblLinea.setValue(String.valueOf(listaDetalle.size()));
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVCotizacion, titulo, tabs);
			}

			@Override
			public void reporte() {
				if (validarSeleccion(catalogo)) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						Clients.evalJavaScript("window.open('"
								+ damePath()
								+ "Reporte?valor=1&valor2="
								+ catalogo.objetoSeleccionadoDelCatalogo()
										.getNumCotizacion()
								+ "&valor3="
								+ an8
								+ "&valor20="
								+ "PDF"
								+ "','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");

					} else
						Mensaje.mensajeAlerta("Solo puede generar un reporte a la vez, por favor, seleccione solo una Cotizacion");
				}
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
			}

			@Override
			public void guardar() {
				if (validar()) {
					if (txtTotal.getValue() != 0) {
						String numeroCotizacion = txtNumero.getValue();
						String flete = buscador.getCajaTexto().getValue()
								.replaceAll("\\s+", "");
						String condicion = txtCondicion.getValue();
						String moneda = txtMoneda1.getValue();
						String comentario = txtComentario.getValue();
						BigDecimal fechaVigencia = Convertidor
								.transformarGregorianoAJulia(dtbFechaVigencia
										.getValue());
						ltbLista.renderAll();
						for (int i = 0; i < ltbLista.getItemCount(); i++) {
							Listitem listItem = ltbLista.getItemAtIndex(i);
							DetalleCotizacion detalle = listItem.getValue();
							// Se eliminan el/los registros de la linea
							Double precio = ((Doublespinner) ((listItem
									.getChildren().get(6))).getFirstChild())
									.getValue();
							List<F4331> objetos = servicioF4331
									.buscarPorDocAn8Linea(numeroCotizacion,
											an8, detalle.getNumLinea());
							servicioF4331.eliminarVarios(objetos);
							// Solo registro en la F4331 si el precio es mayor a
							// 0
							if (precio != 0) {
								// Datos de las lineas en vivo
								Integer cantidad = ((Spinner) ((listItem
										.getChildren().get(5))).getFirstChild())
										.getValue();
								Integer dias = ((Spinner) ((listItem
										.getChildren().get(7))).getFirstChild())
										.getValue();
								// Se crea el nuevo registro y se guarda
								// (actualizacion)
								F4331 objeto = new F4331();
								F4331PK claveObjeto = new F4331PK();
								claveObjeto.setP1an8(Double.valueOf(an8));
								claveObjeto.setP1dcto("OQ");
								claveObjeto.setP1doco(Double
										.valueOf(numeroCotizacion));
								claveObjeto.setP1kcoo("00300");
								claveObjeto.setP1lnid(detalle.getNumLinea()
										.doubleValue());
								claveObjeto.setP1uorg(cantidad.doubleValue());
								claveObjeto.setP1sfxo("000");
								objeto.setId(claveObjeto);
								objeto.setP1prrc(precio);
								objeto.setP1crcd(moneda);
								objeto.setP1pddj(Convertidor
										.transformarGregorianoAJulia(Convertidor
												.sumarDias(dtbFechaRequerida
														.getValue(), dias))); // Dias
																				// revisar
																				// COD
								objeto.setP1qrdj(Convertidor
										.transformarGregorianoAJulia(dtbFechaVigencia
												.getValue()));
								objeto.setP1cndj(fechaVigencia);

								// String observacion = ((Textbox)
								// ((listItem.getChildren()
								// .get(15))).getFirstChild()).getValue();
								// Si se modifica el precio entonces queda
								// registrada como publicada
								objeto.setPublicado(true);
								servicioF4331.guardar(objeto);
							}
						}
						// Se buscan las lineas que esten pendientes y se
						// actualiza la cabecera; en caso de que no hayan
						// pendientes se guarda el estado como completado
						List<F4311> actualizadas = servicioF4311
								.buscarNoExistentes(numeroCotizacion, an8);
						String estado = "Respondida Parcialmente";
						if (actualizadas.isEmpty())
							estado = "Respondida Completamente";
						List<F554330> cabeceras = servicioF554330
								.buscarPorExdocoAndExan8(new BigDecimal(
										numeroCotizacion), an8);
						for (int i = 0; i < cabeceras.size(); i++) {
							F554330 cabeza = cabeceras.get(i);
							cabeza.setExstds(estado);
							cabeza.setExsorg("Portal Web");
							cabeza.setExptc(condicion);
							cabeza.setExfrth(flete);
							cabeza.setExstrngval(comentario);
							servicioF554330.guardar(cabeza);
						}
						buscar3();
						limpiar();
						abrirCatalogo();
						Mensaje.mensajeInformacion(Mensaje.guardado);

					} else
						Mensaje.mensajeAlerta("Debe cargar al menos una linea");
				}
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void buscar() {
				abrirCatalogo();
			}

			@Override
			public void ayuda() {
			}

			@Override
			public void annadir() {
				if (validarSeleccion(catalogo)) {
					boolean error = false;
					boolean publicada = false;
					List<CabeceraCotizacion> aux = catalogo
							.obtenerSeleccionados();
					for (int i = 0; i < aux.size(); i++) {
						if (!aux.get(i).getEstado()
								.startsWith("Respondida Completamente")) {
							error = true;
							break;
						}
						if (aux.get(i).getPublicado().startsWith("SI")) {
							publicada = true;
							break;
						}
					}
					if (!error)
						if (!publicada)
							Messagebox
									.show("¿Desea Publicar la(s) "
											+ catalogo.obtenerSeleccionados()
													.size() + " Cotizaciones?",
											"Alerta",
											Messagebox.OK | Messagebox.CANCEL,
											Messagebox.QUESTION,
											new org.zkoss.zk.ui.event.EventListener<Event>() {
												public void onEvent(Event evt)
														throws InterruptedException {
													if (evt.getName().equals(
															"onOK")) {
														for (int i = 0; i < catalogo
																.obtenerSeleccionados()
																.size(); i++) {
															List<F554330> publicar = servicioF554330
																	.buscarPorExdocoAndExan8(
																			new BigDecimal(
																					catalogo.obtenerSeleccionados()
																							.get(i)
																							.getNumCotizacion()),
																			an8);
															for (int j = 0; j < publicar
																	.size(); j++) {
																publicar.get(j)
																		.setExurcd(
																				"SI");
																servicioF554330
																		.guardar(publicar
																				.get(j));
															}
														}
														buscar3();
														Mensaje.mensajeInformacion("Cotizaciones publicadas con exito");
													}
												}
											});
						else
							Mensaje.mensajeAlerta("No se pueden publicar cotizaciones ya publicadas, verifique su seleccion");

					else
						Mensaje.mensajeAlerta("Solo se pueden publicar cotizaciones con estado de 'RESPONDIDA COMPLETAMENTE', verifique su seleccion");
				}
			}
		};
		Button limpiar = (Button) botonera.getChildren().get(2);
		limpiar.setLabel("Publicar");
		limpiar.setImage("/public/imagenes/botones/exportar.png");
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botoneraCotizacion.appendChild(botonera);
	}

	protected boolean validar() {
		if (txtCondicion.getText().compareTo("") == 0
				|| txtMoneda1.getText().compareTo("") == 0
				|| buscador.getCajaTexto().getText().compareTo("") == 0) {
			Mensaje.mensajeError(Mensaje.camposVacios);
			return false;
		} else
			return true;
	}

	@Listen("onOpen = #gpxDatos")
	public void abrirCatalogo() {
		gpxDatos.setOpen(false);
		if (camposEditando()) {
			Messagebox.show(Mensaje.estaEditando, "Alerta", Messagebox.YES
					| Messagebox.NO, Messagebox.QUESTION,
					new org.zkoss.zk.ui.event.EventListener<Event>() {
						public void onEvent(Event evt)
								throws InterruptedException {
							if (evt.getName().equals("onYes")) {
								gpxDatos.setOpen(false);
								gpxRegistro.setOpen(true);
							} else {
								if (evt.getName().equals("onNo")) {
									gpxDatos.setOpen(true);
									gpxRegistro.setOpen(false);
									limpiarCampos();
									mostrarBotones(true);
								}
							}
						}
					});
		} else {
			gpxDatos.setOpen(true);
			gpxRegistro.setOpen(false);
			mostrarBotones(true);
		}
	}

	private boolean camposEditando() {
		if (txtComentario.getText().compareTo("") != 0
				|| buscador.obtenerCaja().compareTo("") != 0
				|| txtCondicion.getText().compareTo("") != 0
				|| txtMoneda1.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected void limpiarCampos() {
		rdoTodas.setChecked(true);
		buscar2();
		txtComentario.setValue("");
		txtMoneda1.setValue("");
		lblMoneda1.setValue("");
		txtCondicion.setValue("");
		lblCondicion.setValue("");
		buscador.settearModelo(null);
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(6).setVisible(bol);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);

	}

	private void mostrarCatalogo() {
		listaGeneral = servicioCabecera.buscar(an8, "%No Respondida%");
		catalogo = new CatalogoGenerico<CabeceraCotizacion>(catalogoCotizacion,
				"Cotizaciones", listaGeneral, false, false, false, "Nº Cot.",
				"Fecha Orden", "Comprador", "Fecha requerida",
				"Dias restantes", "Estado", "Anexo", "Publicado") {

			@Override
			protected List<CabeceraCotizacion> buscar(List<String> valores) {

				List<CabeceraCotizacion> lista = new ArrayList<CabeceraCotizacion>();

				for (CabeceraCotizacion f0004 : listaGeneral) {
					if (f0004.getNumCotizacion().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0004.getFechaEmision().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& f0004.getResponsable().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& f0004.getFechaVencimiento().toLowerCase()
									.contains(valores.get(3).toLowerCase())
							&& f0004.getDiasEntrega().toString().toLowerCase()
									.contains(valores.get(4).toLowerCase())
							&& f0004.getEstado().toLowerCase()
									.contains(valores.get(5).toLowerCase())
							&& f0004.getAnexo().toLowerCase()
									.contains(valores.get(6).toLowerCase())
							&& f0004.getPublicado().toLowerCase()
									.contains(valores.get(7).toLowerCase())) {
						lista.add(f0004);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(CabeceraCotizacion f0004) {
				String[] registros = new String[8];
				registros[0] = f0004.getNumCotizacion();
				registros[1] = f0004.getFechaEmision();
				registros[2] = f0004.getResponsable();
				registros[3] = f0004.getFechaVencimiento();
				registros[4] = f0004.getDiasEntrega().toString();
				registros[5] = f0004.getEstado();
				registros[6] = f0004.getAnexo();
				registros[7] = f0004.getPublicado();
				return registros;
			}
		};
		catalogo.setParent(catalogoCotizacion);
	}

	@Listen("onClick = #btnBuscarMoneda1")
	public void mostrarCatalogoMoneda(Event evento) {
		List<F0013> lista = servicioF0013.buscarTodosOrdenados();
		catalogoF0013 = new CatalogoF0013(divCatalogoF0013, "F0013", lista,
				true, "Codigo moneda", "Descripcion", "Vlslz", "Rutina cheques");
		catalogoF0013.setParent(divCatalogoF0013);
		catalogoF0013.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0013")
	public void seleccionMoneda() {
		F0013 f0013 = catalogoF0013.objetoSeleccionadoDelCatalogo();
		settearMoneda(f0013, txtMoneda1, lblMoneda1);
		catalogoF0013.setParent(null);
	}

	@Listen("onChange = #txtMoneda1; onOK = #txtMoneda1")
	public void buscarMoneda(Event evento) {
		Textbox target = (Textbox) evento.getTarget();
		if (target.getValue() != null) {
			F0013 f0013 = servicioF0013.buscar(target.getValue());
			if (f0013 != null)
				settearMoneda(f0013, txtMoneda1, lblMoneda1);
			else {
				txtMoneda1.setValue("");
				Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
				lblMoneda1.setValue("");
			}
		}
	}

	public void settearMoneda(F0013 f0013, Textbox txt, Label lbl) {
		txt.setValue(f0013.getCvcrcd());
		lbl.setValue(f0013.getCvdl01());
	}

	@Listen("onClick = #btnBuscarCondicion")
	public void mostrarCatalogoCondicion(Event evento) {
		List<F0014> lista = servicioF0014.buscarTodosOrdenados();
		catalogoF0014 = new CatalogoF0014(divCatalogoF0014, "F0014", lista,
				true, "Codigo", "Descripcion");
		catalogoF0014.setParent(divCatalogoF0014);
		catalogoF0014.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0014")
	public void seleccionCondicion() {
		F0014 f0013 = catalogoF0014.objetoSeleccionadoDelCatalogo();
		settearCondicion(f0013, txtCondicion, lblCondicion);
		catalogoF0014.setParent(null);
	}

	@Listen("onChange = #txtCondicion; onOK = #txtCondicion")
	public void buscarCondicion(Event evento) {
		Textbox target = (Textbox) evento.getTarget();
		if (target.getValue() != null) {
			F0014 f0013 = servicioF0014.buscar(target.getValue());
			if (f0013 != null)
				settearCondicion(f0013, txtCondicion, lblCondicion);
			else {
				txtMoneda1.setValue("");
				Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
				lblMoneda1.setValue("");
			}
		}
	}

	public void settearCondicion(F0014 f0013, Textbox txt, Label lbl) {
		txt.setValue(f0013.getPnptc());
		lbl.setValue(f0013.getPnptd());
	}

	@Listen("onChange = #cmbEstado")
	public void buscar3() {
		String valor = cmbEstado.getValue();
		if (valor.equals("TODAS"))
			valor = "%";
		listaGeneral = servicioCabecera.buscar(an8, "%" + valor + "%");
		catalogo.actualizarLista(listaGeneral);
	}

	@Listen("onCheck = #rdoCargada, #rdoPorCargar, #rdoTodas ")
	public void buscar2() {
		String busqueda = "t";
		if (rdoPorCargar.isChecked())
			busqueda = "p";
		else {
			if (rdoCargada.isChecked())
				busqueda = "c";
		}
		listaDetalle = servicioDetalleCotizacion.buscar(an8, txtNumero
				.getValue().replace(".0", ""), busqueda);
		ltbLista.setModel(new ListModelList<DetalleCotizacion>(listaDetalle));
		lblLinea.setValue(String.valueOf(listaDetalle.size()));
	}

	public byte[] reporte(String par2, String par3, String tipo) {
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("num", par2);
		List<DetalleCotizacion> lista = getServicioDetalle().buscar(par3,
				par2.replace(".0", ""), "t");
		return generarReporteGenerico(p, lista,
				"/reporte/RDetalleCotizacion.jasper", tipo);
	}

	public void getCambio() {
		ltbLista.renderAll();
		if (ltbLista.getItemCount() != 0) {
			double total2 = 0;
			for (int i = 0; i < ltbLista.getItemCount(); i++) {
				Listitem listItem = ltbLista.getItemAtIndex(i);
				int cantidad = ((Spinner) ((listItem.getChildren().get(5)))
						.getFirstChild()).getValue();
				double precioUnitario = ((Doublespinner) ((listItem
						.getChildren().get(6))).getFirstChild()).getValue();
				((Listcell) (listItem.getChildren().get(10))).setLabel(String
						.valueOf(precioUnitario * cantidad));
				total2 = total2 + (precioUnitario * cantidad);
			}
			txtTotal.setValue(total + total2);
		}
	}

}
