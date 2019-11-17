package jm.fatumepta.springmvc.app.dao;

import jm.fatumepta.springmvc.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserById(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void editUser(User user) {
        saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUserByLogin(String login) throws IndexOutOfBoundsException {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE login=:login")
                .setParameter("login", login)
                .getResultList()
                .get(0);
    }

}
