package webportfolio.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webportfolio.myapp.repository.BackendRepository;

import java.util.List;

@Service
public class BackendService {
    private final BackendRepository backendRepo;

    @Autowired
    public BackendService(BackendRepository backendRepo) {
        this.backendRepo = backendRepo;
    }

    public Backend createBackend(Backend backend) {
        return backendRepo.save(backend);
    }

    public List<Backend> findAllBackends() {
        return backendRepo.findAll();
    }

    public Backend getBackendById(Long id) {
        return backendRepo.findById(id).orElseThrow(() -> new RuntimeException("ID Not Found"));
    }
}
