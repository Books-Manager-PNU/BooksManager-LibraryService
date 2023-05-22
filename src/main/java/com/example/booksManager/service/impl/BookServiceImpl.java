package com.example.booksManager.service.impl;

import com.example.booksManager.dto.book.BookRequestDto;
import com.example.booksManager.dto.book.BookResponseDto;
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
    public BookResponseDto save(BookRequestDto requestDto) {
        Book entity = bookMapper.toEntity(requestDto);
        return bookMapper.toBookResponseDto(bookRepository.save(entity));
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
        Book entity = getExistingEntityById(id);
        return bookMapper.toBookResponseDto(bookRepository.save(entity));
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto requestDto) {
        Book entity = getExistingEntityById(id);
        bookMapper.updateEntity(requestDto, entity);
        bookRepository.save(entity);
        return bookMapper.toBookResponseDto(entity);
    }

    @Override
    public void remove(Long id) {
        Book entity = getExistingEntityById(id);
        bookRepository.delete(entity);
    }

    private Book getExistingEntityById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Book not found"));
    }
}
