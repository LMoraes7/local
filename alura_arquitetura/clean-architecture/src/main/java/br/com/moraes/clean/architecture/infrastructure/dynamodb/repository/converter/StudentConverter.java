package br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.converter;

import br.com.moraes.clean.architecture.domain.student.Student;
import br.com.moraes.clean.architecture.domain.student.builder.StudentBuilder;
import br.com.moraes.clean.architecture.domain.vo.Document;
import br.com.moraes.clean.architecture.domain.vo.Telephone;
import br.com.moraes.clean.architecture.domain.vo.Type;
import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.StudentEntity;
import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.vo.DocumentEntity;
import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.vo.TelephoneEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("dynamoDBStudentConverter")
public final class StudentConverter implements EntityConverter<Student, StudentEntity> {

    @Override
    public StudentEntity toEntity(final Student domain) {
        final var studentEntity = new StudentEntity();

        studentEntity.setId(domain.getId());
        studentEntity.setName(domain.getName());
        studentEntity.setDocument(buildDocumentEntity(domain.getDocument()));
        studentEntity.setEmail(domain.getEmail());
        studentEntity.setPhones(buildTelephoneEntity(domain.getPhones()));

        return studentEntity;
    }

    private DocumentEntity buildDocumentEntity(final Document document) {
        final var documentEntity = new DocumentEntity();

        documentEntity.setType(document.type().name());
        documentEntity.setValue(documentEntity.getValue());

        return documentEntity;
    }

    private Collection<TelephoneEntity> buildTelephoneEntity(final Collection<Telephone> phones) {
        return phones.stream().map(it -> {
            final var telephoneEntity = new TelephoneEntity();

            telephoneEntity.setDdd(it.ddd());
            telephoneEntity.setNumber(it.number());

            return telephoneEntity;
        }).toList();
    }

    @Override
    public Student toDomain(final StudentEntity entity) {
        final var student = new StudentBuilder()
                .id(entity.getId())
                .name(entity.getName())
                .document(buildDocument(entity.getDocument()))
                .email(entity.getEmail())
                .build();
        student.addAllPhones(buildTelephone(entity.getPhones()));

        return student;
    }

    private Collection<Telephone> buildTelephone(final Collection<TelephoneEntity> phonesEntity) {
        return phonesEntity.stream().map(it -> new Telephone(it.getDdd(), it.getNumber())).toList();
    }

    private Document buildDocument(final DocumentEntity documentEntity) {
        return new Document(Type.valueOf(documentEntity.getType()), documentEntity.getValue());
    }
}
