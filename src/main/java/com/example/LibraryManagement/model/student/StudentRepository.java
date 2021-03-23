package com.example.LibraryManagement.model.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Integer> {

    public List<Student> findAll();
    public List<Student> findStudentById(int id);



}
