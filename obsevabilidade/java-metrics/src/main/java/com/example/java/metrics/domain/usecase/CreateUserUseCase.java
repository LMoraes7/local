package com.example.java.metrics.domain.usecase;

import com.example.java.metrics.domain.model.User;

public interface CreateUserUseCase {
    User createUser(final String username, final String password);
}
