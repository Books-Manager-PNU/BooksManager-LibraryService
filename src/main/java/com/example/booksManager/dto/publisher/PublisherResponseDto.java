package com.example.booksManager.dto.publisher;

public record PublisherResponseDto(
        Long id,
        String name,
        String location,
        String website
) {

}
