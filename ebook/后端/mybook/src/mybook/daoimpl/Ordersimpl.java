package mybook.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import mybook.repository.OrdersRepository;
import mybook.Entity.car;
import mybook.Entity.orders;
import mybook.Util.HibernateUtil;
import mybook.dao.OrdersDao;

 @Repository
public  class Ordersimpl implements OrdersDao {
	 @Autowired
     private OrdersRepository ordersRepository;
	// ÃÌº””√ªß
	 @Override
     public orders findone(Integer id) {
         return ordersRepository.getOne(id);
     }
	 @Override
	 public boolean Exists(Integer id) {
		 return ordersRepository.existsById(id);
	 }
	 @Override
	 public void Save(orders orderitem) {
		 ordersRepository.saveq(orderitem.getId(),orderitem.getAddress(),orderitem.getPhone());
	 }
	 @Override
	 public void Delete(Integer id) {
		 ordersRepository.deleteById(id);
	 }
	 @Override
	 public void Update() {
		 ordersRepository.flush();
	 }
	 @Override
	 public List<orders> findallorders(String id){
		 return ordersRepository.findOrders(id);
	 }
	 @Override
	 public List<orders> selectall() {
		 return ordersRepository.findAll();
	 };

}

