package mybook.repository;

import mybook.Entity.car;
import mybook.Entity.orderitem;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderitemRepository extends JpaRepository<orderitem, Integer>{
	@Modifying
	@Transactional
	 @Query(value=" INSERT INTO orderitem(orderid,bookname,num) VALUES (?1,?2,?3) ",nativeQuery = true)
	 public void Qaddorderitem(int orderid,String bookname,int num);
	@Query(value = "select * from orderitem b where b.orderid=?1", nativeQuery = true)
	public List<orderitem> finditem(int name);
}
