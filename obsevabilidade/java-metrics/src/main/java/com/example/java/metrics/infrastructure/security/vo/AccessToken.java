package com.example.java.metrics.infrastructure.security.vo;

import com.example.java.metrics.domain.vo.CredentialAccess;

public final class AccessToken extends CredentialAccess {

    public AccessToken(
            final String type,
            final String credential,
            final long creationDate,
            final long expirationDate
    ) {
        super(type, credential, creationDate, expirationDate);
    }

}
