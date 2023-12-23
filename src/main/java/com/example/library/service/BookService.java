package com.example.library.service;

import com.example.library.model.BookEntity;
import com.example.library.model.request.BookDto;
import com.example.library.model.response.BookResponseDto;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    public BookResponseDto createBook(BookDto bookDto){
        return modelMapper.map(bookRepository.save(modelMapper.map(bookDto, BookEntity.class)), BookResponseDto.class);
    }

    public List<BookEntity> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<BookEntity> searchByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }

    public List<BookEntity> searchByAuthorAndName(String author, String name) {
        return bookRepository.findByAuthorContainingIgnoreCaseAndNameContainingIgnoreCase(author, name);
    }
}
