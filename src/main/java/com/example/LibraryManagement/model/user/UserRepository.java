package com.example.LibraryManagement.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAll();
    public List<User> findById(int id);
}