package com.myapp.portfolio.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceRequest {

    @NotBlank
    @Size(max = 150)
    private String jobTitle;

    @NotBlank
    @Size(max = 200)
    private String company;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean current;
}