package com.myapp.portfolio.backend.dto.response;

import com.myapp.portfolio.backend.model.MessageStatus;
import com.myapp.portfolio.backend.model.MessageType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessageResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private MessageType messageType;
    private MessageStatus status;
    private LocalDateTime createdAt;
}