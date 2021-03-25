package com.example.LibraryManagement.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAll();
    public User findById(int id);

    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);

}
