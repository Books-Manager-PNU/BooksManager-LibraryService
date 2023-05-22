package com.example.booksManager.service.impl;

import com.example.booksManager.dto.author.AuthorRequestDto;
import com.example.booksManager.dto.author.AuthorResponseDto;
import com.example.booksManager.entity.Author;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.AuthorMapper;
import com.example.booksManager.repository.AuthorRepository;
import com.example.booksManager.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDto save(AuthorRequestDto requestDto) {
        Author entity = authorMapper.toEntity(requestDto);
        return authorMapper.toResponseDto(authorRepository.save(entity));
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponseDto)
                .toList();
    }

    @Override
    public AuthorResponseDto findById(Long id) {
        Author entity = getExistingEntityById(id);
        return authorMapper.toResponseDto(authorRepository.save(entity));
    }

    @Override
    public AuthorResponseDto update(Long id, AuthorRequestDto requestDto) {
        Author entity = getExistingEntityById(id);
        authorMapper.updateEntity(requestDto, entity);
        authorRepository.save(entity);
        return authorMapper.toResponseDto(entity);
    }

    @Override
    public void remove(Long id) {
        Author entity = getExistingEntityById(id);
        authorRepository.delete(entity);
    }

    private Author getExistingEntityById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Author not found"));
    }
}
