package com.example.booksManager.dto.publisher;

import jakarta.validation.constraints.NotBlank;

public record PublisherRequestDto(
        @NotBlank(message = "name cannot be empty")
        String name,
        @NotBlank(message = "location cannot be empty")
        String location,
        @NotBlank(message = "website cannot be empty")
        String website
) {

}
