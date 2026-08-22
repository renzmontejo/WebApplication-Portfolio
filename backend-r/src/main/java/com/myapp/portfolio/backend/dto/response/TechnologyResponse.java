package com.myapp.portfolio.backend.dto.response;

import com.myapp.portfolio.backend.model.TechnologyCategory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnologyResponse {

    private Long id;
    private String name;
    private TechnologyCategory category;
    private LocalDateTime createdAt;
}