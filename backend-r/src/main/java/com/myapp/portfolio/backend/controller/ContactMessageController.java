package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.request.ContactMessageCreateRequest;
import com.myapp.portfolio.backend.dto.request.ContactMessageStatusRequest;
import com.myapp.portfolio.backend.dto.response.ContactMessageResponse;
import com.myapp.portfolio.backend.service.ContactMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
@RequiredArgsConstructor
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @PostMapping
    public ResponseEntity<ContactMessageResponse> create(
            @Valid @RequestBody ContactMessageCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contactMessageService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ContactMessageResponse>> getAll() {
        return ResponseEntity.ok(
                contactMessageService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessageResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                contactMessageService.getById(id)
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ContactMessageResponse> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody ContactMessageStatusRequest request
    ) {
        return ResponseEntity.ok(
                contactMessageService.updateStatus(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        contactMessageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}