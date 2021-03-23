package com.example.LibraryManagement.model.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void deleteStudentById(int id){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        Map<String, Object> params= new HashMap<>();
        params.put("id", id);
        String deleteQuery= "delete from students where id = :id";
        namedParameterJdbcTemplate.update(deleteQuery,params);
    }


    public Student updateStudent(Student student) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        String query= "Update students set firstname= :firstname, lastname= :lastname," +
                " email= :email, phone= :phone, address= :address, classname= :classname where id= :id";

        Map<String, Object> params= new HashMap<>();
        params.put("firstname", student.getFirstname());
        params.put("lastname", student.getLastname());
        params.put("email", student.getEmail());
        params.put("phone", student.getPhone());
        params.put("address", student.getAddress());
        params.put("classname", student.getClassname());
        params.put("id",student.getId());
        namedParameterJdbcTemplate.update(query,params);
        return student;

    }

    public Student insertStudent(Student student) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        String query= "Insert into students (id, firstname, lastname, email, phone, address, classname) values " +
                "(:id,:firstname, :lastname, :email, :phone, :address, :classname)";
        Map<String, Object> params= new HashMap<>();
        params.put("firstname", student.getFirstname());
        params.put("lastname", student.getLastname());
        params.put("email", student.getEmail());
        params.put("phone", student.getPhone());
        params.put("address", student.getAddress());
        params.put("classname", student.getClassname());
        params.put("id",student.getId());
        namedParameterJdbcTemplate.update(query,params);
        return student;
    }
}
