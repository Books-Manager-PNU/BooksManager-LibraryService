package com.example.booksManager.service;

import com.example.booksManager.dto.book.BookRequestDto;
import com.example.booksManager.dto.book.BookResponseDto;

public interface BookService extends CrudService<BookResponseDto, BookRequestDto> {
}
