package com.example.java.metrics.domain.vo;

import java.util.concurrent.TimeUnit;

public abstract class CredentialAccess {
    private final String type;
    private final String hash;
    private final long creationDate;
    private final long expirationDate;
    private final long expiresIn;

    public CredentialAccess(
            final String type,
            final String hash,
            final long creationDate,
            final long expirationDate
    ) {
        this.type = type;
        this.hash = hash;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.expiresIn = TimeUnit.MINUTES.toSeconds(expirationDate - creationDate);
    }

    public String getType() {
        return type;
    }

    public String getHash() {
        return hash;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

}
