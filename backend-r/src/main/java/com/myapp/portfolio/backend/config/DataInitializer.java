package com.myapp.portfolio.backend.config;

import com.myapp.portfolio.backend.model.Admin;
import com.myapp.portfolio.backend.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAdmin(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (adminRepository.findByUsername("admin").isEmpty()) {
                Admin admin = new Admin();
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                admin.setIsActive(true);

                adminRepository.save(admin);

                System.out.println("Default admin created:");
                System.out.println("username: admin");
                System.out.println("password: admin123");
            }
        };
    }
}