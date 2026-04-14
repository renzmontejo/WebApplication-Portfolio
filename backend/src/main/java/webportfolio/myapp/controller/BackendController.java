package webportfolio.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webportfolio.myapp.service.BackendService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/backends")
public class BackendController {

    private final BackendService backendService;

    @Autowired
    public BackendController(BackendService backendService) {
        this.backendService = backendService;
    }

    @PostMapping
    public Backend createBackend(@RequestBody Backend backend) {
        return backendService.createBackend(backend);
    }

    @GetMapping
    public List<Backend> getBackendBy() {
        return backendService.findAllBackends();
    }

    @GetMapping("{id}")
    public Backend getBackendById(@PathVariable Long id) {
        return backendService.getBackendById(id);
    }
}

