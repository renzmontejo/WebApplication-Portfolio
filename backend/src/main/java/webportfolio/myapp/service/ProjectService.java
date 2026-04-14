package webportfolio.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webportfolio.myapp.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Projects createProject(Projects project) {
        return projectRepository.save(project);
    }

    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    public Projects getProjectById(Long id){
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("cannot find project with this id"));
    }
}
