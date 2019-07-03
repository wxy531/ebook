package mybook.Serviceimpl;

import mybook.dao.BooklistDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import mybook.Service.BooklistService;
import mybook.Entity.booklist;
import mybook.Entity.car;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenhaopeng on 2019/5/2.
 */
@Service
public class BooklistServiceimpl implements BooklistService {

    @Autowired
    private BooklistDao booklistDao;

    @Override
    public booklist findBooklistById(Integer id){
        return booklistDao.findone(id);
    }
    @Override
    public void saveBooklist(booklist Booklist) {
    	booklistDao.Save(Booklist);
    }
    @Override
    public void deleteBooklistById(Integer id) {
    	booklistDao.Delete(id);
    }
    @Override
    public JSONArray SelectAll(){
    	 JSONArray jsonarray = new JSONArray();  
		 JSONObject jsonobj = new JSONObject();
		 List<booklist> book=new ArrayList<booklist>();
		 book = booklistDao.selectAll();
		 Iterator<booklist> iter = book.iterator();
		 while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
			    booklist rs = iter.next();
			    jsonobj.put("id" , rs.getId());
	            jsonobj.put("bookName" ,  rs.getBookname());
	            jsonobj.put("author" , rs.getAuthor());
	            jsonobj.put("language" , rs.getLanguage());
	            jsonobj.put("date" , rs.getDate());
	            jsonobj.put("num" , rs.getNum());
	            jsonobj.put("sales" , rs.getPrice());
	            jsonobj.put("detail" , rs.getDetail());
	            try {
					String temp=new String(Base64.encodeBase64(rs.getCover()), "UTF-8");
					jsonobj.put("cover" , "data:jpeg/png;base64,"+temp);
				} catch (UnsupportedEncodingException e) {
					
				}
	           
	            jsonarray.add(jsonobj);
			}
		 System.out.println(jsonarray);
		 return jsonarray;

    }

}

