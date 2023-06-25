package br.com.moraes.clean.architecture.domain.student;

import br.com.moraes.clean.architecture.domain.exception.BusinessException;
import br.com.moraes.clean.architecture.domain.student.repository.StudentRepository;
import br.com.moraes.clean.architecture.domain.vo.Document;
import br.com.moraes.clean.architecture.domain.vo.Telephone;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import static br.com.moraes.clean.architecture.domain.error.ErrorInformation.STUD_0001;

public final class Student {

    private final String id;
    private final String name;
    private final Document document;
    private final String email;
    private final Collection<Telephone> phones;

    public Student(
            final String id,
            final String name,
            final Document document,
            final String email
    ) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.phones = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Document getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Telephone> getPhones() {
        return Collections.unmodifiableCollection(phones);
    }

    public void addPhone(final Telephone telephone) {
        this.phones.add(telephone);
    }

    public void addAllPhones(final Collection<Telephone> telephones) {
        this.phones.addAll(telephones);
    }

    public void removePhone(final Telephone telephone) {
        this.phones.remove(telephone);
    }

    public void removeAllPhone(final Collection<Telephone> telephones) {
        this.phones.removeAll(telephones);
    }

    public void enroll(final StudentRepository repository) {
        final var count = repository.countByDocumentOrEmail(this.document.value(), this.email);
        if (count != 0)
            throw new BusinessException(STUD_0001, STUD_0001.reason);

        repository.save(this);
    }

    public void update(final StudentRepository repository) {
        repository.update(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", document=" + document +
                ", email=" + email +
                ", phones=" + phones +
                '}';
    }
}
