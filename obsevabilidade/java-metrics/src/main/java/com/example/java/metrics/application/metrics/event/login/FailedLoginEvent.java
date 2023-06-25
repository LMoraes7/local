package com.example.java.metrics.application.metrics.event.login;

public final class FailedLoginEvent extends LoginEvent {

    public FailedLoginEvent(final String username) {
        super(username);
    }

}
