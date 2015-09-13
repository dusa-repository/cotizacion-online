package controlador.cotizacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.CabeceraCotizacion;
import modelo.DetalleCotizacion;
import modelo.F0004;
import modelo.F0005;
import modelo.F0013;
import modelo.F0014;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
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
	private Radio rdpPorCargar;
	@Wire
	private Radio rdoCargada;
	@Wire
	private Radio rdoTodas;
	@Wire
	private Label lblLinea;
	@Wire
	private Doublebox txtTotal;
	@Wire
	private Datebox dtbDesde;
	@Wire
	private Datebox dtbHasta;
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
	Integer clave = null;

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
		settearTituo(divVCotizacion, idArbol);
		mostrarCatalogo();
		buscador = new BuscadorUDC("Flete", 10, true, "00", "DT",
				servicioF0005, "30%", "7%", "10%", "40%") {
			@Override
			protected F0005 buscar() {
				return servicioF0005.buscar("00", "DT", buscador.obtenerCaja());
			}
		};
		divbuscador.appendChild(buscador);
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion(catalogo)) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						CabeceraCotizacion cabecera = catalogo
								.objetoSeleccionadoDelCatalogo();
						// txtAnexo.setValue(cabecera.getAnexo());
						// txtComentario.setValue(cabecera.getComentario());
						clave = cabecera.getIdrow();
						txtComprador.setValue(cabecera.getIdProveedor());
						txtCondicion.setValue(cabecera.getIdProveedor());
						txtMoneda1.setValue(cabecera.getIdProveedor());
//						txtNumero.setValue(cabecera.getNumCotizacion());
//						dtbFechaCotizacion.setValue(cabecera.getFechaEmision());
//						dtbFechaRequerida.setValue(cabecera.getFechaEmision());
//						dtbFechaVigencia.setValue(cabecera
//								.getFechaVencimiento());
//						txtTotal.setValue(value);
//						spnDias.setValue(value);
//						buscador.settearModelo(servicioF0005.buscar("00", "DT",
//								f21.getNlsmas()));
						listaDetalle = servicioDetalleCotizacion
								.buscarPorCabeceraYEstado(
										cabecera.getNumCotizacion(),
										"Pendiente");
						ltbLista.setModel(new ListModelList<DetalleCotizacion>(
								listaDetalle));
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
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				clave = null;
			}

			@Override
			public void guardar() {
				String dct = buscador.obtenerCaja();
			}

			@Override
			public void eliminar() {
				// TODO Auto-generated method stub

			}

			@Override
			public void buscar() {
			}

			@Override
			public void ayuda() {
				abrirCatalogo();
			}

			@Override
			public void annadir() {
				// TODO Auto-generated method stub

			}
		};
		Button btn = (Button) botonera.getChildren().get(1);
		btn.setImage("/public/imagenes/botones/buscar.png");
		btn.setLabel("Buscar");
		botonera.getChildren().get(2).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(4).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botoneraCotizacion.appendChild(botonera);
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
		return true;
	}

	protected void limpiarCampos() {
		// TODO Auto-generated method stub

	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	protected void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);

	}

	private void mostrarCatalogo() {
		listaGeneral = servicioCabecera.buscarTodosOrdenados("NO RESPONDIDA");
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
							&& Convertidor.formatoFecha.format(f0004.getFechaEmision()).toLowerCase()
									.contains(valores.get(1).toLowerCase())) {
						lista.add(f0004);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(CabeceraCotizacion f0004) {
				String[] registros = new String[8];
				registros[0] = f0004.getNumCotizacion();
				registros[1] = Convertidor.formatoFecha.format(f0004.getFechaEmision());
				registros[2] = f0004.getNumCotizacion();
				registros[3] = f0004.getNumCotizacion();
				registros[4] = f0004.getNumCotizacion();
				registros[5] = f0004.getNumCotizacion();
				registros[6] = f0004.getNumCotizacion();
				registros[7] = f0004.getNumCotizacion();
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

}
