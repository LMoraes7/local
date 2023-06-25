package com.example.java.metrics.infrastructure.database.postgres.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database.postgres")
public class PostgresProperties {
    @NotBlank
    private final String host;
    @NotNull @Positive
    private final Integer port;
    @NotBlank
    private final String schema;
    @NotNull
    private final String username;
    @NotNull
    private final String password;

    @Valid
    public PostgresProperties(
            final String host,
            final Integer port,
            final String schema,
            final String username,
            final String password
    ) {
        this.host = host;
        this.port = port;
        this.schema = schema;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getSchema() {
        return schema;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
