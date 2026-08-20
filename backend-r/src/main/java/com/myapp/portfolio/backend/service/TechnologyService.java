package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.TechnologyRequest;
import com.myapp.portfolio.backend.dto.response.TechnologyResponse;
import com.myapp.portfolio.backend.mapper.TechnologyMapper;
import com.myapp.portfolio.backend.model.Technology;
import com.myapp.portfolio.backend.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TechnologyService {

    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;

    public TechnologyResponse create(TechnologyRequest request) {

        if (technologyRepository.existsByNameIgnoreCase(request.getName())) {
            throw new RuntimeException(
                    "Technology already exists: " + request.getName()
            );
        }

        Technology technology = technologyMapper.toEntity(request);

        Technology saved = technologyRepository.save(technology);

        return technologyMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public TechnologyResponse getById(Long id) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Technology not found with id: " + id
                        )
                );

        return technologyMapper.toResponse(technology);
    }

    @Transactional(readOnly = true)
    public List<TechnologyResponse> getAll() {
        return technologyRepository.findAll()
                .stream()
                .map(technologyMapper::toResponse)
                .toList();
    }

    public TechnologyResponse update(
            Long id,
            TechnologyRequest request
    ) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Technology not found with id: " + id
                        )
                );

        if (technologyRepository.existsByNameIgnoreCaseAndIdNot(
                request.getName(),
                id
        )) {
            throw new RuntimeException(
                    "Technology already exists: " + request.getName()
            );
        }

        technology.setName(request.getName());

        return technologyMapper.toResponse(technology);
    }

    public void delete(Long id) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Technology not found with id: " + id
                        )
                );

        technologyRepository.delete(technology);
    }
}