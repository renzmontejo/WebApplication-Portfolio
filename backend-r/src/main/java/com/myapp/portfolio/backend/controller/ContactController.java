package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.ContactRequest;
import com.myapp.portfolio.backend.model.ContactMessage;
import com.myapp.portfolio.backend.repository.ContactMessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    public ContactController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody ContactRequest request) {
        System.out.println("=== CONTACT REQUEST RECEIVED ===");
        System.out.println("Name: " + request.getName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Phone: " + request.getPhone());
        System.out.println("Message: " + request.getMessage());

        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(request.getName());
        contactMessage.setEmail(request.getEmail());
        contactMessage.setPhone(request.getPhone());
        contactMessage.setMessage(request.getMessage());
        contactMessage.setStatus("NEW");

        ContactMessage saved = contactMessageRepository.save(contactMessage);

        System.out.println("=== SAVED ID: " + saved.getId() + " ===");

        return ResponseEntity.ok(saved);
    }
}