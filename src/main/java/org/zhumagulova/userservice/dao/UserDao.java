package org.zhumagulova.userservice.dao;

import org.zhumagulova.userservice.model.User;

import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless
public class UserDao  {

    private EntityManager entityManager;

    public UserDao() {
        entityManager = Persistence.createEntityManagerFactory("UserDb").createEntityManager();
    }

    public User findUser(long id) {
        Query query = entityManager.createQuery( "Select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    public void saveUser (User user) {
        entityManager.persist(user);
    }
}
