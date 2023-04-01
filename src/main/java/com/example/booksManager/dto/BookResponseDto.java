package com.example.booksManager.dto;

import com.example.booksManager.entity.Author;

public record BookResponseDto(
        long id,
        String title,
        String description,
        Author author
) {
}
