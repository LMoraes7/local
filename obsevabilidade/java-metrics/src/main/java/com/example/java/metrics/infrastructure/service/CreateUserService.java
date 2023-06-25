package com.example.java.metrics.infrastructure.service;

import com.example.java.metrics.application.crypter.UserPasswordEncryptor;
import com.example.java.metrics.application.generator.UserIdentifierGenerator;
import com.example.java.metrics.application.metrics.event.user.FailedToCreateUserEvent;
import com.example.java.metrics.application.metrics.event.user.UserCreatedSuccessfullyEvent;
import com.example.java.metrics.domain.exception.BusinessException;
import com.example.java.metrics.domain.model.User;
import com.example.java.metrics.domain.repository.UserRepository;
import com.example.java.metrics.domain.usecase.CreateUserUseCase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import static com.example.java.metrics.domain.error.ErrorCode.AUSR_0001;

@Service
public final class CreateUserService implements CreateUserUseCase {

    private final UserRepository repository;
    private final UserIdentifierGenerator identifierGenerator;
    private final UserPasswordEncryptor encryptor;
    private final ApplicationEventPublisher publisher;

    public CreateUserService(
            final UserRepository repository,
            final UserIdentifierGenerator identifierGenerator,
            final UserPasswordEncryptor encryptor,
            final ApplicationEventPublisher publisher
    ) {
        this.repository = repository;
        this.identifierGenerator = identifierGenerator;
        this.encryptor = encryptor;
        this.publisher = publisher;
    }

    @Override
    public User createUser(final String username, final String password) {
        if (this.repository.existsByUsername(username)) {
            this.publisher.publishEvent(new FailedToCreateUserEvent(username, AUSR_0001.name()));
            throw new BusinessException(AUSR_0001.name(), AUSR_0001.value);
        }

        final var identifier = this.identifierGenerator.generateIdentifierForUser();
        final var user = new User(identifier, username, this.encryptor.encryptUserPassword(password), null);
        this.repository.save(user);

        this.publisher.publishEvent(new UserCreatedSuccessfullyEvent(username));
        return user;
    }

}
