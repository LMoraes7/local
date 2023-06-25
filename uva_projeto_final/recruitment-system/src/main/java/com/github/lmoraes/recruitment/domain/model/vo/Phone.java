package com.github.lmoraes.recruitment.domain.model.vo;

import java.util.Objects;

public final class Phone {
    private final String ddd;
    private final String value;

    public Phone(final String ddd, final String value) {
        this.ddd = ddd;
        this.value = value;
    }

    public String getDdd() {
        return ddd;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(ddd, phone.ddd) && Objects.equals(value, phone.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, value);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ddd='" + ddd + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
