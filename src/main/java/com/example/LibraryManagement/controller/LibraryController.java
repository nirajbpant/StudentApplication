package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.library.Library;
import com.example.LibraryManagement.model.library.LibraryDao;
import com.example.LibraryManagement.model.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    LibraryDao libraryDao;

    @GetMapping(value = "/books")
    public ResponseEntity<List<Library>> getBooks(){
        return new ResponseEntity<>(libraryService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Library> getBooksById(@PathVariable("id") int id){
        return new ResponseEntity<>(libraryService.getBookById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}")
    public void deleteBooksById(@PathVariable("id") int id){
        libraryDao.deleteBookById(id);
    }
}
