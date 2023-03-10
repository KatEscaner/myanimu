package com.myanimu.controllers;

import com.myanimu.dao.UserDAO;
import com.myanimu.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "user/user/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username){
        return userDao.getUser(username);
    }

    @RequestMapping(value = "user/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "admin/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userDao.addUser(user);
    }

    @RequestMapping(value = "admin/user/{username}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable String username){
        userDao.removeUser(username);
    }
}
