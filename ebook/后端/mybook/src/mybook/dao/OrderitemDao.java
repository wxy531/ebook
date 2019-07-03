package mybook.dao;

import java.util.List;

import mybook.Entity.orderitem;

public interface OrderitemDao {
 
	boolean Exists(Integer id);
	void Save(orderitem orderitem);
	orderitem findone(Integer id);
	void Delete(Integer id);
	void Update(List<orderitem> orderitem);
	void flush(orderitem orderitem);
	void Qaddorderitem(int orderid,String bookname,int num);
	List<orderitem> showmy(int order_id);
	
}
