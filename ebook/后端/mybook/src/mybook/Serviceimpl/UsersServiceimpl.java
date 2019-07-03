package mybook.Serviceimpl;

import mybook.dao.UsersDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import mybook.Service.UsersService;
import mybook.Entity.orders;
import mybook.Entity.users;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by chenhaopeng on 2019/5/2.
 */
@Service
public class UsersServiceimpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public users findUsersById(String id){
        return usersDao.findone(id);
    }
    public void saveUsers(users Users) {
    	usersDao.Save(Users);
    }
    @Override
    public void deleteUsersById(String id) {
    	usersDao.Delete(id);
    }
    @Override
    public JSONObject login(String id,String password) {
		JSONObject jsonobj = new JSONObject();
		users useritem=new users();
		int loginsuccess=0;
			useritem=usersDao.findone(id);
			if(useritem.getPassword().equals(password)) {
				if(useritem.getManager()<2) {
				 jsonobj.put("name" , useritem.getName());
				 jsonobj.put("id" , useritem.getId());
				 jsonobj.put("address" , useritem.getAddress());
				 jsonobj.put("manager",useritem.getManager());
				}
				else {
					jsonobj.put("manager",2);
				}
				loginsuccess = 1 ;
			}
			else {
			}
			jsonobj.put("loginsuccess",loginsuccess);
			return jsonobj;
    };
    @Override
	public JSONObject Register(String id, String password,
   		 String name , String address,long phone,String email) {
    	int regsuccess=0;
    	int role=0;
		JSONObject jsonobj = new JSONObject();
		users useritem=new users();
	
		if(usersDao.Exists(id)) {
			regsuccess=0;
		}
			
			 else{
				 regsuccess=1;
				 useritem.setId(id);
				 useritem.setPassword(password);
				 useritem.setEmail(email);
				 useritem.setPhone(phone);
				 useritem.setName(name);
				 useritem.setAddress(address);
				 useritem.setManager(role);
				 usersDao.Save(useritem);
				 };
				 				 
		 jsonobj.put("regsuccess" ,regsuccess);
		return jsonobj;
    };
    public JSONArray showallusers() {
    	JSONArray jsonarray = new JSONArray(); 
    	JSONObject jsonobj = new JSONObject();
		users useritem=new users();
		List<users>allusers=new ArrayList<users>();
		allusers=usersDao.showallusers();
		Iterator<users> iter = allusers.iterator();
		 while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
			    useritem = iter.next();
			    jsonobj.put("name" , useritem.getName());
				 jsonobj.put("id" , useritem.getId());
				 jsonobj.put("address" , useritem.getAddress());
				 jsonobj.put("manager",useritem.getManager());
				 jsonobj.put("password",useritem.getPassword());
				 jsonobj.put("phone",useritem.getPhone());
				 jsonobj.put("email",useritem.getEmail());
	            jsonarray.add(jsonobj);
			}
		 return jsonarray;	
}
    @Override
    public void setmanager(String id,int manager) {
    	users useritem=usersDao.findone(id);
    	useritem.setManager(manager);
    	usersDao.Save(useritem);
    }
    
}
