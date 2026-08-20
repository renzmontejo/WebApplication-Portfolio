package com.myapp.portfolio.backend.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceResponse {

    private Long id;
    private String jobTitle;
    private String company;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean current;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}