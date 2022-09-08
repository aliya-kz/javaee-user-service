package org.zhumagulova.userservice.dao;

import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.findUser(1).getEmail());
    }
}