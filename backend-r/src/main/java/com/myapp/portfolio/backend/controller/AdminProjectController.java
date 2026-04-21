package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.model.Project;
import com.myapp.portfolio.backend.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminProjectController {

    private final ProjectRepository projectRepository;

    public AdminProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody Project request) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setTitle(request.getTitle());
                    project.setProjectType(request.getProjectType());
                    project.setDateCreated(request.getDateCreated());
                    project.setDescription(request.getDescription());
                    project.setTechStack(request.getTechStack());

                    projectRepository.save(project);
                    return ResponseEntity.ok(project);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        return projectRepository.findById(id)
                .map(project -> {
                    projectRepository.delete(project);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}