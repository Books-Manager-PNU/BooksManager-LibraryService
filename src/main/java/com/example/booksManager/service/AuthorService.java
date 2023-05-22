package com.example.booksManager.service;

import com.example.booksManager.dto.author.AuthorRequestDto;
import com.example.booksManager.dto.author.AuthorResponseDto;

public interface AuthorService extends CrudService<AuthorResponseDto, AuthorRequestDto> {
}
