package com.myapp.portfolio.backend.dto.request;

import com.myapp.portfolio.backend.model.MeetingStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRequestStatusRequest {

    @NotNull
    private MeetingStatus status;
}