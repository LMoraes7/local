package br.com.moraes.clean.architecture.domain.vo;

public enum Type {
    CNPJ("J"),
    CPF("F");

    public final String value;

    Type(final String value) {
        this.value = value;
    }
}
