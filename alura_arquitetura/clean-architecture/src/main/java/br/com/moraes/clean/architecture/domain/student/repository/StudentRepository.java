package br.com.moraes.clean.architecture.domain.student.repository;

import br.com.moraes.clean.architecture.domain.student.Student;

public interface StudentRepository {

    void save(final Student student);

    Student findById(final String id);

    Student findByDocument(final String document);

    Integer countByDocumentOrEmail(final String document, final String email);

    void update(final Student student);
}
