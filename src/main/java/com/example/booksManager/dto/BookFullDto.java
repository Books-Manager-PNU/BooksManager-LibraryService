package com.example.booksManager.dto;

import com.example.booksManager.entity.Author;
import com.example.booksManager.entity.Publisher;

import java.time.LocalDateTime;

public record BookFullDto(
        long id,
        String title,
        String description,
        Author author,
        Publisher publisher,
        LocalDateTime publicationDate
) {
}
