package com.example.booksManager.mapper;

import com.example.booksManager.dto.author.AuthorRequestDto;
import com.example.booksManager.dto.author.AuthorResponseDto;
import com.example.booksManager.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponseDto toResponseDto(Author entity);
    Author toEntity(AuthorRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(AuthorRequestDto requestDto, @MappingTarget Author entity);
}
