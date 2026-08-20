package com.myapp.portfolio.backend.dto.request;

import com.myapp.portfolio.backend.model.ProjectType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequest {

    @NotBlank
    @Size(max = 200)
    private String title;

    @NotNull
    private ProjectType projectType;

    private String description;

    private LocalDate dateCreated;

    @Builder.Default
    private Set<Long> technologyIds = new HashSet<>();
}