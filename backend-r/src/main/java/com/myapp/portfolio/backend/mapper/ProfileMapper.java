package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.ProfileRequest;
import com.myapp.portfolio.backend.dto.response.ProfileResponse;
import com.myapp.portfolio.backend.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Profile toEntity(ProfileRequest request);

    ProfileResponse toResponse(Profile entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(
            ProfileRequest request,
            @MappingTarget Profile entity
    );
}