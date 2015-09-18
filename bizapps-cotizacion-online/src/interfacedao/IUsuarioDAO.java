package interfacedao;

import java.util.List;

import modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDAO extends JpaRepository<Usuario, String>{

	List<Usuario> findByAn8(String valueOf);

}
