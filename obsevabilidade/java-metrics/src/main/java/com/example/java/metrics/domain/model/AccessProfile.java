package com.example.java.metrics.domain.model;

public final class AccessProfile {
    private final String id;
    private final String value;

    public AccessProfile(final String id, final String value) {
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
