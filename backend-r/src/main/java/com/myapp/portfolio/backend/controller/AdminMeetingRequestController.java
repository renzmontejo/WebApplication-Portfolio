package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.model.MeetingRequest;
import com.myapp.portfolio.backend.repository.MeetingRequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/meetings")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminMeetingRequestController {

    private final MeetingRequestRepository meetingRequestRepository;

    public AdminMeetingRequestController(MeetingRequestRepository meetingRequestRepository) {
        this.meetingRequestRepository = meetingRequestRepository;
    }

    @GetMapping
    public List<MeetingRequest> getAllMeetingRequests() {
        return meetingRequestRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMeetingById(@PathVariable Long id) {
        return meetingRequestRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<?> markAsRead(@PathVariable Long id) {
        return meetingRequestRepository.findById(id)
                .map(meeting -> {
                    meeting.setIsRead(true);
                    if ("NEW".equalsIgnoreCase(meeting.getStatus())) {
                        meeting.setStatus("READ");
                    }
                    meetingRequestRepository.save(meeting);
                    return ResponseEntity.ok(meeting);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return meetingRequestRepository.findById(id)
                .map(meeting -> {
                    meeting.setStatus(body.get("status"));
                    meetingRequestRepository.save(meeting);
                    return ResponseEntity.ok(meeting);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}