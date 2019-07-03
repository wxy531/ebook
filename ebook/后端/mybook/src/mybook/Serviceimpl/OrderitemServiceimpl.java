package mybook.Serviceimpl;

import mybook.dao.OrderitemDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import mybook.Service.OrderitemService;
import mybook.Entity.booklist;
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
public class OrderitemServiceimpl implements OrderitemService {

    @Autowired
    private OrderitemDao orderitemDao;

    @Override
    public orderitem findOrderitemById(Integer id){
        return orderitemDao.findone(id);
    }
    @Override
    public void saveOrderitem(orderitem Orderitem) {
    	orderitemDao.Save(Orderitem);
    	
    }
    @Override
    public void deleteOrderitemById(Integer id) {
    	orderitemDao.Delete(id);
    }
    @Override
    public void update(List<orderitem> orderitem) {
    	orderitemDao.Update(orderitem);
    }
    @Override
    public JSONObject addorderitem(int order_id,String bookname,int num) {
    	JSONObject jsonobj = new JSONObject();
		orderitem orderitem=new orderitem();
		orderitem.setOrder_id(order_id);
		orderitem.setBookname(bookname);
		orderitem.setNum(num);;
		orderitemDao.Save(orderitem);
		int addsuccess = 1 ;
		jsonobj.put("addSuccess", addsuccess);
		return jsonobj;
    }
    @Override public JSONArray showmy(int order_id) {
    	JSONArray jsonarray = new JSONArray(); 
		JSONObject jsonobj = new JSONObject();
		orderitem Caritem=new orderitem();
    	List<orderitem> list=new ArrayList<orderitem>();
    	list = orderitemDao.showmy(order_id);
    	Iterator<orderitem> iter1 = list.iterator();
		while(iter1.hasNext()) {
			Caritem = iter1.next();
        	jsonobj.put("bookname" ,  Caritem.getBookname());
            jsonobj.put("num" ,  Caritem.getNum());
            jsonarray.add(jsonobj);
		}
		return jsonarray;
    }
}


