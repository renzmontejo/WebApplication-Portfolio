package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.ExperienceRequest;
import com.myapp.portfolio.backend.dto.response.ExperienceResponse;
import com.myapp.portfolio.backend.exception.ResourceNotFoundException;
import com.myapp.portfolio.backend.mapper.ExperienceMapper;
import com.myapp.portfolio.backend.model.Experience;
import com.myapp.portfolio.backend.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    public ExperienceResponse create(ExperienceRequest request) {

        Experience experience =
                experienceMapper.toEntity(request);

        Experience saved =
                experienceRepository.save(experience);

        return experienceMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ExperienceResponse getById(Long id) {

        Experience experience =
                experienceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Experience not found with id: " + id
                                )
                        );

        return experienceMapper.toResponse(experience);
    }

    @Transactional(readOnly = true)
    public List<ExperienceResponse> getAll() {

        return experienceRepository.findAll()
                .stream()
                .map(experienceMapper::toResponse)
                .toList();
    }

    public ExperienceResponse update(
            Long id,
            ExperienceRequest request
    ) {

        Experience experience =
                experienceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Experience not found with id: " + id
                                )
                        );

        experienceMapper.update(request, experience);

        return experienceMapper.toResponse(experience);
    }

    public void delete(Long id) {

        if (!experienceRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Experience not found with id: " + id
            );
        }

        experienceRepository.deleteById(id);
    }
}