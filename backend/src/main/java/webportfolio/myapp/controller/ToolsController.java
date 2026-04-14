package webportfolio.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webportfolio.myapp.service.ToolService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tools")
public class ToolsController {

    private final ToolService toolservice;

    @Autowired
    public ToolsController(ToolService toolservice)
    {
        this.toolservice=toolservice;
    }

    @GetMapping("{id}")
    public Tools findToolById(@PathVariable Long id) {
        return toolservice.getToolById(id);
    }

    @GetMapping
    public List<Tools> getAllTools() {
        return toolservice.getAllTools();
    }

    @PostMapping
    public Tools createTools(@RequestBody Tools tools) {
        return toolservice.createTool(tools);
    }
}
