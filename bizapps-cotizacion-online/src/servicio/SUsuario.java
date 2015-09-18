package servicio;

import java.util.List;

import interfacedao.IUsuarioDAO;
import modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("SUsuario")
public class SUsuario {

	@Autowired
	private IUsuarioDAO usuario;

	public Usuario buscarPorId(String login) {
		return usuario.findOne(login);
	}

	public List<Usuario> buscarTodos() {
		return usuario.findAll(new Sort(Direction.ASC, "idUsuario", "nombre"));
	}

	public void eliminarVarios(List<Usuario> eliminarLista) {
		usuario.delete(eliminarLista);
	}

	public void eliminar(String id) {
		usuario.delete(id);
	}

	public void guardar(Usuario usuario2) {
		usuario.save(usuario2);
	}

	public List<Usuario> buscarPorMcan8(double aban8) {
		return usuario.findByAn8(String.valueOf(aban8));
	}
}
