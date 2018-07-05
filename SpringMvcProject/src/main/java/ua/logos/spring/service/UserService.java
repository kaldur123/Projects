package ua.logos.spring.service;

import ua.logos.spring.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User showUserById(int id);

    List<User> showAllUsers();
}
