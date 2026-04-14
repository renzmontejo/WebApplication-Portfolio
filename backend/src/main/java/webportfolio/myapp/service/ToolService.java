package webportfolio.myapp.service;

import org.springframework.stereotype.Service;
import webportfolio.myapp.repository.ToolsRepository;

import java.util.List;

@Service
public class ToolService {

    private final ToolsRepository toolRepository;

    public ToolService(ToolsRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public Tools createTool(Tools tool) {
        return toolRepository.save(tool);
    }

    public List<Tools> getAllTools() {
        return toolRepository.findAll();
    }

    public Tools getToolById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found with id: " + id));
    }
}