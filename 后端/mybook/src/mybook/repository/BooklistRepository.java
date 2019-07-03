package mybook.repository;

import mybook.Entity.booklist;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface BooklistRepository extends JpaRepository<booklist, Integer>{
	@Modifying
	@Transactional
	 @Query(value=" UPDATE booklist set 库存=?1 where 书名=?2 ",nativeQuery = true)
	 public void Bnum(int num,String bookname);
	 @Query(value="select 库存 from booklist where 书名=?1 ",nativeQuery = true)
	 public int Bgetnum(String bookname);
}
