package br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity;

import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.vo.DocumentEntity;
import br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.vo.TelephoneEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Collection;

@DynamoDBTable(tableName = "Student")
public class StudentEntity {

    private String id;
    private String name;
    private DocumentEntity document;
    private String email;
    private Collection<TelephoneEntity> phones;

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "document")
    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }

    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "phones")
    public Collection<TelephoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(Collection<TelephoneEntity> phones) {
        this.phones = phones;
    }
}
