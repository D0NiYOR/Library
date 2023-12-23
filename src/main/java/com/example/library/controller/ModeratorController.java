package com.example.library.controller;

import com.example.library.model.BookEntity;
import com.example.library.model.request.AuthDto;
import com.example.library.model.request.BookDto;
import com.example.library.model.response.BookResponseDto;
import com.example.library.model.response.BronResponse;
import com.example.library.model.response.JwtResponse;
import com.example.library.model.response.TakeAwayResponseDto;
import com.example.library.service.BookService;
import com.example.library.service.BronService;
import com.example.library.service.TakeAwayService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/moderators")
@SecurityRequirement(name = "Bearer Authentication")
public class ModeratorController {
    private final BookService bookService;
    private final TakeAwayService takeAwayService;
    private final ModelMapper modelMapper;
    private final BronService bronService;
    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/addBook")
    public BookResponseDto createBook(@Valid @RequestBody BookDto dto) {
        return bookService.createBook(dto);
    }
    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/searchByAuthor")
    public List<BookResponseDto> searchByAuthor(@RequestParam String author) {
        return modelMapper.map(bookService.searchByAuthor(author), new TypeToken<List<BookResponseDto>>(){}.getType());
    }
    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/searchByName")
    public List<BookResponseDto> searchByName(@RequestParam String name) {
        return modelMapper.map(bookService.searchByName(name), new TypeToken<List<BookResponseDto>>(){}.getType());
    }
    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/searchByAuthorAndName")
    public List<BookResponseDto> searchByAuthorAndName(@RequestParam String author, @RequestParam String name) {
        return modelMapper.map(bookService.searchByAuthorAndName(author,name), new TypeToken<List<BookResponseDto>>(){}.getType());
    }
    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/bronBooks")
    public List<BronResponse> bronBooks(){
        return bronService.getAll();
    }
 @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/takeAwayBooks")
    public List<TakeAwayResponseDto> takeAwayBooks(){
        return takeAwayService.getAll();
    }

}
