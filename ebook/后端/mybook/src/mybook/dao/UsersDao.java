package mybook.dao;

import java.util.List;

import mybook.Entity.users;
import net.sf.json.JSONArray;

public interface UsersDao {
 
	boolean Exists(String id);
	void Save(users user);
	users findone(String id);
	void Delete(String id);
	void Update();
	List<users> showallusers();
	
}
