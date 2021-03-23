package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.student.Student;
import com.example.LibraryManagement.model.student.StudentDao;
import com.example.LibraryManagement.model.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    StudentDao studentDao;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }


    @GetMapping(value = "/students/{id}")
    public ResponseEntity<List<Student>> getStudentById(@PathVariable("id") int id){

        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentDao.deleteStudentById(id);
    }
}
