package com.example.LibraryManagement.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public User insertUser(User user) {
       return userDao.insertUser(user);
    }
}
