package mybook.Service;

import java.util.List;

import mybook.Entity.booklist;
import net.sf.json.JSONArray;
/**
 * Created by chenhaopeng on 2019/5/2.
 */
public interface BooklistService {
    booklist findBooklistById(Integer id);
    void saveBooklist(booklist Booklist);
    void deleteBooklistById(Integer id) ;
    JSONArray SelectAll();
}