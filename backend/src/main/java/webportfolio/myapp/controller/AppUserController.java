package webportfolio.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webportfolio.myapp.service.AppUserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/app-user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("{id}")
    public AppUser getAppUserById(@PathVariable Long id) {
        return appUserService.findById(id);
    }

    @GetMapping
    public List<AppUser> getAllAppUsers() {
        return appUserService.findAll();
    }

    public AppUser saveAppUser(AppUser appUser) {
        return appUserService.save(appUser);
    }
}


