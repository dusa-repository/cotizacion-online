package servicio;

import java.util.List;

import interfacedao.IF4331DAO;
import modelo.F4331;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4331")
public class SF4331 {

	@Autowired
	private IF4331DAO f4331DAO;

	public List<F4331> buscarPorDocAn8Linea(String numeroCotizacion,
			String an8, Integer numLinea) {
		return f4331DAO.findByIdp1docoAndIdp1an8AndIdp1lnid(
				Double.valueOf(numeroCotizacion), Double.valueOf(an8),
				numLinea.doubleValue());
	}

	public void eliminarVarios(List<F4331> objetos) {
		f4331DAO.delete(objetos);
	}

	public void guardar(F4331 objeto) {
		f4331DAO.save(objeto);
	}
}
