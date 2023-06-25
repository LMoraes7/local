package com.example.java.metrics.infrastructure.web.controller;

import com.example.java.metrics.domain.usecase.LoginUseCase;
import com.example.java.metrics.infrastructure.aspect.Timer;
import com.example.java.metrics.infrastructure.web.converter.ConverterHelper;
import com.example.java.metrics.infrastructure.web.request.LoginRequest;
import com.example.java.metrics.infrastructure.web.response.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Validated
public class LoginController {

    private final LoginUseCase loginUseCase;

    public LoginController(final LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Timer(metric = "http.request.post.login.duration", action = "http_request_login")
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest request) {
        final var token = this.loginUseCase.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(ConverterHelper.credentialAccessToResponse(token));
    }

}
