package interfacedao;

import java.util.List;

import modelo.F00165;
import modelo.pk.F00165PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF00165DAO extends JpaRepository<F00165, F00165PK> {

	List<F00165> findByIdGdtxky(String valor);

	List<F00165> findByIdGdtxkyLike(String string);
	
}
