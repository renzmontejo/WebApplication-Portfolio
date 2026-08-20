package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.ContactMessageCreateRequest;
import com.myapp.portfolio.backend.dto.request.ContactMessageStatusRequest;
import com.myapp.portfolio.backend.dto.response.ContactMessageResponse;
import com.myapp.portfolio.backend.model.ContactMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContactMessageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ContactMessage toEntity(ContactMessageCreateRequest request);

    ContactMessageResponse toResponse(ContactMessage entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "messageType", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateStatus(
            ContactMessageStatusRequest request,
            @MappingTarget ContactMessage entity
    );
}