package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.request.MeetingRequestCreateRequest;
import com.myapp.portfolio.backend.dto.request.MeetingRequestStatusRequest;
import com.myapp.portfolio.backend.dto.response.MeetingRequestResponse;
import com.myapp.portfolio.backend.service.MeetingRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meeting-requests")
@RequiredArgsConstructor
public class MeetingRequestController {

    private final MeetingRequestService meetingRequestService;

    @PostMapping
    public ResponseEntity<MeetingRequestResponse> create(
            @Valid @RequestBody MeetingRequestCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(meetingRequestService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MeetingRequestResponse>> getAll() {
        return ResponseEntity.ok(
                meetingRequestService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingRequestResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                meetingRequestService.getById(id)
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<MeetingRequestResponse> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody MeetingRequestStatusRequest request
    ) {
        return ResponseEntity.ok(
                meetingRequestService.updateStatus(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        meetingRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}