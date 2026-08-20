package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.MeetingRequestCreateRequest;
import com.myapp.portfolio.backend.dto.request.MeetingRequestStatusRequest;
import com.myapp.portfolio.backend.dto.response.MeetingRequestResponse;
import com.myapp.portfolio.backend.model.MeetingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MeetingRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    MeetingRequest toEntity(MeetingRequestCreateRequest request);

    MeetingRequestResponse toResponse(MeetingRequest entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fullName", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "meetingType", ignore = true)
    @Mapping(target = "preferredDate", ignore = true)
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateStatus(
            MeetingRequestStatusRequest request,
            @MappingTarget MeetingRequest entity
    );
}