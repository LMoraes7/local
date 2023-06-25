package com.example.java.metrics.infrastructure.service;

import com.example.java.metrics.application.credential.CredentialAccessService;
import com.example.java.metrics.application.metrics.event.login.FailedLoginEvent;
import com.example.java.metrics.application.metrics.event.login.LoginSuccessfullyEvent;
import com.example.java.metrics.domain.exception.LoginException;
import com.example.java.metrics.domain.usecase.LoginUseCase;
import com.example.java.metrics.domain.vo.CredentialAccess;
import com.example.java.metrics.infrastructure.security.vo.CustomUserDetails;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import static com.example.java.metrics.infrastructure.security.filter.converter.ConverterHelper.userDetailsToDomain;

@Service
public final class LoginService implements LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final CredentialAccessService credentialAccessService;
    private final ApplicationEventPublisher publisher;

    public LoginService(
            final AuthenticationManager authenticationManager,
            final CredentialAccessService credentialService,
            final ApplicationEventPublisher publisher
    ) {
        this.authenticationManager = authenticationManager;
        this.credentialAccessService = credentialService;
        this.publisher = publisher;
    }

    @Override
    public CredentialAccess login(final String username, final String password) {
        CustomUserDetails userDetails;
        try {
            final var authenticate = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            userDetails = (CustomUserDetails) authenticate.getPrincipal();
        } catch (final AuthenticationException ex) {
            this.publisher.publishEvent(new FailedLoginEvent(username));
            throw new LoginException("credentials are invalid");
        }

        final var credentialAccess = this.credentialAccessService.generateCredentialAccess(
                userDetailsToDomain(userDetails.getId(), userDetails)
        );
        this.publisher.publishEvent(new LoginSuccessfullyEvent(username));
        return credentialAccess;
    }

}
