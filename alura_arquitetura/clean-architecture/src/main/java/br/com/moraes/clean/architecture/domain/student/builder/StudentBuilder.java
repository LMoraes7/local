package br.com.moraes.clean.architecture.domain.student.builder;

import br.com.moraes.clean.architecture.domain.student.Student;
import br.com.moraes.clean.architecture.domain.vo.Document;

public final class StudentBuilder {

    private String id;
    private String name;
    private Document document;
    private String email;

    public StudentBuilder id(final String id) {
        this.id = id;
        return this;
    }

    public StudentBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder document(final Document document) {
        this.document = document;
        return this;
    }

    public StudentBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public Student build() {
        return new Student(id, name, document, email);
    }
}
