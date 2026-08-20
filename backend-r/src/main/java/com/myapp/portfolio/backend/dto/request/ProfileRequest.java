package com.myapp.portfolio.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 255)
    private String headline;

    private String about;

    @Size(max = 150)
    private String email;

    @Size(max = 30)
    private String phone;

    @Size(max = 150)
    private String location;
}