package com.example.booksManager.mapper;

import com.example.booksManager.dto.BookRequestDto;
import com.example.booksManager.dto.BookResponseDto;
import com.example.booksManager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDto toBookResponseDto(Book book);
    Book toEntity(BookRequestDto book);

    @Mapping(target = "id", ignore = true)
    void updateEntity(BookRequestDto bookDto, @MappingTarget Book book);
}
