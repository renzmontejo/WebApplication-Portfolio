package com.myapp.portfolio.backend.dto.response;

import com.myapp.portfolio.backend.model.ProjectType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {

    private Long id;
    private String title;
    private ProjectType projectType;
    private String description;
    private LocalDate dateCreated;

    @Builder.Default
    private Set<TechnologyResponse> technologies = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}