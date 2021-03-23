package com.example.LibraryManagement.model.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void deleteUserById(int id){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        Map<String, Object> params= new HashMap<>();
        params.put("id",id);
        String deleteSql= "delete from users where id= :id";
        namedParameterJdbcTemplate.update(deleteSql,params);
    }

    public User updateUser(User user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        String updateQuery= "update users set username= :username, password= :password, role= :role where id=:id";
        Map<String, Object> params= new HashMap<>();
        params.put("username",user.getUsername());
        params.put("password", user.getPassword());
        params.put("role", user.getRole());
        params.put("id",user.getId());
        namedParameterJdbcTemplate.update(updateQuery,params);
        return user;
    }

    public User insertUser(User user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        String insertQuery= "Insert into users (id, username, password, role) values (:id, :username, :password, :role)";
        Map<String, Object> params= new HashMap<>();
        params.put("id", user.getId());
        params.put("username", user.getUsername());
        params.put("password", user.getPassword());
        params.put("role", user.getRole());
        namedParameterJdbcTemplate.update(insertQuery,params);
        return user;
    }
}
