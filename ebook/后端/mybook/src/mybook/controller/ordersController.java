package mybook.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import mybook.Service.OrdersService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@EnableAutoConfiguration
@RestController
public class ordersController {
	private int addsuccess = 0;
    @Autowired
    private OrdersService ordersService;
    @GetMapping(value = "/mybook/addorder")
    public JSONObject addorders( String id, String address,int phone) {
    	return ordersService.addorders(id, address,phone);
		
    }
    @GetMapping(value = "/mybook/allorders")
    public JSONArray allorders() {
    	return ordersService.allorders();
		
    }
    @GetMapping(value = "/mybook/myorders")
    public JSONArray myorders(String id) {
    	return ordersService.myorders(id);
		
    }

}