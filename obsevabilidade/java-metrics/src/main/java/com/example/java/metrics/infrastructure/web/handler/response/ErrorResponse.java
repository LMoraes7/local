package com.example.java.metrics.infrastructure.web.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ErrorResponse {
    @JsonProperty("status")
    private final int status;
    @JsonProperty("code")
    private final String code;
    @JsonProperty("message")
    private final String message;
    @JsonProperty("additional_informations")
    private final Collection<AdditionalInformation> additionalInformations;

    public ErrorResponse(
            final int status,
            final String code,
            final String message,
            final List<AdditionalInformation> additionalInformations
    ) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.additionalInformations = additionalInformations;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Collection<AdditionalInformation> getAdditionalInformations() {
        return additionalInformations;
    }
}
