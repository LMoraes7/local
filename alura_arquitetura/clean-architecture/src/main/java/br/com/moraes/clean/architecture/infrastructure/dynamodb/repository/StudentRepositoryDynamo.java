package br.com.moraes.clean.architecture.infrastructure.dynamodb.repository;

import br.com.moraes.clean.architecture.domain.student.Student;
import br.com.moraes.clean.architecture.domain.student.repository.StudentRepository;
import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.converter.EntityConverter;
import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.StudentEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryDynamo implements StudentRepository {

    private final DynamoDBMapper dynamoDBMapper;
    private final EntityConverter<Student, StudentEntity> entityConverter;


    public StudentRepositoryDynamo(
            final DynamoDBMapper dynamoDBMapper,
            @Qualifier("dynamoDBStudentConverter")
            final EntityConverter<Student, StudentEntity> entityConverter
    ) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.entityConverter = entityConverter;
    }

    @Override
    public void save(final Student student) {
        final var entity = entityConverter.toEntity(student);
        dynamoDBMapper.save(entity);
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public Student findByDocument(final String document) {
        return null;
    }

    @Override
    public Integer countByDocumentOrEmail(final String document, final String email) {
        return null;
    }

    @Override
    public void update(final Student student) {}
}
