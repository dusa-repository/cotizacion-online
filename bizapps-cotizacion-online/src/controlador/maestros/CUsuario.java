package controlador.maestros;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import modelo.F0101;
import modelo.Usuario;

import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.West;

import componentes.Botonera;
import componentes.CatalogoF0101;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;
import componentes.utils.Validador;
import security.controlador.CArbol;
import security.modelo.Grupo;
import security.modelo.UsuarioSeguridad;

public class CUsuario extends CGenerico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	private Div divUsuario;
	@Wire
	private Div divCatalogoF0101;;
	@Wire
	private Longbox txtF0101;
	@Wire
	private Label lblF0101;
	@Wire
	private Div botoneraUsuario;
	@Wire
	private Div catalogoUsuario;
	@Wire
	private Textbox txtNombre;
	@Wire
	private Textbox txtApellido;
	@Wire
	private Textbox txtCorreo;
	@Wire
	private Textbox txtLoginUsuario;
	@Wire
	private Textbox txtPasswordUsuario;
	@Wire
	private Textbox txtPassword2Usuario;
	@Wire
	private Listbox ltbGruposDisponibles;
	@Wire
	private Listbox ltbGruposAgregados;
	@Wire
	private Groupbox gpxDatos;
	@Wire
	private Groupbox gpxRegistro;
	@Wire
	private Image imagen;
	@Wire
	private Button fudImagenUsuario;
	@Wire
	private Media media;
	String id = "";
	CatalogoGenerico<F0101> catalogoF0101;
	CatalogoGenerico<Usuario> catalogo;
	protected List<Usuario> listaGeneral = new ArrayList<Usuario>();
	List<Grupo> gruposDisponibles = new ArrayList<Grupo>();
	List<Grupo> gruposOcupados = new ArrayList<Grupo>();
	URL url = getClass().getResource("/security/controlador/usuario.png");
	CArbol cArbol = new CArbol();
	Botonera botonera;

	@SuppressWarnings("unchecked")
	@Override
	public void inicializar() throws IOException {
		HashMap<String, Object> mapa = (HashMap<String, Object>) Sessions
				.getCurrent().getAttribute("mapaGeneral");
		if (mapa != null) {
			if (mapa.get("tabsGenerales") != null) {
				titulo = (String) mapa.get("titulo");
				tabs = (List<Tab>) mapa.get("tabsGenerales");
				mapa.clear();
				mapa = null;
			}
		}
		llenarListas(null);
		mostrarCatalogo();
		try {
			imagen.setContent(new AImage(url));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		gpxRegistro.setOpen(false);
		botonera = new Botonera() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void salir() {
				cerrarVentana(divUsuario, titulo, tabs);
			}

			@Override
			public void limpiar() {
				mostrarBotones(false);
				limpiarCampos();
			}

			@Override
			public void guardar() {
				if (validar()) {
					if (buscarPorLogin()) {
						Set<Grupo> gruposUsuario = new HashSet<Grupo>();
						for (int i = 0; i < ltbGruposAgregados.getItemCount(); i++) {
							Grupo grupo = ltbGruposAgregados.getItems().get(i)
									.getValue();
							gruposUsuario.add(grupo);
						}
						String correo = txtCorreo.getValue();
						String login = txtLoginUsuario.getValue();
						String password = txtPasswordUsuario.getValue();
						String nombre = txtNombre.getValue();
						byte[] imagenUsuario = null;
						if (media instanceof org.zkoss.image.Image) {
							imagenUsuario = imagen.getContent().getByteData();

						} else {
							try {
								imagen.setContent(new AImage(url));
							} catch (IOException e) {
								e.printStackTrace();
							}
							imagenUsuario = imagen.getContent().getByteData();
						}
						String an8 = null;
						if (txtF0101.getValue() != null)
							an8 = txtF0101.getValue().toString();
						Usuario usuario = new Usuario();
						usuario.setIdUsuario(login);
						usuario.setAn8(an8);
						usuario.setIdEmail(correo);
						usuario.setNombre(nombre);
						usuario.setPassword(password);
						usuario.setRol("");
						servicioUsuario.guardar(usuario);
						guardarDatosSeguridad(usuario, gruposUsuario,
								imagenUsuario);
						limpiar();
						listaGeneral = servicioUsuario.buscarTodos();
						catalogo.actualizarLista(listaGeneral);
						Mensaje.mensajeInformacion(Mensaje.guardado);
					}
				}
			}

			@Override
			public void eliminar() {
				if (gpxDatos.isOpen()) {
					/* Elimina Varios Registros */
					if (validarSeleccion()) {
						final List<Usuario> eliminarLista = catalogo
								.obtenerSeleccionados();
						Messagebox
								.show("¿Desea Eliminar los "
										+ eliminarLista.size() + " Registros?",
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													List<UsuarioSeguridad> lista = new ArrayList<UsuarioSeguridad>();
													for (int i = 0; i < eliminarLista
															.size(); i++) {
														lista.add(servicioUsuarioSeguridad
																.buscarPorLogin(eliminarLista
																		.get(i)
																		.getIdUsuario()));
													}
													for (int i = 0; i < lista
															.size(); i++) {
														lista.get(i).setEstado(
																false);
													}
													servicioUsuarioSeguridad
															.guardarVarios(lista);
													servicioUsuario
															.eliminarVarios(eliminarLista);
													Mensaje.mensajeInformacion(Mensaje.eliminado);
													listaGeneral = servicioUsuario
															.buscarTodos();
													catalogo.actualizarLista(listaGeneral);
												}
											}
										});
					}
				} else {
					if (!id.equals("")) {
						Messagebox
								.show("¿Esta Seguro de Eliminar el Usuario?",
										"Alerta",
										Messagebox.OK | Messagebox.CANCEL,
										Messagebox.QUESTION,
										new org.zkoss.zk.ui.event.EventListener<Event>() {
											public void onEvent(Event evt)
													throws InterruptedException {
												if (evt.getName()
														.equals("onOK")) {
													UsuarioSeguridad usuario = servicioUsuarioSeguridad
															.buscarPorLogin(id);
													usuario.setEstado(false);
													servicioUsuarioSeguridad
															.guardar(usuario);
													servicioUsuario
															.eliminar(id);
													limpiar();
													Mensaje.mensajeInformacion(Mensaje.eliminado);
												}
											}
										});
					} else
						Mensaje.mensajeAlerta(Mensaje.noSeleccionoRegistro);
				}
			}

			@Override
			public void seleccionar() {
				if (validarSeleccion()) {
					if (catalogo.obtenerSeleccionados().size() == 1) {
						mostrarBotones(false);
						abrirRegistro();
						Usuario usuario = catalogo
								.objetoSeleccionadoDelCatalogo();
						llenarCampos(usuario);
						llenarListas(usuario);
					} else
						Mensaje.mensajeAlerta(Mensaje.editarSoloUno);
				}
			}

			@Override
			public void buscar() {
				abrirCatalogo();
			}

			@Override
			public void annadir() {
				abrirRegistro();
				mostrarBotones(false);
			}

			@Override
			public void reporte() {
				// TODO Auto-generated method stub

			}

			@Override
			public void ayuda() {
				// TODO Auto-generated method stub

			}
		};
		botonera.getChildren().get(6).setVisible(false);
		botonera.getChildren().get(8).setVisible(false);
		botonera.getChildren().get(1).setVisible(false);
		botonera.getChildren().get(3).setVisible(false);
		botonera.getChildren().get(5).setVisible(false);
		botoneraUsuario.appendChild(botonera);
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

	public boolean camposEditando() {
		if (txtApellido.getText().compareTo("") != 0
				|| txtLoginUsuario.getText().compareTo("") != 0
				|| txtPasswordUsuario.getText().compareTo("") != 0
				|| txtPassword2Usuario.getText().compareTo("") != 0
				|| txtNombre.getText().compareTo("") != 0) {
			return true;
		} else
			return false;
	}

	protected void limpiarCampos() {
		txtF0101.setValue(null);
		lblF0101.setValue("");
		gruposDisponibles.clear();
		gruposOcupados.clear();
		ltbGruposAgregados.getItems().clear();
		ltbGruposDisponibles.getItems().clear();
		txtLoginUsuario.setValue("");
		txtPasswordUsuario.setValue("");
		txtPassword2Usuario.setValue("");
		txtApellido.setValue("");
		txtNombre.setValue("");
		txtCorreo.setValue("");
		try {
			imagen.setContent(new AImage(url));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		id = "";
		llenarListas(null);
		catalogo.limpiarSeleccion();
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

	protected boolean validarSeleccion() {
		List<Usuario> seleccionados = catalogo.obtenerSeleccionados();
		if (seleccionados == null) {
			Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			return false;
		} else {
			if (seleccionados.isEmpty()) {
				Mensaje.mensajeAlerta(Mensaje.noSeleccionoItem);
				return false;
			} else {
				return true;
			}
		}
	}

	private void mostrarCatalogo() {
		listaGeneral = servicioUsuario.buscarTodos();
		catalogo = new CatalogoGenerico<Usuario>(catalogoUsuario, "Usuario",
				listaGeneral, false, "idUsuario", "Nombre", "Correo",
				"Direccion") {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			protected List<Usuario> buscar(List<String> valores) {

				List<Usuario> user = new ArrayList<Usuario>();

				for (Usuario actividadord : listaGeneral) {
					String estado = "";
					if (actividadord.getAn8() != null)
						estado = String.valueOf(actividadord.getAn8());
					if (actividadord.getIdUsuario().toLowerCase()
							.contains(valores.get(0).toLowerCase())
							&& actividadord.getNombre().toLowerCase()
									.contains(valores.get(1).toLowerCase())
							&& actividadord.getIdEmail().toLowerCase()
									.contains(valores.get(2).toLowerCase())
							&& estado.toLowerCase().contains(
									valores.get(3).toLowerCase())) {

						user.add(actividadord);
					}
				}
				return user;
			}

			@Override
			protected String[] crearRegistros(Usuario usuarios) {
				String estado = "";
				if (usuarios.getAn8() != null)
					estado = String.valueOf(usuarios.getAn8());
				String[] registros = new String[4];
				registros[0] = usuarios.getIdUsuario();
				registros[1] = usuarios.getNombre();
				registros[2] = usuarios.getIdEmail();
				registros[3] = estado;
				return registros;
			}

		};
		catalogo.setParent(catalogoUsuario);
	}

	/* Validaciones de pantalla para poder realizar el guardar */
	public boolean validar() {
		if (txtApellido.getText().compareTo("") == 0
				|| txtCorreo.getText().compareTo("") == 0
				|| txtLoginUsuario.getText().compareTo("") == 0
				|| txtNombre.getText().compareTo("") == 0
				|| txtPassword2Usuario.getText().compareTo("") == 0
				|| txtPasswordUsuario.getText().compareTo("") == 0) {
			Mensaje.mensajeError(Mensaje.camposVacios);
			return false;
		} else {
			if (!Validador.validarCorreo(txtCorreo.getValue())) {
				Mensaje.mensajeError(Mensaje.correoInvalido);
				return false;
			} else {
				if (!txtPasswordUsuario.getValue().equals(
						txtPassword2Usuario.getValue())) {
					Mensaje.mensajeError(Mensaje.contrasennasNoCoinciden);
					return false;
				} else
					return true;
			}
		}
	}

	/* Valida que los passwords sean iguales */
	@Listen("onChange = #txtPassword2Usuario")
	public void validarPassword() {
		if (!txtPasswordUsuario.getValue().equals(
				txtPassword2Usuario.getValue())) {
			Mensaje.mensajeAlerta(Mensaje.contrasennasNoCoinciden);
		}
	}

	/* Valida el correo electronico */
	@Listen("onChange = #txtCorreoUsuario")
	public void validarCorreo() {
		if (!Validador.validarCorreo(txtCorreo.getValue())) {
			Mensaje.mensajeAlerta(Mensaje.correoInvalido);
		}
	}

	/* LLena las listas dado un usario */
	public void llenarListas(Usuario usuario) {
		UsuarioSeguridad user = null;
		if (usuario != null)
			user = servicioUsuarioSeguridad.buscarPorLogin(usuario
					.getIdUsuario());
		gruposDisponibles = servicioGrupo.buscarTodos();
		if (usuario == null) {
			ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
					gruposDisponibles));
		} else {
			gruposOcupados = servicioGrupo.buscarGruposDelUsuario(user);
			ltbGruposAgregados
					.setModel(new ListModelList<Grupo>(gruposOcupados));
			if (!gruposOcupados.isEmpty()) {
				List<Long> ids = new ArrayList<Long>();
				for (int i = 0; i < gruposOcupados.size(); i++) {
					long id = gruposOcupados.get(i).getIdGrupo();
					ids.add(id);
				}
				gruposDisponibles = servicioGrupo.buscarGruposDisponibles(ids);
				ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
						gruposDisponibles));
			}
		}
		ltbGruposAgregados.setMultiple(false);
		ltbGruposAgregados.setCheckmark(false);
		ltbGruposAgregados.setMultiple(true);
		ltbGruposAgregados.setCheckmark(true);

		ltbGruposDisponibles.setMultiple(false);
		ltbGruposDisponibles.setCheckmark(false);
		ltbGruposDisponibles.setMultiple(true);
		ltbGruposDisponibles.setCheckmark(true);
	}

	/* Permite subir una imagen a la vista */
	@Listen("onUpload = #fudImagenUsuario")
	public void processMedia(UploadEvent event) {
		media = event.getMedia();
		imagen.setContent((org.zkoss.image.Image) media);

	}

	/*
	 * Permite mover uno o varios elementos seleccionados desde la lista de la
	 * izquierda a la lista de la derecha
	 */
	@Listen("onClick = #pasar1")
	public void moverDerecha() {
		// gruposDisponibles = servicioGrupo.buscarTodos();
		List<Listitem> listitemEliminar = new ArrayList<Listitem>();
		List<Listitem> listItem = ltbGruposDisponibles.getItems();
		if (listItem.size() != 0) {
			for (int i = 0; i < listItem.size(); i++) {
				if (listItem.get(i).isSelected()) {
					Grupo grupo = listItem.get(i).getValue();
					gruposDisponibles.remove(grupo);
					gruposOcupados.add(grupo);
					ltbGruposAgregados.setModel(new ListModelList<Grupo>(
							gruposOcupados));
					listitemEliminar.add(listItem.get(i));
				}
			}
		}
		for (int i = 0; i < listitemEliminar.size(); i++) {
			ltbGruposDisponibles.removeItemAt(listitemEliminar.get(i)
					.getIndex());
		}
		ltbGruposAgregados.setMultiple(false);
		ltbGruposAgregados.setCheckmark(false);
		ltbGruposAgregados.setMultiple(true);
		ltbGruposAgregados.setCheckmark(true);
	}

	/*
	 * Permite mover uno o varios elementos seleccionados desde la lista de la
	 * derecha a la lista de la izquierda
	 */
	@Listen("onClick = #pasar2")
	public void moverIzquierda() {
		List<Listitem> listitemEliminar = new ArrayList<Listitem>();
		List<Listitem> listItem2 = ltbGruposAgregados.getItems();
		if (listItem2.size() != 0) {
			for (int i = 0; i < listItem2.size(); i++) {
				if (listItem2.get(i).isSelected()) {
					Grupo grupo = listItem2.get(i).getValue();
					gruposOcupados.remove(grupo);
					gruposDisponibles.add(grupo);
					ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
							gruposDisponibles));
					listitemEliminar.add(listItem2.get(i));
				}
			}
		}
		for (int i = 0; i < listitemEliminar.size(); i++) {
			ltbGruposAgregados.removeItemAt(listitemEliminar.get(i).getIndex());
		}
		ltbGruposDisponibles.setMultiple(false);
		ltbGruposDisponibles.setCheckmark(false);
		ltbGruposDisponibles.setMultiple(true);
		ltbGruposDisponibles.setCheckmark(true);
	}

	/* Busca si existe un usuario con el mismo login */
	@Listen("onChange = #txtLoginUsuario; onOK = #txtLoginUsuario")
	public boolean buscarPorLogin() {
		if (txtLoginUsuario.getValue() != null) {
			if (txtLoginUsuario.getValue().length() > 13) {
				txtLoginUsuario.setValue(txtLoginUsuario.getValue().replaceAll("\\s+",""));
				Mensaje.mensajeAlerta("Se ha modificado el tamaño del login del usuario ya que el tamaño maximo permitido es de 12 caracteres, por favor verifique el nuevo valor");
			}
		}
		UsuarioSeguridad usuario = servicioUsuarioSeguridad
				.buscarPorLogin(txtLoginUsuario.getValue());
		if (usuario == null)
			return true;
		else {
			if (usuario.getLogin().equals(id))
				return true;
			else {
				Mensaje.mensajeAlerta(Mensaje.loginUsado);
				txtLoginUsuario.setValue("");
				txtLoginUsuario.setFocus(true);
				return false;
			}
		}
	}

	/* LLena los campos del formulario dado un usuario */
	public void llenarCampos(Usuario usuario) {
		txtCorreo.setValue(usuario.getIdEmail());
		if (usuario.getIdUsuario().replaceAll("\\s+","").length() > 13) {
			txtLoginUsuario.setValue(usuario.getIdUsuario().replaceAll("\\s+",""));
			Mensaje.mensajeAlerta("Se ha modificado el tamaño del login del usuario ya que el tamaño maximo permitido es de 12 caracteres, por favor verifique el nuevo valor");
		} else
			txtLoginUsuario.setValue(usuario.getIdUsuario().replaceAll("\\s+",""));
		txtPasswordUsuario.setValue(usuario.getPassword());
		txtPassword2Usuario.setValue(usuario.getPassword());
		txtNombre.setValue(usuario.getNombre());
		id = usuario.getIdUsuario();
		if (usuario.getAn8() != null) {
			F0101 object = servicioF0101
					.buscar(Double.valueOf(usuario.getAn8()));
			Double doble = object.getAban8();
			txtF0101.setValue(doble.longValue());
			lblF0101.setValue(object.getAbalph());
		}
		UsuarioSeguridad user = servicioUsuarioSeguridad.buscarPorLogin(usuario
				.getIdUsuario());
		if (user != null) {
			txtApellido.setValue(user.getApellido());
			BufferedImage imag;
			if (user.getImagen() != null) {
				try {
					imag = ImageIO.read(new ByteArrayInputStream(user
							.getImagen()));
					imagen.setContent(imag);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		llenarListas(usuario);
	}

	public void recibirGrupo(List<Grupo> lista, Listbox l) {
		ltbGruposDisponibles = l;
		gruposDisponibles = lista;
		ltbGruposDisponibles.setModel(new ListModelList<Grupo>(
				gruposDisponibles));
		ltbGruposDisponibles.setMultiple(false);
		ltbGruposDisponibles.setCheckmark(false);
		ltbGruposDisponibles.setMultiple(true);
		ltbGruposDisponibles.setCheckmark(true);
	}

	@Listen("onClick = #btnBuscarF0101")
	public void mostrarCatalogoF0101(Event event) {
		List<F0101> direcciones = servicioF0101.buscarTodosOrdenados();
		catalogoF0101 = new CatalogoF0101(divCatalogoF0101,
				"Catalogo de Direcciones", direcciones, true, "Nº direccion",
				"Nombre alfabetico", "Direccion larga",
				"Clasificacion industria", "Tipo bus", "ID fiscal");
		catalogoF0101.setParent(divCatalogoF0101);
		catalogoF0101.doModal();
	}

	@Listen("onSeleccion = #divCatalogoF0101")
	public void seleccionarCatalogoDireccion() {
		F0101 f0101 = catalogoF0101.objetoSeleccionadoDelCatalogo();
		setearDireccion(f0101, txtF0101, lblF0101);
		catalogoF0101.setParent(null);
	}

	private void setearDireccion(F0101 f0101, Longbox txt, Label lbl) {
		Double doble = f0101.getAban8();
		txt.setValue(doble.longValue());
		lbl.setValue(f0101.getAbalph());
	}

	@Listen("onChange = #txtF0101; onOK = #txtF0101")
	public void buscarNombre(Event evento) {
		Longbox target = (Longbox) evento.getTarget();
		if (target.getValue() != null) {
			F0101 f0101 = servicioF0101.buscar(target.getValue());
			if (f0101 != null) {
				setearDireccion(f0101, txtF0101, lblF0101);
			} else {
				txtF0101.setValue(null);
				lblF0101.setValue("");
				Mensaje.mensajeAlerta(Mensaje.noHayRegistros);
			}
		}
	}

	public void guardarDatosSeguridad(Usuario usuarioLogica,
			Set<Grupo> gruposUsuario, byte[] imagen) {
		UsuarioSeguridad usuario = servicioUsuarioSeguridad
				.buscarPorLogin(usuarioLogica.getIdUsuario());
		if (usuario != null) {
			usuario.setGrupos(null);
			servicioUsuarioSeguridad.guardar(usuario);
		}
		usuario = new UsuarioSeguridad(usuarioLogica.getIdUsuario(),
				usuarioLogica.getIdEmail(), usuarioLogica.getPassword(),
				imagen, true, usuarioLogica.getNombre(),
				txtApellido.getValue(), fechaHora, horaAuditoria,
				nombreUsuarioSesion(), gruposUsuario);
		servicioUsuarioSeguridad.guardar(usuario);
	}

}
