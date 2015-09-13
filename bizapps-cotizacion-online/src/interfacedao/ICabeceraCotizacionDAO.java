package interfacedao;

import java.util.List;

import modelo.CabeceraCotizacion;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICabeceraCotizacionDAO extends
		JpaRepository<CabeceraCotizacion, Integer> {

	List<CabeceraCotizacion> findByEstadoLike(String string, Sort o);

}
