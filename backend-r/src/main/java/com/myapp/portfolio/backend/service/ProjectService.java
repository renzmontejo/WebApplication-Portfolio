package com.myapp.portfolio.backend.service;

import com.myapp.portfolio.backend.dto.request.ProjectRequest;
import com.myapp.portfolio.backend.dto.response.ProjectResponse;
import com.myapp.portfolio.backend.exception.ResourceNotFoundException;
import com.myapp.portfolio.backend.mapper.ProjectMapper;
import com.myapp.portfolio.backend.model.Project;
import com.myapp.portfolio.backend.model.Technology;
import com.myapp.portfolio.backend.repository.ProjectRepository;
import com.myapp.portfolio.backend.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TechnologyRepository technologyRepository;
    private final ProjectMapper projectMapper;

    public ProjectResponse create(ProjectRequest request) {

        Project project = projectMapper.toEntity(request);

        project.setTechnologies(
                findTechnologies(request.getTechnologyIds())
        );

        Project saved = projectRepository.save(project);

        return projectMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ProjectResponse getById(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found with id: " + id
                        )
                );

        return projectMapper.toResponse(project);
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getAll() {

        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toResponse)
                .toList();
    }

    public ProjectResponse update(
            Long id,
            ProjectRequest request
    ) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found with id: " + id
                        )
                );

        projectMapper.update(request, project);

        project.setTechnologies(
                findTechnologies(request.getTechnologyIds())
        );

        return projectMapper.toResponse(project);
    }

    public void delete(Long id) {

        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Project not found with id: " + id
            );
        }

        projectRepository.deleteById(id);
    }

    private Set<Technology> findTechnologies(Set<Long> technologyIds) {

        if (technologyIds == null || technologyIds.isEmpty()) {
            return new HashSet<>();
        }

        List<Technology> technologies =
                technologyRepository.findAllById(technologyIds);

        if (technologies.size() != technologyIds.size()) {
            throw new ResourceNotFoundException(
                    "One or more technology IDs do not exist."
            );
        }

        return new HashSet<>(technologies);
    }
}