package mybook.repository;


import mybook.Entity.car;
import mybook.Entity.orders;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrdersRepository extends JpaRepository<orders, Integer>{
	@Modifying
	@Transactional
	 @Query(value=" INSERT INTO orders(id,address,phone) VALUES (?1,?2,?3) ",nativeQuery = true)
	 public void saveq(String id,String address,int phone);
	@Query(value = "select * from orders b where b.id=?1 ", nativeQuery = true)
	 public List<orders> findOrders(String name);

}
