package com.example.java.metrics.application.metrics.event.user;

public final class UserCreatedSuccessfullyEvent extends CreateUserEvent {

    public UserCreatedSuccessfullyEvent(final String username) {
        super(username);
    }

}
