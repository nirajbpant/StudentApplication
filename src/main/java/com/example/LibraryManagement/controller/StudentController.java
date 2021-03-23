package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.student.Student;
import com.example.LibraryManagement.model.student.StudentDao;
import com.example.LibraryManagement.model.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    StudentDao studentDao;



    @GetMapping()
    public ResponseEntity<List<Student>> getStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){

        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentDao.deleteStudentById(id);
    }

    @PutMapping(value = "/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @PostMapping()
    public Student insertStudent(@RequestBody Student student){

        return studentService.insertStudent(student);
    }
}
