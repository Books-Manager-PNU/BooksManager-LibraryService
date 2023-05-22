package com.example.booksManager.mapper;

import com.example.booksManager.dto.publisher.PublisherRequestDto;
import com.example.booksManager.dto.publisher.PublisherResponseDto;
import com.example.booksManager.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherResponseDto toResponseDto(Publisher entity);
    Publisher toEntity(PublisherRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(PublisherRequestDto requestDto, @MappingTarget Publisher entity);
}
