package hospital.service.impl;

import hospital.entity.User;
import hospital.entity.enumer.UserRole;
import hospital.repository.UserRepository;
import hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;
    @Override
    public void saveUser(User user) throws IOException {
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        byte[] arr = new byte[(int) new File("D:\\default.png").length()];
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\default.png"));
        fileInputStream.read(arr);
        user.setImage(arr);
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long i) {
        return userRepository.getOne(i);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findByRole(UserRole role, Pageable pageable) {
        return userRepository.findAll(getSpecification(role), PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }

    public Specification<User> getSpecification(UserRole role) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("role"), role);
            }
        };
    }

    @Override
    public Page<User> findUsersByPage(Pageable pageable) {
        return userRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public void updateClient(String login, String password, int phoneNumber, LocalDate date, String address, Long id) {
        userRepository.updateClient(login, password, phoneNumber, date, address, id);
    }

    @Override
    public void updateImage(byte[] image, Long id) {
        userRepository.updateImage(image, id);
    }
}
