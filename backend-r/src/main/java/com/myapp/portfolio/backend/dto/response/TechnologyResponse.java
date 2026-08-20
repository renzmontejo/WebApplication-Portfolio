package com.myapp.portfolio.backend.dto.response;

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
    private LocalDateTime createdAt;
}