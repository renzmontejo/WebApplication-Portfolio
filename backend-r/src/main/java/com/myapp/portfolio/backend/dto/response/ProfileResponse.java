package com.myapp.portfolio.backend.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {

    private Long id;
    private String name;
    private String headline;
    private String about;
    private String email;
    private String phone;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}