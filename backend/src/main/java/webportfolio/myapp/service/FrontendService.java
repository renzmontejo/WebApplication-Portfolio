package webportfolio.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webportfolio.myapp.repository.FrontendRepository;

import java.util.List;

@Service
public class FrontendService {
    private FrontendRepository frontendRepository;
    @Autowired
    public FrontendService(FrontendRepository frontendRepository) {
        this.frontendRepository = frontendRepository;
    }

    public Frontend saveAllFrontend(Frontend frontend) {
        return frontendRepository.save(frontend);
    }

    public Frontend getFrontendById(Long id) {
        return frontendRepository.findById(id).orElseThrow(() -> new RuntimeException("No frontend found with this id"));
    }

    public List<Frontend> getAllFrontend() {
        return frontendRepository.findAll();
    }
}
