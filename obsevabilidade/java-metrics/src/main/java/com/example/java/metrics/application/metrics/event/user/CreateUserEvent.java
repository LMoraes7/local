package com.example.java.metrics.application.metrics.event.user;

public abstract class CreateUserEvent {
    private final String username;

    public CreateUserEvent(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
