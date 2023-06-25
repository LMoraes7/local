package com.example.java.metrics.infrastructure.database.postgres.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class PostgresConfig {

    @Bean
    @Profile("!local")
    public DataSource postgresDatabaseConfig(final PostgresProperties postgresProperties) {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(buildUrlConnection(postgresProperties))
                .username(postgresProperties.getUsername())
                .password(postgresProperties.getPassword())
                .build();
    }

    private String buildUrlConnection(final PostgresProperties postgresProperties) {
        return "jdbc:postgresql://" +
                postgresProperties.getHost() +
                ":" +
                postgresProperties.getPort() +
                "/" +
                postgresProperties.getSchema();
    }

}
