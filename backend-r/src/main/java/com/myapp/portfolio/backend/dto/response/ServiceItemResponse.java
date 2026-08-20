package com.myapp.portfolio.backend.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceItemResponse {

    private Long id;
    private String item;
    private LocalDateTime createdAt;
}