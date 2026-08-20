package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.ServiceItemRequest;
import com.myapp.portfolio.backend.dto.response.ServiceItemResponse;
import com.myapp.portfolio.backend.model.ServiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceItemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "service", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ServiceItem toEntity(ServiceItemRequest request);

    ServiceItemResponse toResponse(ServiceItem entity);
}