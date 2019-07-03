package mybook.Service;

import java.util.List;

import mybook.Entity.booklist;
import mybook.Entity.orderitem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * Created by chenhaopeng on 2019/5/2.
 */
public interface OrderitemService {
    orderitem findOrderitemById(Integer id);
    void saveOrderitem(orderitem Orderitem);
    void deleteOrderitemById(Integer id) ;
    void update(List<orderitem> orderitem);
    JSONObject addorderitem(int order_id,String bookname,int num);
    JSONArray showmy(int order_id);
}