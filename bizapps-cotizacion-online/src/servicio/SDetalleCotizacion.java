package servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfacedao.IF00165DAO;
import interfacedao.IF4311DAO;
import interfacedao.IF4331DAO;
import modelo.DetalleCotizacion;
import modelo.F00165;
import modelo.F4311;
import modelo.F4331;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import componentes.utils.Convertidor;

@Service("SDetalleCotizacion")
public class SDetalleCotizacion {

	@Autowired
	private IF4311DAO f4311DAO;
	@Autowired
	private IF4331DAO f4331DAO;
	@Autowired
	private IF00165DAO f00165DAO;

	public List<DetalleCotizacion> buscar(String an8, String num, String welche) {
		List<DetalleCotizacion> listaDetalles = new ArrayList<DetalleCotizacion>();
		List<F4311> lista = new ArrayList<F4311>();
		if (welche.equals("p"))
			lista = f4311DAO.findByAn8AndDocoPendiente(an8, num);
		else {
			if (welche.endsWith("c"))
				lista = f4311DAO.findByAn8AndDocoCargada(an8, num);
			else
				lista = f4311DAO.findByAn8AndDocoTodas(an8, num);
		}
		for (int i = 0; i < lista.size(); i++) {
			F4311 objeto = lista.get(i);
			DetalleCotizacion detalle = new DetalleCotizacion();
			detalle.setNumCotizacion(objeto.getId().getPddoco().intValue());
			detalle.setNumLinea(objeto.getId().getPdlnid().intValue());
			detalle.setIdArticulo(objeto.getPditm());
			detalle.setDescripcion(objeto.getPddsc1());
			detalle.setDescripcion2(objeto.getPddsc2());
			detalle.setUm(objeto.getPduom());
			detalle.setCantidadEncargada(objeto.getPduorg().intValue());
			Double precio = (double) 0;
			String estado = "Pendiente";
			String moneda = "N/A";
			Date fechaVencimiento = new Date();
			List<F4331> precios = f4331DAO.findByIdp1docoAndIdp1an8AndIdp1lnid(
					Double.valueOf(num), Double.valueOf(an8), objeto.getId()
							.getPdlnid());
			if (!precios.isEmpty()) {
				precio = precios.get(0).getP1prrc();
				moneda = precios.get(0).getP1crcd();
				fechaVencimiento = Convertidor
						.transformarJulianaAGregoria(precios.get(0).getP1cndj());
				if (precios.get(0).getPublicado() != null)
					if (precios.get(0).getPublicado())
						estado = "Cargada";
			}
			detalle.setFecha(fechaVencimiento);
			detalle.setPrecioUnitario(precio);
			detalle.setTotal(precio * detalle.getCantidadEncargada());
			detalle.setDiasEntrega(0);
			String publicado = "NO";
			if (objeto.getPublicado() != null)
				if (objeto.getPublicado())
					publicado = "SI";
			detalle.setPublicado(publicado);
			detalle.setEstado(estado);
			detalle.setMoneda(moneda);
			String anexo = "N/A";
			List<F00165> lista2 = f00165DAO.findByIdGdtxkyLike("%" + num
					+ "|00300|OQ|000|%");
			for (int j = 0; j < lista2.size(); j++) {
				F00165 klein = lista2.get(j);
				String txky = klein.getId().getGdtxky();
				int desde = txky.indexOf("|", 15);
				String numeroL = txky.substring(desde + 1, txky.length())
						.replaceAll(".000", "");
				if (numeroL.compareTo(String.valueOf(objeto.getId().getPdlnid()
						.intValue())) == 0) {
					anexo = klein.getGdtxft();
					j = lista2.size();
				}
			}
			detalle.setAnexo(anexo);
			listaDetalles.add(detalle);
		}
		return listaDetalles;
	}

}
