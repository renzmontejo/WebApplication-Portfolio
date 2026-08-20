package com.myapp.portfolio.backend.dto.request;

import com.myapp.portfolio.backend.model.MessageStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessageStatusRequest {

    @NotNull
    private MessageStatus status;
}