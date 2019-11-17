package jm.fatumepta.springmvc.app.service;

import jm.fatumepta.springmvc.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    void saveUser(User user);

    User getUserById(long id);

    List<User> getAllUsers();

    void editUser(User user);

    void deleteUser(User user);
}
