package com.myapp.portfolio.backend.dto.request;

import com.myapp.portfolio.backend.model.TechnologyCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnologyRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private TechnologyCategory category;
}