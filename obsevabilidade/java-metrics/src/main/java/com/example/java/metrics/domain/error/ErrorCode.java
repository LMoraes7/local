package com.example.java.metrics.domain.error;

public enum ErrorCode {

    AUSR_0001("the username entered cannot be used");

    public final String value;

    ErrorCode(final String value) {
        this.value = value;
    }

}
