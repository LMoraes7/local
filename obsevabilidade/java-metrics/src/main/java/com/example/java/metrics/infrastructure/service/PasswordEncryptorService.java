package com.example.java.metrics.infrastructure.service;

import com.example.java.metrics.application.crypter.UserPasswordEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class PasswordEncryptorService implements UserPasswordEncryptor {

    private final PasswordEncoder encoder;

    public PasswordEncryptorService(final PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encryptUserPassword(final String password) {
        return this.encoder.encode(password);
    }

}
