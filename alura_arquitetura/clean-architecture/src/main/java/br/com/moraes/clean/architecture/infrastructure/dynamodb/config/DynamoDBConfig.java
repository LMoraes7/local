package br.com.moraes.clean.architecture.infrastructure.dynamodb.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DynamoDBConfig {

    @Bean
    public AmazonDynamoDB dynamoDBClientConfig(final Environment environment) {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(getEndpointConfiguration(environment))
                .withCredentials(getCredentialsProvider(environment))
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(Environment environment) {
        return new AwsClientBuilder.EndpointConfiguration(
                environment.getRequiredProperty("amazon.dynamodb.endpoint", String.class),
                environment.getRequiredProperty("amazon.aws.region", String.class)
        );
    }

    private AWSCredentialsProvider getCredentialsProvider(final Environment environment) {
        return new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(
                    environment.getRequiredProperty("amazon.aws.accesskey", String.class),
                    environment.getRequiredProperty("amazon.aws.secretkey", String.class)
                )
        );
    }

}
