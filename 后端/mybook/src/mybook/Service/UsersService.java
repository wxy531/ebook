package mybook.Service;

import mybook.Entity.orders;
import mybook.Entity.users;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * Created by chenhaopeng on 2019/5/2.
 */
public interface UsersService {
    users findUsersById(String id);
    void saveUsers(users Users);
    void deleteUsersById(String id) ;
    JSONObject login(String id,String password);
    JSONObject Register(String id, String password,
   		 String name , String address,long phone,String email);
    JSONArray showallusers();
    void setmanager(String id,int manager);
}