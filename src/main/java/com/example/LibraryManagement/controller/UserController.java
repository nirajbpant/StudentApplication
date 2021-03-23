package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.user.User;
import com.example.LibraryManagement.model.user.UserDao;
import com.example.LibraryManagement.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userDao.deleteUserById(id);
    }

    @PutMapping(value = "/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping()
    public User postUser(@RequestBody User user){
        return userService.insertUser(user);
    }
}
