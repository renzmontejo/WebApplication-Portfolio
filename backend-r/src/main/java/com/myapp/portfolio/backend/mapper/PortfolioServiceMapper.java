package com.myapp.portfolio.backend.mapper;

import com.myapp.portfolio.backend.dto.request.PortfolioServiceRequest;
import com.myapp.portfolio.backend.dto.response.PortfolioServiceResponse;
import com.myapp.portfolio.backend.model.PortfolioService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring",
        uses = ServiceItemMapper.class
)
public interface PortfolioServiceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PortfolioService toEntity(PortfolioServiceRequest request);

    PortfolioServiceResponse toResponse(PortfolioService entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(
            PortfolioServiceRequest request,
            @MappingTarget PortfolioService entity
    );
}