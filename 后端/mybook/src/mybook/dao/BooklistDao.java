package mybook.dao;



import java.util.List;



import mybook.Entity.booklist;

public interface BooklistDao {
 
	boolean Exists(Integer id);
	void Save(booklist booklist);
	booklist findone(Integer id);
	void Delete(Integer id);
	void Update();
	public List<booklist> selectAll();
	void Bnum(int num,String bookname);
	
}