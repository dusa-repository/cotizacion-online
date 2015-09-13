package servicio;

import java.util.ArrayList;
import java.util.List;

import interfacedao.ICabeceraCotizacionDAO;

import modelo.CabeceraCotizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("SCabeceraCotizacion")
public class SCabeceraCotizacion {

	@Autowired
	private ICabeceraCotizacionDAO	 cabeceraCotizacion;

	public List<CabeceraCotizacion> buscarTodosOrdenados(String string) {
		List<String> ordenar = new ArrayList<String>();
		ordenar.add("numCotizacion");
		ordenar.add("fechaEmision");
		ordenar.add("estado");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return cabeceraCotizacion.findByEstadoLike(string, o);
	}
}
