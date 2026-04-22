package com.myapp.portfolio.backend.controller;

import com.myapp.portfolio.backend.dto.LoginRequest;
import com.myapp.portfolio.backend.dto.LoginResponse;
import com.myapp.portfolio.backend.model.Admin;
import com.myapp.portfolio.backend.repository.AdminRepository;
import com.myapp.portfolio.backend.security.CompatibilityPasswordEncoder;
import com.myapp.portfolio.backend.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UserDetailsService userDetailsService,
            AdminRepository adminRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            String token = jwtService.generateToken(userDetails);

            Admin admin = adminRepository.findByUsername(request.getUsername()).orElseThrow();
            if (!CompatibilityPasswordEncoder.looksLikeBcrypt(admin.getPassword())) {
                admin.setPassword(passwordEncoder.encode(request.getPassword()));
                adminRepository.save(admin);
            }

            return ResponseEntity.ok(
                    new LoginResponse(token, admin.getUsername(), admin.getRole())
            );

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(org.springframework.security.core.Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = authentication.getName();
        Admin admin = adminRepository.findByUsername(username).orElseThrow();

        return ResponseEntity.ok(admin);
    }
}