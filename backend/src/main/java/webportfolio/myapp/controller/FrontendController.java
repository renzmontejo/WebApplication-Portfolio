package webportfolio.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webportfolio.myapp.service.FrontendService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/frontends")
public class FrontendController {

    private final FrontendService frontendService;

    @Autowired
    public  FrontendController(FrontendService frontendService) {
        this.frontendService = frontendService;
    }

    @PostMapping
    public Frontend makeFrontEnd(@RequestBody Frontend frontend) {
        return frontendService.saveAllFrontend(frontend);
    }

    @GetMapping
    public List<Frontend> getAllProjects() {
        return frontendService.getAllFrontend();
    }

    @GetMapping("{id}")
    public Frontend findFrontendById(Long id) {
        return frontendService.getFrontendById(id);
    }
}
