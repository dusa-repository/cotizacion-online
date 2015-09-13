package interfacedao;

import java.util.List;

import modelo.DetalleCotizacion;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleCotizacionDAO extends
		JpaRepository<DetalleCotizacion, Integer> {

	List<DetalleCotizacion> findByNumCotizacionAndEstadoLike(Integer valueOf,
			String string, Sort o);

}
