package controlador.maestros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.F0004;
import modelo.F0013;
import modelo.F0014;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import componentes.Botonera;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;
import componentes.utils.Convertidor;

public class CF0014 extends CGenerico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox txtCodigo;
	@Wire
	private Textbox txtDescripcion;
	@Wire
	private Textbox txtField1;
	@Wire
	private Textbox txtField2;
	@Wire
	private Doublebox txtField3;
	@Wire
	private Doublebox txtField4;
	@Wire
	private Doublebox txtField5;
	@Wire
	private Doublebox txtField6;
	@Wire
	private Doublebox txtField7;
	@Wire
	private Doublebox txtField8;
	@Wire
	private Doublebox txtField9;
	@Wire
	private Doublebox txtField10;
	@Wire
	private Div divVF0014;
	@Wire
	private Div botoneraF0014;
	@Wire
	private Div catalogoF0014;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	protected List<F0014> listaGeneral = new ArrayList<F0014>();
	Botonera botonera;
	CatalogoGenerico<F0014> catalogo;
	String clave = null;

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
		settearTituo(divVF0014, idArbol);
		txtCodigo.setFocus(true);
		mostrarCatalogo();
		botonera = new Botonera() {

			@Override
			public void seleccionar() {
				if (validarSeleccion(catalogo)) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						F0014 f013 = catalogo.objetoSeleccionadoDelCatalogo();
						clave = f013.getPnptc();
						txtCodigo.setValue(f013.getPnptc());
						txtCodigo.setDisabled(true);
						txtDescripcion.setValue(f013.getPnptd());
						txtField1.setValue(f013.getPnpid());
						txtField2.setValue(f013.getPnjobn());
						txtField3.setValue(f013.getPnnsp());
						txtField4.setValue(f013.getPndcp());
						txtField5.setValue(f013.getPndcd());
						txtField6.setValue(f013.getPnndtp());
						txtField7.setValue(f013.getPnpxdd());
						txtField8.setValue(f013.getPndtpa());
						txtField9.setValue(f013.getPneir());
						txtField10.setValue(f013.getPnpxdm());
						txtDescripcion.setFocus(true);
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void salir() {
				cerrarVentana(divVF0014, titulo, tabs);
			}

			@Override
			public void reporte() {
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
				habilitarTextClave();
				clave = null;
			}

			@Override
			public void guardar() {
				if (validar()) {
					F0014 f0013 = new F0014();
					f0013.setPnptc(txtCodigo.getValue());
					f0013.setPnptd(txtDescripcion.getValue());
					f0013.setPnpid(txtField1.getValue());
					f0013.setPnjobn(txtField2.getValue());
					f0013.setPnnsp(txtField3.getValue() != null ? txtField3
							.getValue() : 0);
					f0013.setPndcp(txtField4.getValue() != null ? txtField4
							.getValue() : 0);
					f0013.setPndcd(txtField5.getValue() != null ? txtField5
							.getValue() : 0);
					f0013.setPnndtp(txtField6.getValue() != null ? txtField6
							.getValue() : 0);
					f0013.setPnpxdd(txtField7.getValue() != null ? txtField7
							.getValue() : 0);
					f0013.setPndtpa(txtField8.getValue() != null ? txtField8
							.getValue() : 0);
					f0013.setPneir(txtField9.getValue() != null ? txtField9
							.getValue() : 0);
					f0013.setPnpxdm(txtField10.getValue() != null ? txtField10
							.getValue() : 0);
					f0013.setPnupmj(Convertidor
							.transformarGregorianoAJulia(fecha));
					f0013.setPnupmt(Double.valueOf(horaAuditoria));
					f0013.setPnuser(nombreUsuarioSesion());
					servicioF0014.guardar(f0013);
					Mensaje.mensajeInformacion(Mensaje.guardado);
					limpiar();
					listaGeneral = servicioF0014.buscarTodosOrdenados();
					catalogo.actualizarLista(listaGeneral);
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion(catalogo)) {
						final List<F0014> eliminarLista = catalogo
								.obtenerSeleccionados();
						if (!eliminarLista.isEmpty()) {
							Messagebox
									.show("¿Desea Eliminar los "
											+ eliminarLista.size()
											+ " Registros?",
											"Alerta",
											Messagebox.OK | Messagebox.CANCEL,
											Messagebox.QUESTION,
											new org.zkoss.zk.ui.event.EventListener<Event>() {
												public void onEvent(Event evt)
														throws InterruptedException {
													if (evt.getName().equals(
															"onOK")) {
														servicioF0014
																.eliminarVarios(eliminarLista);
														listaGeneral = servicioF0014
																.buscarTodosOrdenados();
														catalogo.actualizarLista(listaGeneral);
														Mensaje.mensajeInformacion(Mensaje.eliminado);
													}
												}
											});
						} else {
							Mensaje.mensajeAlerta(Mensaje.registroUtilizado);
						}
					}
				} else {
					/* Elimina un solo registro */
					if (clave != null) {
						Messagebox
								.show(Mensaje.deseaEliminar,
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													servicioF0014
															.eliminarUno(clave);
													Mensaje.mensajeInformacion(Mensaje.eliminado);
													limpiar();
													listaGeneral = servicioF0014
															.buscarTodosOrdenados();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					} else
						Mensaje.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}
			}

			@Override
			public void buscar() {
				abrirCatalogo();
			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}

			@Override
			public void annadir() {
				abrirRegistro();
				mostrarBotones(false);
			}
		};
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraF0014.appendChild(botonera);
	}

	@Listen("onClick = #gpxRegistro")
	public void abrirRegistro() {
		gpxDatos.setOpen(false);
		gpxRegistro.setOpen(true);
		mostrarBotones(false);
	}

	public void mostrarBotones(boolean bol) {
		botonera.getChildren().get(1).setVisible(!bol);
		botonera.getChildren().get(2).setVisible(bol);
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(0).setVisible(bol);
		botonera.getChildren().get(3).setVisible(!bol);
		botonera.getChildren().get(5).setVisible(!bol);
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
									habilitarTextClave();
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

	public void habilitarTextClave() {
		if (txtCodigo.isDisabled())
			txtCodigo.setDisabled(false);
	}

	public void limpiarCampos() {
		clave = null;
		txtCodigo.setValue("");
		txtDescripcion.setValue("");
		txtField1.setValue("");
		txtField2.setValue("");
		txtField3.setValue(null);
		txtField4.setValue(null);
		txtField5.setValue(null);
		txtField6.setValue(null);
		txtField7.setValue(null);
		txtField8.setValue(null);
		txtField9.setValue(null);
		txtField10.setValue(null);
		catalogo.limpiarSeleccion();
		txtCodigo.setFocus(true);
	}

	public boolean camposLLenos() {
		if (txtCodigo.getText().compareTo("") == 0
				|| txtDescripcion.getText().compareTo("") == 0) {
			return false;
		} else
			return true;
	}

	public boolean camposEditando() {
		if (txtCodigo.getText().compareTo("") != 0
				|| txtDescripcion.getText().compareTo("") != 0
				|| txtField1.getText().compareTo("") != 0
				|| txtField2.getText().compareTo("") != 0
				|| txtField3.getText().compareTo("") != 0
				|| txtField4.getText().compareTo("") != 0
				|| txtField5.getText().compareTo("") != 0
				|| txtField6.getText().compareTo("") != 0
				|| txtField7.getText().compareTo("") != 0
				|| txtField8.getText().compareTo("") != 0
				|| txtField9.getText().compareTo("") != 0
				|| txtField10.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected boolean validar() {
		if (claveSYExiste()) {
			return false;
		} else {
			if (!camposLLenos()) {
				Mensaje.mensajeError(Mensaje.camposVacios);
				return false;
			} else
				return true;
		}
	}

	private void mostrarCatalogo() {
		listaGeneral = servicioF0014.buscarTodosOrdenados();
		catalogo = new CatalogoGenerico<F0014>(catalogoF0014, "F0014",
				listaGeneral, false, false, false, "Codigo", "Descripcion") {

			@Override
			protected List<F0014> buscar(List<String> valores) {

				List<F0014> lista = new ArrayList<F0014>();

				for (F0014 f0004 : listaGeneral) {
					if (f0004.getPnptc().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& f0004.getPnptd().toLowerCase()
									.contains(valores.get(1).toLowerCase())) {
						lista.add(f0004);
					}
				}
				return lista;
			}

			@Override
			protected String[] crearRegistros(F0014 f0004) {
				String[] registros = new String[2];
				registros[0] = f0004.getPnptc();
				registros[1] = f0004.getPnptd();
				return registros;
			}
		};
		catalogo.setParent(catalogoF0014);
	}

	@Listen("onChange = #txtCodigo;onOK = #txtCodigo")
	public boolean claveSYExiste() {
		if (servicioF0014.buscar(txtCodigo.getValue()) != null
				&& (clave == null || !clave.equals(txtCodigo.getValue()))) {
			Mensaje.mensajeAlerta(Mensaje.claveUsada);
			txtCodigo.setFocus(true);
			return true;
		} else
			return false;
	}

}
