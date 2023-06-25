package com.example.java.metrics.application.metrics.event.user;

public final class FailedToCreateUserEvent extends CreateUserEvent {

    private final String code;

    public FailedToCreateUserEvent(final String username, final String code) {
        super(username);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
