package servicio;

import java.util.ArrayList;
import java.util.List;

import interfacedao.IDetalleCotizacionDAO;

import modelo.DetalleCotizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("SDetalleCotizacion")
public class SDetalleCotizacion {

	@Autowired
	private IDetalleCotizacionDAO detalleCotizacion;

	public List<DetalleCotizacion> buscarPorCabeceraYEstado(
			String numCotizacion, String string) {
		List<String> ordenar = new ArrayList<String>();
		ordenar.add("numLinea");
		ordenar.add("idArticulo");
		Sort o = new Sort(Sort.Direction.ASC, ordenar);
		return detalleCotizacion.findByNumCotizacionAndEstadoLike(
				Integer.valueOf(numCotizacion), string, o);
	}
}
