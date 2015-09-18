package servicio;

import java.util.List;

import interfacedao.IF4311DAO;
import modelo.F4311;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4311")
public class SF4311 {

	@Autowired
	private IF4311DAO f4311DAO;

	public List<F4311> buscarNoExistentes(String numeroCotizacion, String an8) {
		return f4311DAO.findByAn8AndDocoPendiente(an8, numeroCotizacion);
	}

}
