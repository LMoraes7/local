package com.example.java.metrics.infrastructure.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class LoginResponse {
    @JsonProperty("type")
    private final String type;
    @JsonProperty("access_token")
    private final String accessToken;
    @JsonProperty("creation_date")
    private final long creationDate;
    @JsonProperty("expiration_date")
    private final long expirationDate;

    @JsonProperty("expiration_in")
    private final long expirationIn;

    public LoginResponse(
            final String type,
            final String accessToken,
            final long creationDate,
            final long expirationDate,
            final long expirationIn
    ) {
        this.type = type;
        this.accessToken = accessToken;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.expirationIn = expirationIn;
    }

    public String getType() {
        return type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public long getExpirationIn() {
        return expirationIn;
    }

}
