package servicio;

import java.math.BigDecimal;
import java.util.List;

import interfacedao.IF554330DAO;
import modelo.F554330;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF554330")
public class SF554330 {

	@Autowired
	private IF554330DAO f554330DAO;

	public List<F554330> buscarPorExdocoAndExan8(BigDecimal bigDecimal,
			String an8) {
		return f554330DAO.findByIdExdocoAndIdExdctoAndIdExkcooAndIdexan8(
				bigDecimal, "OQ", "00300", new BigDecimal(an8));
	}

	public void guardar(F554330 f554330) {
		f554330DAO.saveAndFlush(f554330);
	}

	public void eliminarVarias(List<F554330> cabezas) {
		f554330DAO.delete(cabezas);
	}

}
