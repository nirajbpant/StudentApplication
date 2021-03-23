package com.example.LibraryManagement.model.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }

    public List<Student> getStudentById(int id){
        return studentRepository.findStudentById(id);
    }
}
