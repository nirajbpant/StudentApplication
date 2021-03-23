package com.example.LibraryManagement.model.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LibraryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void deleteBookById(int id){
        String deleteQuery= "Delete from library where id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        Map<String, Object> params= new HashMap<>();
        params.put("id", id);

        namedParameterJdbcTemplate.update(deleteQuery,params);
    }
}
