package com.myapp.portfolio.backend.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioServiceResponse {

    private Long id;
    private String title;
    private String description;
    private String icon;

    @Builder.Default
    private List<ServiceItemResponse> items = new ArrayList<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}