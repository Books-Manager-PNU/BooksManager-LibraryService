package com.example.booksManager.mapper;

import com.example.booksManager.dto.BookFullDto;
import com.example.booksManager.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookFullDto toBookFullDto(Book book);
    Book toEntity(BookFullDto book);
}
