package com.example.java.metrics.infrastructure.web.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class LoginRequest {
    @NotBlank(message = "the username does not be blank or null")
    private final String username;
    @NotBlank(message = "the password does not be blank or null")
    private final String password;

    @JsonCreator
    @JsonIgnoreProperties(ignoreUnknown = true)
    public LoginRequest(
            @JsonProperty("username")
            final String username,
            @JsonProperty("password")
            final String password
    ) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
