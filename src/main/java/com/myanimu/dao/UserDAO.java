package com.myanimu.dao;

import com.myanimu.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void removeUser(String username);
    void addUser(User user);
    User getUser(String username);
}
