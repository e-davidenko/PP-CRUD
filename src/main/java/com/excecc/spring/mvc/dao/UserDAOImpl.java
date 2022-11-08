package com.excecc.spring.mvc.dao;

import com.excecc.spring.mvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created in Intellij
 * User: Davidenko
 * Date: 05.11.2022
 * Time: 20:23
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> list = entityManager.createQuery("FROM User", User.class).getResultList();
        System.out.println(list.size());
        return list;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.getReference(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }
}
