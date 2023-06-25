package com.github.lmoraes.recruitment.exception;

public final class NotFoundException extends RuntimeException {
    private final Class<?> classType;
    private final String value;

    public NotFoundException(final Class<?> classType, final String value) {
        this.classType = classType;
        this.value = value;
    }

    public Class<?> getClassType() {
        return classType;
    }

    public String getValue() {
        return value;
    }

}
