package br.com.moraes.clean.architecture.infrastructure.postgres.repository.rowmapper;

import br.com.moraes.clean.architecture.domain.student.Student;
import br.com.moraes.clean.architecture.domain.student.builder.StudentBuilder;
import br.com.moraes.clean.architecture.domain.vo.Document;
import br.com.moraes.clean.architecture.domain.vo.Telephone;
import br.com.moraes.clean.architecture.domain.vo.Type;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static br.com.moraes.clean.architecture.infrastructure.postgres.repository.constants.CommonConstants.PHONE_REGEX;

@Component
public final class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        final var student = new StudentBuilder()
                .id(rs.getString("id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .document(new Document(Type.valueOf(rs.getString("document_type")), rs.getString("document_value")))
                .build();
        final var phones = (String[]) rs.getArray("phones").getArray();

        student.addAllPhones(
                Arrays.stream(phones).map(phone -> {
                    final var split = phone.split(PHONE_REGEX.regex);
                    return new Telephone(split[0], split[1]);
                }).toList()
        );
        return student;
    }
}
