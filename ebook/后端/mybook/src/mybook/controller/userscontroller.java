package mybook.controller;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;





import mybook.Service.UsersService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import mybook.Entity.users;


@EnableAutoConfiguration
@RestController
public class userscontroller {
    @Autowired
    private UsersService usersService;
    @GetMapping(value = "/mybook/login")
    public JSONObject login(String id,String password) {
    	return usersService.login(id, password);
    }
    @GetMapping(value = "/mybook/register")
    public JSONObject register( String id, String password,
    		 String name , String address,long phone,String method,String email) {
    	
		return usersService.Register(id, password, name, address, phone, email);
    }
    @GetMapping(value = "/mybook/manager")
    public JSONArray allusers() {
    	
		return usersService.showallusers();
    }
    @GetMapping(value = "/mybook/setmanager")
    public void setmanager(String id,int manager) {
    	
		 usersService.setmanager(id,manager);
    }

}