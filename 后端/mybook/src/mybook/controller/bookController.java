package mybook.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mybook.Service.BooklistService;
import net.sf.json.JSONArray;
import mybook.Entity.booklist;
@EnableAutoConfiguration
@RestController
public class bookController {

    @Autowired
    private BooklistService booklistService;

    @GetMapping(value = "/findEvent")
    public booklist findbook( Integer id) {
        return booklistService.findBooklistById(id);
    }
    @GetMapping(value = "/mybook/bookjson")
    public JSONArray sAll() {
		 return booklistService.SelectAll();
    }
    @PostMapping(path="/saveGoods") // Map ONLY GET Requests
    @ResponseBody
    public 
    String saveGoods (  @RequestParam MultipartFile cover, @RequestParam String bookname,
    		@RequestParam String author,@RequestParam String language
            ,@RequestParam int num,@RequestParam int date,@RequestParam int price,@RequestParam String detail) throws IOException {
    	byte[] buffer =cover.getBytes();
        booklist g1=new booklist(0,bookname,author,language,date,num,price,detail,buffer);
        booklistService.saveBooklist(g1);
        return buffer.toString();
    }
    @GetMapping(value = "/mybook/deletebook")
    public void deletebook(int id) {
    	 booklistService.deleteBooklistById(id);
    }
    @GetMapping(value = "/mybook/modibook")
    public void deletebook(int id,String bookname,String author,String language,int date,int num,int price) {
    	 booklist booklist=booklistService.findBooklistById(id);
    	 booklist.setBookname(bookname);
    	 booklist.setAuthor(author);
    	 booklist.setDate(date);
    	 booklist.setLanguage(language);
    	 booklist.setNum(num);
    	 booklist.setPrice(price);
    	 booklistService.saveBooklist(booklist);
    }
}