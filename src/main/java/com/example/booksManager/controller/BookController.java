package com.example.booksManager.controller;

import com.example.booksManager.dto.BookRequestDto;
import com.example.booksManager.dto.BookResponseDto;
import com.example.booksManager.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto addBook(@RequestBody BookRequestDto bookDto) {
        return bookService.save(bookDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponseDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponseDto findById(@PathVariable long id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookResponseDto updateTaskById(@PathVariable long id, @RequestBody BookRequestDto bookDto) {
        return bookService.update(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable long id) {
        bookService.remove(id);
    }

}
