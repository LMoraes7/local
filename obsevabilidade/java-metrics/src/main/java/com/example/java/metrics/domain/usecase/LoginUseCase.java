package com.example.java.metrics.domain.usecase;

import com.example.java.metrics.domain.vo.CredentialAccess;

public interface LoginUseCase {
    CredentialAccess login(final String username, final String password);
}
