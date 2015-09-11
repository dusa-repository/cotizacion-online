package interfacedao;

import modelo.CabeceraCotizacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICabeceraCotizacionDAO extends
		JpaRepository<CabeceraCotizacion, Integer> {

}
