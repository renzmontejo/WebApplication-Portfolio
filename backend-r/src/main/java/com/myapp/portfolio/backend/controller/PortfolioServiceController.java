package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.request.PortfolioServiceRequest;
import com.myapp.portfolio.backend.dto.response.PortfolioServiceResponse;
import com.myapp.portfolio.backend.service.PortfolioServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class PortfolioServiceController {

    private final PortfolioServiceService portfolioServiceService;

    @PostMapping
    public ResponseEntity<PortfolioServiceResponse> create(
            @Valid @RequestBody PortfolioServiceRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(portfolioServiceService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PortfolioServiceResponse>> getAll() {
        return ResponseEntity.ok(
                portfolioServiceService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioServiceResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                portfolioServiceService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioServiceResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody PortfolioServiceRequest request
    ) {
        return ResponseEntity.ok(
                portfolioServiceService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        portfolioServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}