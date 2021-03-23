package com.example.LibraryManagement.model.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDao studentDao;


    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
        return studentRepository.findStudentById(id);
    }


    public Student updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    public Student insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }
}
