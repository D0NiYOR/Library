package com.example.library.repository;

import com.example.library.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    List<BookEntity> findByAuthorContainingIgnoreCase(String author);

    List<BookEntity> findByNameContainingIgnoreCase(String name);

    List<BookEntity> findByAuthorContainingIgnoreCaseAndNameContainingIgnoreCase(String author, String name);

}
