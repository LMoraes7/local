package com.example.java.metrics.infrastructure.security.repository;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository {
    Optional<UserDetails> findByIdWithAccessProfile(final String id);

    Optional<UserDetails> findByUsername(final String username);
}
