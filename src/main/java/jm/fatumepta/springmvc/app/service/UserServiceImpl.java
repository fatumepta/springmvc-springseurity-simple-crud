package jm.fatumepta.springmvc.app.service;

import jm.fatumepta.springmvc.app.dao.UserDAO;
import jm.fatumepta.springmvc.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void editUser(User user) {
        dao.editUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            User user = dao.getUserByLogin(login);
            return toUserDetails(user);
        } catch (IndexOutOfBoundsException exc) {
            throw new UsernameNotFoundException("No such user in database!");
        }
    }

    // Using Spring std User class
    private UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.withUsername(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole()).build();
    }

}
