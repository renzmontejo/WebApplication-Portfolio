package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.ProjectRequest;
import com.myapp.portfolio.backend.dto.response.ProjectResponse;
import com.myapp.portfolio.backend.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring",
        uses = TechnologyMapper.class
)
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "technologies", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Project toEntity(ProjectRequest request);

    ProjectResponse toResponse(Project entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "technologies", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(
            ProjectRequest request,
            @MappingTarget Project entity
    );
}