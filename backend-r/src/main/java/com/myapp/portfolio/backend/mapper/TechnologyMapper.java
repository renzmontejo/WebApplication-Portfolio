package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.TechnologyRequest;
import com.myapp.portfolio.backend.dto.response.TechnologyResponse;
import com.myapp.portfolio.backend.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Technology toEntity(TechnologyRequest request);

    TechnologyResponse toResponse(Technology entity);
}