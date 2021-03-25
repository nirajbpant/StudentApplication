package com.example.LibraryManagement.model.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@Repository
public class LibraryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void deleteBookById(int id){
        String deleteQuery= "Delete from library where book_id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        Map<String, Object> params= new HashMap<>();
        params.put("id", id);

        namedParameterJdbcTemplate.update(deleteQuery,params);
    }

   /*public Library sortByName(String name){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        String filterQuery= "select * from library where name like '%:name'";
        Map<String, Object> params= new HashMap<>();
        params.put("name",name);
        return namedParameterJdbcTemplate.queryForList(filterQuery, params);
    }
    */

    public Library insertBook(Library library){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(jdbcTemplate);
        String query= "Insert into library (book_id, count, imageURL, name) values (:book_id, :count, :imageURL, :name)";
        Map<String, Object> params= new HashMap<>();
        params.put("book_id", library.getBookId());
        params.put("count", library.getCount());
        params.put("imageURL", library.getImageURL());
        params.put("name", library.getBookName());
        namedParameterJdbcTemplate.update(query, params);
        return library;
    }

    public Library updateBook(Library library) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String query = "update library set count= :count, imageURL= :imageURL, name= :name where book_id= :book_id";
        Map<String, Object> params = new HashMap<>();
        params.put("book_id", library.getBookId());
        params.put("count", library.getCount());
        params.put("imageURL", library.getImageURL());
        params.put("name", library.getBookName());
        namedParameterJdbcTemplate.update(query, params);
        return library;
    }

}
