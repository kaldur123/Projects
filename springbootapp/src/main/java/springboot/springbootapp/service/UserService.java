package springboot.springbootapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springboot.springbootapp.dto.filter.MyFilter;
import springboot.springbootapp.entity.User;

import java.util.List;


public interface UserService {

    void saveUser(User user);

    User findUserById(int i);

    List<User> findAllUsers();

    boolean isPresent(String email, String login);

    User findUserByEmailAndLogin(String email, String login);

    List<User> findUsersByFilter(MyFilter filter);

    Page<User> findUsersByPage(MyFilter filter, Pageable pageable);

    Page<User> findUsersByPage(Pageable pageable);
}
