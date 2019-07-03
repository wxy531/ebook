package mybook.dao;

import java.util.List;

import mybook.Entity.car;
import mybook.Entity.orders;

public interface OrdersDao {
 
	boolean Exists(Integer id);
	void Save(orders orders);
	orders findone(Integer id);
	void Delete(Integer id);
	void Update();
	List<orders> findallorders(String id);
	List<orders> selectall();
	
}
