package com.example.booksManager.service.impl;

import com.example.booksManager.dto.BookRequestDto;
import com.example.booksManager.dto.BookResponseDto;
import com.example.booksManager.entity.Book;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.BookMapper;
import com.example.booksManager.repository.BookRepository;
import com.example.booksManager.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDto save(BookRequestDto book) {
        Book newBook = bookMapper.toEntity(book);
        return bookMapper.toBookResponseDto(bookRepository.save(newBook));
    }

    @Override
    public List<BookResponseDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toBookResponseDto)
                .toList();
    }

    @Override
    public BookResponseDto findById(Long id) {
        Book book = getExistingBookById(id);
        return bookMapper.toBookResponseDto(bookRepository.save(book));
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto bookDto) {
        Book book = getExistingBookById(id);
        bookMapper.updateEntity(bookDto, book);
        bookRepository.save(book);
        return bookMapper.toBookResponseDto(book);
    }

    @Override
    public void remove(Long id) {
        Book book = getExistingBookById(id);
        bookRepository.delete(book);
    }

    private Book getExistingBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Book not found"));
    }
}
