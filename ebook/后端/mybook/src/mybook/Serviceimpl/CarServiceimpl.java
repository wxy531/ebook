package mybook.Serviceimpl;

import mybook.dao.BooklistDao;
import mybook.dao.CarDao;
import mybook.dao.OrderitemDao;
import mybook.dao.OrdersDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import mybook.Service.CarService;
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
public class CarServiceimpl implements CarService {

    @Autowired
    private CarDao carDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderitemDao orderitemDao;
    @Autowired
    private BooklistDao booklistDao;

    @Override
    public car findCarById(Integer id){
        return carDao.findone(id);
    }
    @Override
    public void saveCar(car Car) {
    	carDao.Save(Car);
    }
    @Override
    public void deleteCarById(String id) {
    	carDao.Delete(id);
    }
    @Override
    public JSONArray carcrud(String id, String bookname,
   		 Integer num, String method){
    	int addsuccess = 1;
    	JSONArray jsonarray = new JSONArray(); 
		JSONObject jsonobj = new JSONObject();
		car Caritem=new car();
		orders Orders=new orders();
		List<car> list = new ArrayList<car>();
		List<orders> olist = new ArrayList<orders>();
		if(method.toString().equals("add")) {
			Caritem.setId(id);
			Caritem.setBookname(bookname);
			Caritem.setNum(num);
			carDao.Save(Caritem);
			jsonobj.put("addSuccess", addsuccess);
			jsonarray.add(jsonobj);
		}
		else if(method.toString().equals("all")){
			list =carDao.findallcar(id);
			Iterator<car> iter = list.iterator();
            while (iter.hasNext()) {
            	Caritem = iter.next();
            	jsonobj.put("carid" ,  Caritem.getCar_id());
	            jsonobj.put("id" ,  Caritem.getId());
	            jsonobj.put("bookname" , Caritem.getBookname());
	            jsonobj.put("num" , Caritem.getNum());
	            jsonarray.add(jsonobj);
	            }
		}
		else if(method.toString().equals("submit")){
			Orders.setId(id);
			Orders.setAddress(bookname);
			ordersDao.Save(Orders);
			olist =ordersDao.findallorders(id);
			Iterator<orders> iter2 = olist.iterator();
			int orderid =0;
			while(iter2.hasNext()) {
				Orders=iter2.next();
			};
			orderid=Orders.getOrder_id();
			list=carDao.findallcar(id);
			System.out.println(list);
			Iterator<car> iter1 = list.iterator();
			while(iter1.hasNext()) {
				Caritem=iter1.next();
				bookname=Caritem.getBookname();
				num=Caritem.getNum();
				orderitemDao.Qaddorderitem(orderid,bookname,num);
				booklistDao.Bnum(num, bookname);
			}
			System.out.println(7);
			carDao.Delete(id);
            addsuccess = 1 ;
            jsonobj.put("addSuccess", addsuccess);
    		jsonarray.add(jsonobj);
			
		}
		else if(method.toString().equals("delete")) {
			carDao.Delete(bookname);
		}
		
		return jsonarray;

    }
}

