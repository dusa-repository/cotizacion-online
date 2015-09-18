package interfacedao;

import java.util.List;

import modelo.F4331;
import modelo.pk.F4331PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4331DAO extends JpaRepository<F4331, F4331PK> {

	@Query("select t from F4331 t where t.id.p1doco=?1 and t.id.p1an8=?2 and t.id.p1lnid=?3")
	List<F4331> findByIdp1docoAndIdp1an8AndIdp1lnid(Double num, Double an8,
			Double pdlnid);

}
