package mybook.dao;

import java.util.List;

import mybook.Entity.car;

public interface CarDao {
 
	boolean Exists(Integer id);
	void Save(car car);
	car findone(Integer id);
	void Delete(String id);
	void Update();
	List<car> findallcar(String id);
	
}
