package com.example.booksManager.controller;

import com.example.booksManager.dto.publisher.PublisherRequestDto;
import com.example.booksManager.dto.publisher.PublisherResponseDto;
import com.example.booksManager.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherResponseDto> add(
            @RequestBody PublisherRequestDto requestDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(publisherService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAll() {
        return ResponseEntity.ok(publisherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> update(
            @PathVariable Long id,
            @RequestBody PublisherRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(publisherService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        publisherService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
