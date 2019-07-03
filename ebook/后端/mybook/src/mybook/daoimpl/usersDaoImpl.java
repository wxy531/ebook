package mybook.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import mybook.repository.UsersRepository;
import net.sf.json.JSONArray;
import mybook.Entity.users;
import mybook.Util.HibernateUtil;
import mybook.dao.UsersDao;

 @Repository
public  class usersDaoImpl implements UsersDao {
	 @Autowired
     private UsersRepository usersRepository;
	// ÃÌº””√ªß
	 @Override
     public users findone(String id) {
         return usersRepository.getOne(id);
     }
	 @Override
	 public boolean Exists(String id) {
		 return usersRepository.existsById(id);
	 }
	 @Override
	 public void Save(users user) {
		 usersRepository.save(user);
	 }
	 @Override
	 public void Delete(String id) {
		 usersRepository.deleteById(id);
	 }
	 @Override
	 public void Update() {
		 usersRepository.flush();
	 }
	 @Override
	 public List<users> showallusers() {
		 return usersRepository.findAll();
	 }
	 
}

