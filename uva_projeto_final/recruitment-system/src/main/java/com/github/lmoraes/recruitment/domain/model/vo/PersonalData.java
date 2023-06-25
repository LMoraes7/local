package com.github.lmoraes.recruitment.domain.model.vo;

import java.time.LocalDate;
import java.util.List;

public final class PersonalData {
    private final String name;
    private final String document;
    private final String email;
    private final List<Phone> phones;
    private final List<Address> address;
    private final LocalDate birthDate;

    public PersonalData(
            final String name,
            final String document,
            final String email,
            final List<Phone> phones,
            final List<Address> address,
            final LocalDate birthDate
    ) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phones = phones;
        this.address = address;
        this.birthDate = birthDate;
    }

}
