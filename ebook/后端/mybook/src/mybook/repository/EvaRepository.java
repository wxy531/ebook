package mybook.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import mybook.Entity.Eva;


@Service
public interface EvaRepository extends MongoRepository<Eva, String> {  
    
   public List<Eva> findBybookname(String bookname); 

}
