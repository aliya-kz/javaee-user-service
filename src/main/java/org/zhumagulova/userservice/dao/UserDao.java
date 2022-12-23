package org.zhumagulova.userservice.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.zhumagulova.userservice.model.User;


import java.util.List;


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

    public List<User> getAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        return this.entityManager.createQuery(cq).getResultList();
    }
}
