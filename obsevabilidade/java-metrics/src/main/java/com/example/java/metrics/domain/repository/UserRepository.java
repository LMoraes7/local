package com.example.java.metrics.domain.repository;

import com.example.java.metrics.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(final String id);
    boolean save(final User user);
    boolean existsByUsername(final String username);
}
