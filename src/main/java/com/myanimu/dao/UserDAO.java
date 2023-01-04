package com.myanimu.dao;

import com.myanimu.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void removeUser(String username);
    void addUser(User user);
    void addAdmin(User user);
    User getUser(String username);
    User getUserByEmail(String email);
}
