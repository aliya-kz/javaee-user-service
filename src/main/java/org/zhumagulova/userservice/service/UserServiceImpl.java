package org.zhumagulova.userservice.service;


import jakarta.inject.Inject;
import org.zhumagulova.userservice.dao.UserDao;
import org.zhumagulova.userservice.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Inject
    UserDao userDao;

    @Override
    public User findById(long id) {
        return userDao.findUser(id);
    }

    @Override
    public void save(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
