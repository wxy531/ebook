package mybook.Service;

import java.util.List;

import mybook.Entity.car;
import mybook.Entity.orderitem;
import mybook.Entity.orders;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * Created by chenhaopeng on 2019/5/2.
 */
public interface OrdersService {
    orders findOrdersById(Integer id);
    void saveOrders(orders Orders);
    void deleteOrdersById(Integer id) ;
    JSONObject addorders(String id,String address,int phone);
    JSONArray allorders();
    JSONArray myorders(String id);
}