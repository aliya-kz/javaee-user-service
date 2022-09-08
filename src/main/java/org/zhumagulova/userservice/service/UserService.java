package org.zhumagulova.userservice.service;

import org.zhumagulova.userservice.model.User;

import javax.ejb.Stateless;

@Stateless
public interface UserService {
    User findById(long id);
    void save (User user);
}
