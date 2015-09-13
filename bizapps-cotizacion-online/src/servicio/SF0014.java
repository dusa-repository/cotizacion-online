package servicio;

import java.util.List;

import interfacedao.IF0014DAO;

import modelo.F0014;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0014")
public class SF0014 {

	@Autowired
	private IF0014DAO f0014DAO;

	public List<F0014> buscarTodosOrdenados() {
		return f0014DAO.findAll();
	}

	public void guardar(F0014 f0014) {
		f0014DAO.save(f0014);
	}

	public void eliminarVarios(List<F0014> eliminarLista) {
		f0014DAO.delete(eliminarLista);
	}

	public void eliminarUno(String clave) {
		f0014DAO.delete(clave);
	}

	public F0014 buscar(String value) {
		return f0014DAO.findOne(value);
	}
}
