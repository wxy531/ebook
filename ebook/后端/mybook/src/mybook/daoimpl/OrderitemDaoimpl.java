package mybook.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import mybook.repository.OrderitemRepository;
import mybook.Entity.orderitem;
import mybook.Util.HibernateUtil;
import mybook.dao.OrderitemDao;

 @Repository
public  class OrderitemDaoimpl implements OrderitemDao {
	 @Autowired
     private OrderitemRepository orderitemRepository;
	// ÃÌº””√ªß
	 @Override
     public orderitem findone(Integer id) {
         return orderitemRepository.getOne(id);
     }
	 @Override
	 public boolean Exists(Integer id) {
		 return orderitemRepository.existsById(id);
	 }
	 @Override
	 public void Save(orderitem orderitem) {
		 orderitemRepository.save(orderitem);
	 }
	 @Override
	 public void Delete(Integer id) {
		 orderitemRepository.deleteById(id);
	 }
	 @Override
	 public void Update(List<orderitem> orderitem) {
		 orderitemRepository.saveAll(orderitem);
	 }
	 @Override
	 public void flush(orderitem orderitem) {
		 orderitemRepository.saveAndFlush(orderitem);
	 }
	 @Override
	 public void Qaddorderitem(int orderid,String bookname,int num) {
		 orderitemRepository.Qaddorderitem(orderid, bookname, num);
	 }
	 @Override
	 public List<orderitem> showmy(int order_id){
		 return orderitemRepository.finditem(order_id);
	 }
}

