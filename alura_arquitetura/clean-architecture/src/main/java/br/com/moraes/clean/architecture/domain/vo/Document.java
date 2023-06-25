package br.com.moraes.clean.architecture.domain.vo;

import java.util.Objects;

public record Document(Type type, String value) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return type == document.type && Objects.equals(value, document.value);
    }

    @Override
    public String toString() {
        return "Document{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
