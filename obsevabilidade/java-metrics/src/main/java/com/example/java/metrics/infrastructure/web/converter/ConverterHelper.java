package com.example.java.metrics.infrastructure.web.converter;

import com.example.java.metrics.domain.model.User;
import com.example.java.metrics.domain.vo.CredentialAccess;
import com.example.java.metrics.infrastructure.web.response.CreateUserResponse;
import com.example.java.metrics.infrastructure.web.response.LoginResponse;

public final class ConverterHelper {

    public static LoginResponse credentialAccessToResponse(final CredentialAccess credentialAccess) {
        return new LoginResponse(
                credentialAccess.getType(),
                credentialAccess.getHash(),
                credentialAccess.getCreationDate(),
                credentialAccess.getExpirationDate(),
                credentialAccess.getExpiresIn()
        );
    }

    public static CreateUserResponse domainToResponse(final User user) {
        return new CreateUserResponse(user.getId());
    }

}
