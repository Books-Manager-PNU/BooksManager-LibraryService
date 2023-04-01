package com.example.booksManager.service;

import com.example.booksManager.dto.BookFullDto;

import java.util.List;

public interface BookService {
    BookFullDto save(BookFullDto book);
    List<BookFullDto> findAll(String title);
    BookFullDto findById(long id);
    BookFullDto update(long id, BookFullDto book);
    void remove(long id);
}
