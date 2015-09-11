package servicio;

import interfacedao.IDetalleCotizacionDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SDetalleCotizacion")
public class SDetalleCotizacion {

	@Autowired
	private IDetalleCotizacionDAO detalleCotizacion;
}
