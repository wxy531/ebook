package mybook.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import mybook.Service.CarService;

import net.sf.json.JSONArray;



@EnableAutoConfiguration
@RestController
public class carController {
	private int addsuccess = 0;
    @Autowired
    private CarService carService;
    @GetMapping(value = "/mybook/carServlet")
    public JSONArray carcrud( String id, String bookname,
    		 Integer num, String method) {
    	
		return carService.carcrud(id, bookname, num, method);
    }

}