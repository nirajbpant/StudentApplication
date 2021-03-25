package com.example.LibraryManagement.model.library;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    public List<Library> findAll();
    public Library findById(int id);

    Page<Library> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
