package com.example.java.metrics.domain.exception;

public final class LoginException extends RuntimeException {
    private final String message;

    public LoginException(final String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
