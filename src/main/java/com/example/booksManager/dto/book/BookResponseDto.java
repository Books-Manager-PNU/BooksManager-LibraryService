package com.example.booksManager.dto.book;

public record BookResponseDto(
        Long id,
        String title,
        String description,
        Long authorId
) {
}
