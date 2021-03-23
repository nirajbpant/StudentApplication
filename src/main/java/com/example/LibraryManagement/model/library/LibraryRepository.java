package com.example.LibraryManagement.model.library;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    public List<Library> findAll();
    public Library findById(int id);
}
