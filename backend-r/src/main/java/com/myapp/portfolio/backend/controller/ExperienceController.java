package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.request.ExperienceRequest;
import com.myapp.portfolio.backend.dto.response.ExperienceResponse;
import com.myapp.portfolio.backend.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<ExperienceResponse> create(
            @Valid @RequestBody ExperienceRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(experienceService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ExperienceResponse>> getAll() {
        return ResponseEntity.ok(
                experienceService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                experienceService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ExperienceRequest request
    ) {
        return ResponseEntity.ok(
                experienceService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        experienceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}