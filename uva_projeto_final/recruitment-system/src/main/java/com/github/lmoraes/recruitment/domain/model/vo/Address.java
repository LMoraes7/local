package com.github.lmoraes.recruitment.domain.model.vo;

public final class Address {
    private final String street;
    private final int number;
    private final String complement;
    private final String uf;
    private final String cep;

    public Address(
            final String street,
            final int number,
            final String complement,
            final String uf,
            final String cep
    ) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.uf = uf;
        this.cep = cep;
    }

}
