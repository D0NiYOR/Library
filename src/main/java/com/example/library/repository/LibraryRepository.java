package com.example.library.repository;

import com.example.library.model.BookEntity;
import com.example.library.model.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, UUID> {

//    List<BookEntity> findByNameContainingIgnoreCase(String name);
}
