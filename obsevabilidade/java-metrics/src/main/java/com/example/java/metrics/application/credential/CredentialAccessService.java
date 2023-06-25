package com.example.java.metrics.application.credential;

import com.example.java.metrics.domain.model.User;
import com.example.java.metrics.domain.vo.CredentialAccess;

public interface CredentialAccessService {
    CredentialAccess generateCredentialAccess(final User user);
    String getOwnerIdentifier(final String hash);
    boolean credentialAccessIsValid(final String hash);
}
