package mybook.Serviceimpl;

import mybook.dao.OrdersDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import mybook.Service.OrdersService;
import mybook.Entity.car;
import mybook.Entity.orderitem;
import mybook.Entity.orders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenhaopeng on 2019/5/2.
 */
@Service
public class OrdersServiceimpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public orders findOrdersById(Integer id){
        return ordersDao.findone(id);
    }
    @Override
    public void saveOrders(orders Orders) {
    	ordersDao.Save(Orders);
    }
    @Override
    public void deleteOrdersById(Integer id) {
    	ordersDao.Delete(id);
    }
    @Override
    public JSONObject addorders(String id,String address,int phone) {
    	JSONObject jsonobj = new JSONObject();
		orders Orders=new orders();
		Orders.setId(id);
		Orders.setAddress(address);
		Orders.setPhone(phone);;
		ordersDao.Save(Orders);
		int addsuccess = 1 ;
		jsonobj.put("addSuccess", addsuccess);
		return jsonobj;
    }
    @Override
    public JSONArray allorders() {
    	JSONArray jsonarray = new JSONArray(); 
		JSONObject jsonobj = new JSONObject();
		List<orders> allorders=new ArrayList<orders>();
		allorders=ordersDao.selectall();
		Iterator<orders> iter = allorders.iterator();
		 while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
			    orders rs = iter.next();
			    jsonobj.put("orderid" , rs.getOrder_id());
	            jsonobj.put("id" ,  rs.getId());
	            jsonobj.put("time" , rs.getCreateTime());
	            jsonobj.put("phone" , rs.getPhone());
	            jsonobj.put("address" , rs.getAddress());		   
	            jsonarray.add(jsonobj);
			}
		 return jsonarray;
    }
    @Override
    public JSONArray myorders(String id) {
    	JSONArray jsonarray = new JSONArray(); 
		JSONObject jsonobj = new JSONObject();
		List<orders> allorders=new ArrayList<orders>();
		allorders=ordersDao.findallorders(id);
		Iterator<orders> iter = allorders.iterator();
		 while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
			    orders rs = iter.next();
			    jsonobj.put("orderid" , rs.getOrder_id());
	            jsonobj.put("id" ,  rs.getId());
	            jsonobj.put("time" , rs.getCreateTime());
	            jsonobj.put("phone" , rs.getPhone());
	            jsonobj.put("address" , rs.getAddress());		   
	            jsonarray.add(jsonobj);
			}
		 return jsonarray;
    }
}

