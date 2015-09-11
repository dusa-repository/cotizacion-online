package controlador.maestros;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.XulElement;

import servicio.SCabeceraCotizacion;
import servicio.SDetalleCotizacion;
import servicio.SF0004;
import servicio.SF0005;
import servicio.SF0013;
import servicio.SF0014;
import componentes.Mensaje;
import componentes.catalogos.CatalogoGenerico;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public abstract class CGenerico extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@WireVariable("SF0004")
	protected SF0004 servicioF0004;
	@WireVariable("SF0005")
	protected SF0005 servicioF0005;
	@WireVariable("SF0013")
	protected SF0013 servicioF0013;
	@WireVariable("SF0014")
	protected SF0014 servicioF0014;
	@WireVariable("SCabeceraCotizacion")
	protected SCabeceraCotizacion servicioCabecera;
	@WireVariable("SDetalleCotizacion")
	protected SDetalleCotizacion servicioDetalleCotizacion;
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"/META-INF/ConfiguracionAplicacion.xml");
	public List<Tab> tabs = new ArrayList<Tab>();
	protected DateFormat df = new SimpleDateFormat("HH:mm:ss");
	public Calendar calendario = Calendar.getInstance();
	public String titulo = "";
	public Long idArbol;
	public String horaAuditoria = String.valueOf(calendario
			.get(Calendar.HOUR_OF_DAY))
			+ String.valueOf(calendario.get(Calendar.MINUTE))
			+ String.valueOf(calendario.get(Calendar.SECOND));
	public java.util.Date fecha = new Date();
	public Timestamp fechaHora = new Timestamp(fecha.getTime());

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		inicializar();
	}

	public static SF0004 getServicioF0004() {
		return applicationContext.getBean(SF0004.class);
	}

	public void settearTituo(Div div, long idNuevo) {
		XulElement componente = (XulElement) div.getChildren().get(0);
		if (componente instanceof Groupbox) {
			Groupbox comp = (Groupbox) componente;
			String nombre = comp.getTitle();
			comp.setTitle(nombre + " ID Vista: " + idNuevo);
		}
	}

	public abstract void inicializar() throws IOException;

	public void cerrarVentana(Div div, String id, List<Tab> tabs2) {
		div.setVisible(false);
		tabs = tabs2;
		for (int i = 0; i < tabs.size(); i++) {
			if (tabs.get(i).getLabel().equals(id)) {
				if (i == (tabs.size() - 1) && tabs.size() > 1) {
					tabs.get(i - 1).setSelected(true);
				}
				tabs.get(i).onClose();
				tabs.remove(i);
			}
		}
	}

	public String nombreUsuarioSesion() {
		Authentication sesion = SecurityContextHolder.getContext()
				.getAuthentication();
		return sesion.getName();
	}

	public boolean validarSeleccion(CatalogoGenerico<?> catalogo) {
		List<?> seleccionados = catalogo.obtenerSeleccionados();
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

}
