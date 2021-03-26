package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.library.Library;
import com.example.LibraryManagement.model.library.LibraryDao;
import com.example.LibraryManagement.model.library.LibraryRepository;
import com.example.LibraryManagement.model.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
@CrossOrigin("http://localhost:4200")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    LibraryDao libraryDao;

    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping()
    public ResponseEntity<List<Library>> getBooks(){
        return new ResponseEntity<>(libraryService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Library> getBooksById(@PathVariable("id") int id){
        return new ResponseEntity<>(libraryService.getBookById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBooksById(@PathVariable("id") int id){
        libraryDao.deleteBookById(id);
    }

    @PostMapping()
    public Library insertUser(@RequestBody Library library){
        return libraryDao.insertBook(library);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Library> updateBook(@PathVariable(value = "id") int id
            ,@Valid @RequestBody Library libraryDetails){
        Library library= libraryRepository.findById(id);
        library.setBookName(libraryDetails.getBookName());
        library.setCount(libraryDetails.getCount());
        library.setImageURL(libraryDetails.getImageURL());
        final Library updatedBooks= libraryRepository.save(library);
        return ResponseEntity.ok(updatedBooks);

    }
}
