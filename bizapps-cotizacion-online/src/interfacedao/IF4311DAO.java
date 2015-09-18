package interfacedao;

import java.util.List;

import modelo.F4311;
import modelo.pk.F4311PK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF4311DAO extends JpaRepository<F4311, F4311PK> {

	@Query(value = " select * from F4311 where "
			+ "PDDOCO=?2 AND pdlnid not in (select p1lnid from F4331 where P1AN8=?1 AND P1DOCO=?2)"
			+ "order by 2", nativeQuery = true)
	List<F4311> findByAn8AndDocoPendiente(String an8, String num);

	@Query(value = " select * from F4311 where "
			+ "PDDOCO=?2 AND pdlnid  in (select p1lnid from F4331 where P1AN8=?1 AND P1DOCO=?2)"
			+ "order by 2", nativeQuery = true)
	List<F4311> findByAn8AndDocoCargada(String an8, String num);

	@Query(value = " select * from F4311 where "
			+ "PDDOCO=?2 AND pdlnid  in (select p1lnid from F4331 where P1AN8=?1 AND P1DOCO=?2 )"
			+ " UNION SELECT * FROM F4311 WHERE PDDOCO=?2 AND pdlnid not in (select p1lnid from F4331"
			+ " where P1AN8=?1 AND P1DOCO=?2)" + "order by 2", nativeQuery = true)
	List<F4311> findByAn8AndDocoTodas(String an8, String num);

}
