package mybook.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import mybook.repository.CarRepository;
import mybook.Entity.car;
import mybook.Util.HibernateUtil;
import mybook.dao.CarDao;


 @Repository
public  class CarDaoimpl implements CarDao {
	 @Autowired
     private CarRepository carRepository;
	// ÃÌº””√ªß
	 @Override
     public car findone(Integer id) {
         return carRepository.getOne(id);
     }
	 @Override
	 public boolean Exists(Integer id) {
		 return carRepository.existsById(id);
	 }
	 @Override
	 public void Save(car car) {
		 carRepository.save(car);
	 }
	 @Override
	 public void Delete(String id) {
		 carRepository.deleteCar(id);
	 }
	 @Override
	 public void Update() {
		 carRepository.flush();
	 }
	 @Override
	 public List<car> findallcar(String id){
		 return carRepository.findCar(id);
	 }

}

