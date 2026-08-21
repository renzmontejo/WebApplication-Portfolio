package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.request.ProfileRequest;
import com.myapp.portfolio.backend.dto.response.ProfileResponse;
import com.myapp.portfolio.backend.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileResponse> create(
            @Valid @RequestBody ProfileRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profileService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAll() {
        return ResponseEntity.ok(
                profileService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                profileService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ProfileRequest request
    ) {
        return ResponseEntity.ok(
                profileService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}