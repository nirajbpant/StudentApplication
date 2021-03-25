package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.user.User;
import com.example.LibraryManagement.model.user.UserDao;
import com.example.LibraryManagement.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin("http://localhost:4200")
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
    @CrossOrigin("http://localhost:4200")
    public User postUser(@RequestBody User user) throws Exception{
        String tempUsername= user.getUsername();
        if(tempUsername != null && !"".equals(tempUsername)){
           User userObj= userService.fetchUserByUsername(tempUsername);
           if(userObj!=null){
               throw new Exception("User already Exists");
           }
        }
        User userObj= null;
        userObj= userService.insertUser(user);
        return userObj;
    }
    @PostMapping("/login")
    @CrossOrigin("http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempUsername =user.getUsername();
        String tempPassword = user.getPassword();
        User userObj = null;
        if(tempUsername != null && tempPassword != null){
          userObj= userService.fetchUserByUsernameAndPassword(tempUsername, tempPassword);
        }
        if(userObj == null){
            throw new Exception("Bad Credentials");
        }
        return userObj;
    }
}
