package com.myapp.portfolio.backend.dto.response;

import com.myapp.portfolio.backend.model.MeetingStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRequestResponse {

    private Long id;
    private String fullName;
    private String email;
    private String meetingType;
    private LocalDate preferredDate;
    private String message;
    private MeetingStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}