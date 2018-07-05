package ua.logos.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.spring.entity.User;
import ua.logos.spring.repository.UserRepository;
import ua.logos.spring.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User showUserById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }
}
