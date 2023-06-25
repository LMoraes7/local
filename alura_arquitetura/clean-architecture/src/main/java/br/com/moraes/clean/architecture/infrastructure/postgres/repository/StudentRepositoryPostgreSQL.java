package br.com.moraes.clean.architecture.infrastructure.postgres.repository;

import br.com.moraes.clean.architecture.domain.exception.BusinessException;
import br.com.moraes.clean.architecture.domain.exception.NotFoundException;
import br.com.moraes.clean.architecture.domain.student.Student;
import br.com.moraes.clean.architecture.domain.student.repository.StudentRepository;
import br.com.moraes.clean.architecture.infrastructure.postgres.repository.rowmapper.StudentRowMapper;
import br.com.moraes.clean.architecture.infrastructure.postgres.repository.utils.ArraySqlValue;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static br.com.moraes.clean.architecture.domain.error.ErrorInformation.STUD_0001;
import static br.com.moraes.clean.architecture.infrastructure.postgres.repository.constants.CommonConstants.PHONE_REGEX;
import static br.com.moraes.clean.architecture.infrastructure.postgres.repository.queries.StudentSqlCommands.*;

@Repository
public class StudentRepositoryPostgreSQL implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final StudentRowMapper studentRowMapper;

    public StudentRepositoryPostgreSQL(final JdbcTemplate jdbcTemplate, final StudentRowMapper studentRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentRowMapper = studentRowMapper;
    }

    @Override
    public void save(final Student student) {
        try {
            this.jdbcTemplate.update(
                    SAVE.sql,
                    student.getId(),
                    student.getName(),
                    student.getDocument().type().value,
                    student.getDocument().value(),
                    student.getEmail(),
                    ArraySqlValue.create(student.getPhones().stream().map(it -> it.ddd().concat(PHONE_REGEX.regex + it.number())).toArray())
            );
        } catch (DataIntegrityViolationException ex) {
            throw new BusinessException(STUD_0001, STUD_0001.reason);
        }
    }

    @Override
    public Student findById(final String id) {
        try {
            return this.jdbcTemplate.queryForObject(FIND_BY_ID.sql, this.studentRowMapper, id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException(Student.class, id);
        }
    }

    @Override
    public Student findByDocument(final String document) {
        try {
            return this.jdbcTemplate.queryForObject(FIND_BY_DOCUMENT.sql, this.studentRowMapper, document);
        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException(Student.class, document);
        }
    }

    @Override
    public Integer countByDocumentOrEmail(final String document, final String email) {
        return this.jdbcTemplate.queryForObject(FIND_BY_DOCUMENT_OR_EMAIL.sql, Integer.class, document, email);
    }

    @Override
    public void update(final Student student) {
        int update = this.jdbcTemplate.update(
                UPDATE_BY_ID.sql,
                student.getEmail(),
                ArraySqlValue.create(student.getPhones().stream().map(it -> it.ddd().concat(it.number())).toArray()),
                student.getId()
        );

        if (update == 0)
            throw new NotFoundException(Student.class, student.getId());
    }
}
