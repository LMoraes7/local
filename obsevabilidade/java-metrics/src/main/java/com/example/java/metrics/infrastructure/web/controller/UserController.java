package com.example.java.metrics.infrastructure.web.controller;

import com.example.java.metrics.domain.usecase.CreateUserUseCase;
import com.example.java.metrics.infrastructure.aspect.Timer;
import com.example.java.metrics.infrastructure.web.request.CreateUserRequest;
import com.example.java.metrics.infrastructure.web.response.CreateUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.java.metrics.infrastructure.web.converter.ConverterHelper.domainToResponse;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(final CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Timer(metric = "http.request.post.user.duration", action = "http_request_create_user")
    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid final CreateUserRequest request) {
        final var user = this.createUserUseCase.createUser(request.getUsername(), request.getPassword());
        return ResponseEntity.status(CREATED).body(domainToResponse(user));
    }

}
