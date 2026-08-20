package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.ExperienceRequest;
import com.myapp.portfolio.backend.dto.response.ExperienceResponse;
import com.myapp.portfolio.backend.model.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Experience toEntity(ExperienceRequest request);

    ExperienceResponse toResponse(Experience entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(
            ExperienceRequest request,
            @MappingTarget Experience entity
    );
}