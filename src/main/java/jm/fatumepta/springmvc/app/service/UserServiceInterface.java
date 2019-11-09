package jm.fatumepta.springmvc.app.service;

import jm.fatumepta.springmvc.app.model.User;

import java.util.List;


public interface UserServiceInterface {
    void createUser(User user);

    User getUser(User user);

    List<User> getAllUsers();

    void editUser(User user);

    void deleteUser(User user);
}
