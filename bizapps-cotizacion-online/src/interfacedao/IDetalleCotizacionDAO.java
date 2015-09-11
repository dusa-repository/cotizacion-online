package interfacedao;

import modelo.DetalleCotizacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleCotizacionDAO extends
		JpaRepository<DetalleCotizacion, Integer> {

}
