package com.example.java.metrics.domain.exception;

public final class BusinessException extends RuntimeException {
    private final String code;
    private final String message;

    public BusinessException(final String code, final String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
