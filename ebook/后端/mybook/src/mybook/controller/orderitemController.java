package mybook.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;




import mybook.Service.OrderitemService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@EnableAutoConfiguration
@RestController
public class orderitemController {
    @Autowired
    private OrderitemService orderitemService;
    @GetMapping(value = "/mybook/addorderitem")
    public JSONObject addorders( int order_id, String bookname,int num) {
    	return orderitemService.addorderitem(order_id, bookname,num);
		
    }
    @GetMapping(value = "/mybook/showmyorderitem")
    public JSONArray myorders( int id) {
    	return orderitemService.showmy(id);
		
    }

}