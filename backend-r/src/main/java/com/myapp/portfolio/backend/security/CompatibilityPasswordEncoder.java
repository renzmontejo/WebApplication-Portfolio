package com.myapp.portfolio.backend.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Supports legacy plaintext passwords while migrating to BCrypt.
 *
 * - If the stored value looks like a BCrypt hash, verify using BCrypt.
 * - Otherwise, treat the stored value as plaintext and do a direct match.
 */
public class CompatibilityPasswordEncoder implements PasswordEncoder {

    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Override
    public String encode(CharSequence rawPassword) {
        return bcrypt.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null) return false;
        if (looksLikeBcrypt(encodedPassword)) {
            return bcrypt.matches(rawPassword, encodedPassword);
        }
        return rawPassword != null && rawPassword.toString().equals(encodedPassword);
    }

    public static boolean looksLikeBcrypt(String value) {
        return value.startsWith("$2a$") || value.startsWith("$2b$") || value.startsWith("$2y$");
    }
}
