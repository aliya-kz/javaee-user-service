package org.zhumagulova.userservice.service;

import jakarta.ejb.Stateless;
import org.zhumagulova.userservice.model.User;

import java.util.List;

@Stateless
public interface UserService {
    User findById(long id);
    void save (User user);
    List<User> getAll();
}
