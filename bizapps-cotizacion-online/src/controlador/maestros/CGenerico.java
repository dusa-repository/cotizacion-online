package controlador.maestros;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import modelo.F00021;
import modelo.pk.F00021PK;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.XulElement;

import security.servicio.SGrupo;
import security.servicio.SUsuarioSeguridad;
import servicio.SCabeceraCotizacion;
import servicio.SDetalleCotizacion;
import servicio.SF00021;
import servicio.SF0004;
import servicio.SF0005;
import servicio.SF0013;
import servicio.SF0014;
import servicio.SF0101;
import servicio.SF4311;
import servicio.SF4330;
import servicio.SF4331;
import servicio.SF554330;
import servicio.SUsuario;
import componentes.Mensaje;
import componentes.buscadores.BuscadorUDC;
import componentes.catalogos.CatalogoGenerico;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public abstract class CGenerico extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@WireVariable("SF0004")
	protected SF0004 servicioF0004;
	@WireVariable("SF00021")
	protected SF00021 servicioF00021;
	@WireVariable("SF0005")
	protected SF0005 servicioF0005;
	@WireVariable("SF0013")
	protected SF0013 servicioF0013;
	@WireVariable("SF4311")
	protected SF4311 servicioF4311;
	@WireVariable("SF0101")
	protected SF0101 servicioF0101;
	@WireVariable("SF0014")
	protected SF0014 servicioF0014;
	@WireVariable("SF4331")
	protected SF4331 servicioF4331;
	@WireVariable("SCabeceraCotizacion")
	protected SCabeceraCotizacion servicioCabecera;
	@WireVariable("SDetalleCotizacion")
	protected SDetalleCotizacion servicioDetalleCotizacion;
	@WireVariable("SUsuario")
	protected SUsuario servicioUsuario;
	@WireVariable("SUsuarioSeguridad")
	protected SUsuarioSeguridad servicioUsuarioSeguridad;
	@WireVariable("SGrupo")
	protected SGrupo servicioGrupo;
	@WireVariable("SF554330")
	protected SF554330 servicioF554330;
	@WireVariable("SF4330")
	protected SF4330 servicioF4330;
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
	public static boolean nextNumber = true;
	public static double id = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		inicializar();
	}

	public static SF0004 getServicioF0004() {
		return applicationContext.getBean(SF0004.class);
	}

	public static SCabeceraCotizacion getServicioCabecera() {
		return applicationContext.getBean(SCabeceraCotizacion.class);
	}

	public static SDetalleCotizacion getServicioDetalle() {
		return applicationContext.getBean(SDetalleCotizacion.class);
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

	public String damePath() {
		return Executions.getCurrent().getContextPath() + "/";
	}

	public byte[] generarReporteGenerico(Map<String, Object> p, List<?> lista,
			String nombreReporte, String tipo) {
		byte[] fichero = null;
		JasperReport repor = null;
		try {
			repor = (JasperReport) JRLoader.loadObject(getClass().getResource(
					nombreReporte));
		} catch (JRException e1) {
			e1.printStackTrace();
		}

		if (tipo.equals("EXCEL")) {
			JasperPrint jasperPrint = null;
			try {
				jasperPrint = JasperFillManager.fillReport(repor, p,
						new JRBeanCollectionDataSource(lista));
			} catch (JRException e) {
				e.printStackTrace();
			}
			ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);
			try {
				exporter.exportReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
			return xlsReport.toByteArray();
		} else {
			try {
				fichero = JasperRunManager.runReportToPdf(repor, p,
						new JRBeanCollectionDataSource(lista));
			} catch (JRException e) {
				e.printStackTrace();
				Mensaje.mensajeError(e.getMessage());
			}
			return fichero;
		}
	}

	protected double nextNumber(String empresa, String doc, String descripcion) {
		synchronized (this) {
			while (!nextNumber) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			nextNumber = false;
			try {
				double numeroNext = servicioF00021.Numero(empresa, doc);
				if (numeroNext != 0) {
					id = numeroNext + 1;
					F00021 f021 = servicioF00021.buscar(empresa, doc);
					f021.setNln001(id);
					servicioF00021.guardar(f021);
				} else {
					id = 1;
					F00021 f021 = new F00021();
					F00021PK clave21 = new F00021PK();
					// clave21.setNldct(verificarUDC("00", "DT", doc,
					// descripcion,
					// 6));
					clave21.setNldct(doc);
					// clave21.setNlkco(servicioF0010.verificar(empresa));
					clave21.setNlkco(empresa);
					clave21.setNlctry((double) 0);
					clave21.setNlfy((double) 0);
					f021.setId(clave21);
					f021.setNln001(id);
					f021.setNlck01(descripcion);
					servicioF00021.guardar(f021);
				}
			} catch (Exception a) {
				nextNumber = true;
				a.printStackTrace();
				return 0;
			}
		}
		synchronized (this) {
			nextNumber = true;
			notify();
			return id;
		}
	}

	protected BuscadorUDC crearCampoUDC(Div div, String titulo,
			boolean requerido, String valor1, String valor2, String ancho1,
			String ancho2, String ancho3, String ancho4) {
		BuscadorUDC buscador = new BuscadorUDC(titulo, 10, requerido, valor1,
				valor2, servicioF0005, ancho1, ancho2, ancho3, ancho4);
		div.appendChild(buscador);
		return buscador;
	}

	public List<String> obtenerPropiedades() {
		List<String> arreglo = new ArrayList<String>();
		DriverManagerDataSource ds = (DriverManagerDataSource) applicationContext
				.getBean("dataSource");
		arreglo.add(ds.getUsername());
		arreglo.add(ds.getPassword());
		arreglo.add(ds.getUrl());
		return arreglo;
	}

}
