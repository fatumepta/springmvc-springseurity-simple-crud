package jm.fatumepta.springmvc.app.service;

import jm.fatumepta.springmvc.app.dao.UserDAO;
import jm.fatumepta.springmvc.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserServiceInterface {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public User getUser(User user) {
        return userDAO.getUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }
}
