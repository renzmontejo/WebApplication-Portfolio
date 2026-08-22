package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.request.TechnologyRequest;
import com.myapp.portfolio.backend.dto.response.TechnologyResponse;
import com.myapp.portfolio.backend.model.TechnologyCategory;
import com.myapp.portfolio.backend.service.TechnologyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @PostMapping
    public ResponseEntity<TechnologyResponse> create(
            @Valid @RequestBody TechnologyRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(technologyService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> getAll(
            @RequestParam(required = false) TechnologyCategory category
    ) {
        if (category != null) {
            return ResponseEntity.ok(
                    technologyService.getByCategory(category)
            );
        }

        return ResponseEntity.ok(
                technologyService.getAll()
        );
    }

    @GetMapping("/grouped")
    public ResponseEntity<Map<TechnologyCategory, List<TechnologyResponse>>> getGrouped() {
        return ResponseEntity.ok(
                technologyService.getGroupedByCategory()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                technologyService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody TechnologyRequest request
    ) {
        return ResponseEntity.ok(
                technologyService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        technologyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}