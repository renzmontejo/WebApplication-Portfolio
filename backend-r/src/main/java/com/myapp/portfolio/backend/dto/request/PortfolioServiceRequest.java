package com.myapp.portfolio.backend.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioServiceRequest {

    @NotBlank
    @Size(max = 150)
    private String title;

    private String description;

    @Size(max = 150)
    private String icon;

    @Valid
    @Builder.Default
    private List<ServiceItemRequest> items = new ArrayList<>();
}