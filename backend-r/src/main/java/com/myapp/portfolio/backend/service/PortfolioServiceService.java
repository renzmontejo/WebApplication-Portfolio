package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.PortfolioServiceRequest;
import com.myapp.portfolio.backend.dto.response.PortfolioServiceResponse;
import com.myapp.portfolio.backend.mapper.PortfolioServiceMapper;
import com.myapp.portfolio.backend.model.PortfolioService;
import com.myapp.portfolio.backend.model.ServiceItem;
import com.myapp.portfolio.backend.repository.PortfolioServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioServiceService {

    private final PortfolioServiceRepository portfolioServiceRepository;
    private final PortfolioServiceMapper portfolioServiceMapper;

    public PortfolioServiceResponse create(
            PortfolioServiceRequest request
    ) {
        PortfolioService service =
                portfolioServiceMapper.toEntity(request);

        attachItemsToService(service);

        PortfolioService saved =
                portfolioServiceRepository.save(service);

        return portfolioServiceMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public PortfolioServiceResponse getById(Long id) {
        PortfolioService service =
                portfolioServiceRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Service not found with id: " + id
                                )
                        );

        return portfolioServiceMapper.toResponse(service);
    }

    @Transactional(readOnly = true)
    public List<PortfolioServiceResponse> getAll() {
        return portfolioServiceRepository.findAll()
                .stream()
                .map(portfolioServiceMapper::toResponse)
                .toList();
    }

    public PortfolioServiceResponse update(
            Long id,
            PortfolioServiceRequest request
    ) {
        PortfolioService service =
                portfolioServiceRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Service not found with id: " + id
                                )
                        );

        portfolioServiceMapper.update(request, service);

        attachItemsToService(service);

        return portfolioServiceMapper.toResponse(service);
    }

    public void delete(Long id) {
        if (!portfolioServiceRepository.existsById(id)) {
            throw new RuntimeException(
                    "Service not found with id: " + id
            );
        }

        portfolioServiceRepository.deleteById(id);
    }

    private void attachItemsToService(PortfolioService service) {

        if (service.getItems() == null) {
            return;
        }

        for (ServiceItem item : service.getItems()) {
            item.setService(service);
        }
    }
}