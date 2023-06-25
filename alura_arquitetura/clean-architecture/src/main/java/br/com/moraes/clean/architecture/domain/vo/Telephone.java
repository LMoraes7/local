package br.com.moraes.clean.architecture.domain.vo;

import java.util.Objects;

public record Telephone(String ddd, String number) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return Objects.equals(ddd, telephone.ddd) && Objects.equals(number, telephone.number);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "ddd='" + ddd + '\'' +
                ", value='" + number + '\'' +
                '}';
    }
}
