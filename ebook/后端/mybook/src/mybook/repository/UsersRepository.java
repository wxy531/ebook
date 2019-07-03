package mybook.repository;

import mybook.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<users, String>{

}
