package com.example.java.metrics.application.metrics.event.login;

public abstract class LoginEvent {
    private final String username;

    public LoginEvent(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
