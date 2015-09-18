package interfacedao;

import java.util.List;

import modelo.F0101;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IF0101DAO extends JpaRepository<F0101, Double> {

	@Query("select f from F0101 f order by f.aban8 asc")
	List<F0101> findAllOrderByAban8dAsc();

	List<F0101> findByAban81OrAban82OrAban83OrAban84OrAban85OrAban86(
			double aban8, double aban82, double aban83, double aban84,
			double aban85, double aban86);

	List<F0101> findByAbmcu(String abmcu);

	List<F0101> findByAbalph(String nombre);

	List<F0101> findByAbat1AllIgnoreCase(String string);

	@Query("SELECT y  FROM  F4311 f,F0101 y WHERE f.pdanby=y.aban8 AND  f.id.pddoco=?1")
	List<F0101> findInSeller(Double d);

}
