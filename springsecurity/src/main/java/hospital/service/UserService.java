package hospital.service;

import hospital.entity.User;
import hospital.entity.enumer.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface UserService {

    void saveUser(User user) throws IOException;

    User findUserById(Long i);

    List<User> findAll();

    User findByLogin(String login);

    Page<User> findUsersByPage(Pageable pageable);

    Page<User> findByRole(UserRole role, Pageable pageable);

    void updateClient(String login, String password, int phoneNumber, LocalDate date, String address, Long id);

    void updateImage(byte[] image, Long id);
}
