package br.com.moraes.clean.architecture.infrastructure.postgres.repository.constants;

public enum CommonConstants {
    PHONE_REGEX("-");

    public final String regex;

    CommonConstants(final String regex) {
        this.regex = regex;
    }
}
