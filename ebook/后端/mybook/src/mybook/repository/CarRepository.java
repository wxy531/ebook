package mybook.repository;


import mybook.Entity.car;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CarRepository extends JpaRepository<car, Integer>{
	@Query(value = "select * from car b where b.id=?1", nativeQuery = true)
	public List<car> findCar(String name);
	
	@Modifying
	@Transactional
	 @Query(value="Delete from car b where b.id=?1 ")
	 public void deleteCar(String id);
}
