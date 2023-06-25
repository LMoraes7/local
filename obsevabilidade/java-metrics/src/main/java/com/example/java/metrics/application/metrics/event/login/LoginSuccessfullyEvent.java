package com.example.java.metrics.application.metrics.event.login;

public final class LoginSuccessfullyEvent extends LoginEvent {

    public LoginSuccessfullyEvent(final String username) {
        super(username);
    }

}
