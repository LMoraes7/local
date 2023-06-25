package br.com.moraes.clean.architecture.domain.exception;

import br.com.moraes.clean.architecture.domain.error.ErrorInformation;

public final class BusinessException extends RuntimeException {

    private final ErrorInformation code;
    private final String reason;

    public BusinessException(final ErrorInformation code, final String reason) {
        super();
        this.code = code;
        this.reason = reason;
    }

    public ErrorInformation getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
