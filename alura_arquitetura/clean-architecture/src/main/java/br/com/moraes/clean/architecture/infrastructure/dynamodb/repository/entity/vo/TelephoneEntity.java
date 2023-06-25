package br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.entity.vo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class TelephoneEntity {
    private String ddd;
    private String number;

    @DynamoDBAttribute(attributeName = "ddd")
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @DynamoDBAttribute(attributeName = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
