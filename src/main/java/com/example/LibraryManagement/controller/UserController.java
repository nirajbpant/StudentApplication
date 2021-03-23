package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.user.User;
import com.example.LibraryManagement.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public List<User> getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }
}
