package servicio;

import interfacedao.ICabeceraCotizacionDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SCabeceraCotizacion")
public class SCabeceraCotizacion {

	@Autowired
	private ICabeceraCotizacionDAO	 cabeceraCotizacion;
}
