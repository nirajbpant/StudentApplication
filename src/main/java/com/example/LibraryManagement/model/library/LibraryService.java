package com.example.LibraryManagement.model.library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    public List<Library> getAllBooks(){
        return libraryRepository.findAll();
    }

    public Library getBookById(int id){
        return libraryRepository.findById(id);
    }
}
