package com.example.java.metrics.infrastructure.database.postgres.entity;

public final class AccessProfileEntity {
    private final String id;
    private final String value;

    public AccessProfileEntity(final String id, final String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
