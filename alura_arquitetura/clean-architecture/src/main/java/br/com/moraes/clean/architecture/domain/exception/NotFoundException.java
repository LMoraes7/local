package br.com.moraes.clean.architecture.domain.exception;

public final class NotFoundException extends RuntimeException {

    private final Class<?> classType;
    private final Object identifierValue;

    public NotFoundException(final Class<?> classType, final Object identifierValue) {
        super();
        this.classType = classType;
        this.identifierValue = identifierValue;
    }

    public Class<?> getClassType() {
        return classType;
    }

    public Object getIdentifierValue() {
        return identifierValue;
    }
}
