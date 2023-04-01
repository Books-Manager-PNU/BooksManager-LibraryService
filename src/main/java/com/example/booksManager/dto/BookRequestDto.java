package com.example.booksManager.dto;

import com.example.booksManager.entity.Author;
import com.example.booksManager.entity.Publisher;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BookRequestDto(
        long id,
        @NotBlank(message = "title cannot be empty")
        String title,
        @NotNull(message = "description cannot be null")
        String description,
        @NotBlank(message = "author cannot be empty")
        Author author,
        @NotBlank(message = "publisher cannot be empty")
        Publisher publisher,
        @NotBlank(message = "publication date cannot be empty")
        LocalDateTime publicationDate
) {

}
