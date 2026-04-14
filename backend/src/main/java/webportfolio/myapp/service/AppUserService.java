package webportfolio.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webportfolio.myapp.repository.AppUserRepository;

import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser>  findAll() {
        return appUserRepository.findAll();
    }

    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("no User Found"));
    }

    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}
