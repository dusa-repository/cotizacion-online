package servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfacedao.IF00165DAO;
import interfacedao.IF0101DAO;
import interfacedao.IF554330DAO;
import modelo.CabeceraCotizacion;
import modelo.F00165;
import modelo.F0101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import componentes.utils.Convertidor;

@Service("SCabeceraCotizacion")
public class SCabeceraCotizacion {

	@Autowired
	private IF554330DAO f554330DAO;
	@Autowired
	private IF0101DAO f0101DAO;
	@Autowired
	private IF00165DAO f00165DAO;

	public List<CabeceraCotizacion> buscar(String an8, String estado) {
		List<Object[]> lista = f554330DAO.buscar(an8, estado);
		List<CabeceraCotizacion> cabezas = new ArrayList<CabeceraCotizacion>();
		for (int i = 0; i < lista.size(); i++) {
			Object[] objeto = lista.get(i);
			CabeceraCotizacion head = new CabeceraCotizacion();
			head.setNumCotizacion((String) objeto[0]);
			head.setFechaEmision(Convertidor.formatoFecha2.format(Convertidor
					.transformarJulianaAGregoria(new BigDecimal(
							(String) objeto[1]))));
			head.setFechaVencimiento(Convertidor.formatoFecha2
					.format(Convertidor
							.transformarJulianaAGregoria(new BigDecimal(
									(String) objeto[2]))));
			String responsable = "N/A";
			List<F0101> objet = f0101DAO.findInSeller(Double
					.valueOf((String) objeto[0]));
			if (!objet.isEmpty())
				responsable = objet.get(0).getAbalph();
			head.setResponsable(responsable);
			head.setDiasEntrega(Convertidor.restarFechas(Convertidor
					.transformarJulianaAGregoria(new BigDecimal(
							(String) objeto[2]))));
			String estado2 = (String) objeto[3];
			if (estado2.trim().compareTo("") == 0)
				head.setEstado("Pendiente");
			else
				head.setEstado(estado2);
			String anexo = "";
			List<F00165> objet2 = f00165DAO.findByIdGdtxky(head
					.getNumCotizacion().replace(".0", "") + "|OQ|00300|000");
			if (!objet2.isEmpty())
				anexo = objet2.get(0).getGdtxft();
			head.setAnexo(anexo);
			head.setPublicado((String) objeto[4]);
			cabezas.add(head);
		}
		return cabezas;
	}
}
