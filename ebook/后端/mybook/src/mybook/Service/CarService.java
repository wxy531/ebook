package mybook.Service;

import java.util.List;

import mybook.Entity.car;
import net.sf.json.JSONArray;
/**
 * Created by chenhaopeng on 2019/5/2.
 */
public interface CarService {
    car findCarById(Integer id);
    void saveCar(car Car);
    void deleteCarById(String id) ;
    JSONArray carcrud(String id, String bookname,
   		 Integer num, String method);
    
}