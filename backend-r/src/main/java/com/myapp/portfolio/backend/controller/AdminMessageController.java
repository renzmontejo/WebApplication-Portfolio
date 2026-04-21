package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.model.ContactMessage;
import com.myapp.portfolio.backend.repository.ContactMessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminMessageController {

    private final ContactMessageRepository contactMessageRepository;

    public AdminMessageController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable Long id) {
        return contactMessageRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<?> markAsRead(@PathVariable Long id) {
        return contactMessageRepository.findById(id)
                .map(message -> {
                    message.setStatus("READ");
                    contactMessageRepository.save(message);
                    return ResponseEntity.ok(message);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}