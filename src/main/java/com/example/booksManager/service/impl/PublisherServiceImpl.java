package com.example.booksManager.service.impl;

import com.example.booksManager.dto.publisher.PublisherRequestDto;
import com.example.booksManager.dto.publisher.PublisherResponseDto;
import com.example.booksManager.entity.Publisher;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.PublisherMapper;
import com.example.booksManager.repository.PublisherRepository;
import com.example.booksManager.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public PublisherResponseDto save(PublisherRequestDto requestDto) {
        Publisher entity = publisherMapper.toEntity(requestDto);
        return publisherMapper.toResponseDto(publisherRepository.save(entity));
    }

    @Override
    public List<PublisherResponseDto> findAll() {
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::toResponseDto)
                .toList();
    }

    @Override
    public PublisherResponseDto findById(Long id) {
        Publisher entity = getExistingEntityById(id);
        return publisherMapper.toResponseDto(publisherRepository.save(entity));
    }

    @Override
    public PublisherResponseDto update(Long id, PublisherRequestDto requestDto) {
        Publisher entity = getExistingEntityById(id);
        publisherMapper.updateEntity(requestDto, entity);
        publisherRepository.save(entity);
        return publisherMapper.toResponseDto(entity);
    }

    @Override
    public void remove(Long id) {
        Publisher entity = getExistingEntityById(id);
        publisherRepository.delete(entity);
    }

    private Publisher getExistingEntityById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Publisher not found"));
    }
}
