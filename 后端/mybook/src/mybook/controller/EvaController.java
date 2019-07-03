package mybook.controller;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybook.Entity.Eva;
import mybook.Entity.orderitem;
import mybook.repository.EvaRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@Controller
@EnableAutoConfiguration
public class EvaController {

	@Autowired
	EvaRepository evaRepository;

	@RequestMapping("/mongofind")
	@ResponseBody
	JSONArray home(String bookname) {
		JSONArray jsonarray = new JSONArray(); 
		JSONObject jsonobj = new JSONObject();
		List<Eva> list = evaRepository.findBybookname(bookname);
		Iterator<Eva> iter1 = list.iterator();
		Eva rs = new Eva();
		while(iter1.hasNext()) {
			rs = iter1.next();
			jsonobj.put("bookname" ,  rs.getbookname());
            jsonobj.put("username" ,  rs.getusername());
            jsonobj.put("eva" ,  rs.geteva());
            jsonarray.add(jsonobj);
		}
		return jsonarray;
	}
	@RequestMapping("/mongosave")
	@ResponseBody
	void save(String id, String bookname,String username,String eva) {
		Eva u1 = new Eva(id,bookname,username,eva);
		evaRepository.save(u1);
	}
}