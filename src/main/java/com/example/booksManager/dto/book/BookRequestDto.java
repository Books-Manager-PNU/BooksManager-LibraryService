package com.example.booksManager.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BookRequestDto(
        @NotBlank(message = "title cannot be empty")
        String title,
        @NotNull(message = "description cannot be null")
        String description,
        @NotBlank(message = "author cannot be empty")
        Long authorId,
        @NotBlank(message = "publisher cannot be empty")
        Long publisherId,
        @NotBlank(message = "publication date cannot be empty")
        LocalDateTime publicationDate
) {

}
