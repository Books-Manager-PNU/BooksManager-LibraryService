package com.example.booksManager.dto.author;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequestDto(
        @NotBlank(message = "name cannot be empty")
        String name
) {
}
