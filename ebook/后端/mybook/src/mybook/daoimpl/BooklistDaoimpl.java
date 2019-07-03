package mybook.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import mybook.repository.BooklistRepository;
import mybook.Entity.booklist;
import mybook.Util.HibernateUtil;
import mybook.dao.BooklistDao;


 @Repository
public  class BooklistDaoimpl implements BooklistDao {
	 @Autowired
     private BooklistRepository booklistRepository;
	// ÃÌº””√ªß
	 @Override
     public booklist findone(Integer id) {
         return booklistRepository.getOne(id);
     }
	 @Override
	 public boolean Exists(Integer id) {
		 return booklistRepository.existsById(id);
	 }
	 @Override
	 public void Save(booklist orderitem) {
		 booklistRepository.save(orderitem);
	 }
	 @Override
	 public void Delete(Integer id) {
		 booklistRepository.deleteById(id);
	 }
	 @Override
	 public void Update() {
		 booklistRepository.flush();
	 }
	 public List<booklist> selectAll(){
		 return booklistRepository.findAll();
	 }
	 @Override
	 public void Bnum(int num,String bookname) {
	    	int oldnum=booklistRepository.Bgetnum(bookname);
	    	oldnum=oldnum-num;
		 booklistRepository.Bnum(oldnum, bookname);
	 }
	 

}

