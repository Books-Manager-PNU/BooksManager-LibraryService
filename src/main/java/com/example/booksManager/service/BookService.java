package com.example.booksManager.service;

import com.example.booksManager.dto.BookRequestDto;
import com.example.booksManager.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto save(BookRequestDto book);
    List<BookResponseDto> findAll();
    BookResponseDto findById(long id);
    BookResponseDto update(long id, BookRequestDto book);
    void remove(long id);
}
