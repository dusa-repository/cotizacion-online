package interfacedao;

import java.math.BigDecimal;
import java.util.List;

import modelo.F554330;
import modelo.pk.F5544330PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF554330DAO extends JpaRepository<F554330, F5544330PK> {

	@Query(value = "SELECT cast(P0DOCO as varchar) as a, cast(P0TRDJ as varchar) as b, cast(P0RQQJ as varchar) as c, cast(EXSTDS as varchar) as d, cast(EXURCD as varchar) as e"
			+ " FROM F4330,F554330 WHERE EXDOCO=P0DOCO AND P0AN8=?1 AND EXAN8=?1"
			+ " and EXSTDS LIKE ?2 group by P0DOCO,P0TRDJ,P0RQQJ,EXSTDS,EXURCD order by 1", nativeQuery = true)
	public List<Object[]> buscar(String an8, String estado);

	@Query("select f from F554330 f where f.id.exdoco=?1 and f.id.exdcto=?2 and f.id.exkcoo=?3 and f.id.exan8=?4")
	public List<F554330> findByIdExdocoAndIdExdctoAndIdExkcooAndIdexan8(
			BigDecimal bigDecimal, String string, String string2,
			BigDecimal bigDecimal2);
}
