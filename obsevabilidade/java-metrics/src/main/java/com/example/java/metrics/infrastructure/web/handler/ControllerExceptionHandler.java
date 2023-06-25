package com.example.java.metrics.infrastructure.web.handler;

import com.example.java.metrics.domain.exception.BusinessException;
import com.example.java.metrics.domain.exception.LoginException;
import com.example.java.metrics.infrastructure.web.handler.response.AdditionalInformation;
import com.example.java.metrics.infrastructure.web.handler.response.ErrorResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public final class ControllerExceptionHandler {

    private final MessageSource messageSource;

    public ControllerExceptionHandler(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException ex) {
        final var additionalInformations = new ArrayList<AdditionalInformation>();
        ex.getBindingResult().getFieldErrors().forEach(it -> {
            final var message = this.messageSource.getMessage(it, LocaleContextHolder.getLocale());
            additionalInformations.add(new AdditionalInformation(it.getField(), message));
        });

        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        BAD_REQUEST.value(),
                        null,
                        "request payload error, please review the contract",
                        additionalInformations
                )
        );
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorResponse> loginExceptionHandler(final LoginException ex) {
        final var responseStatus = UNAUTHORIZED;
        return ResponseEntity.status(responseStatus)
                .body(new ErrorResponse(responseStatus.value(), null, ex.getMessage(), null));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessExceptionHandler(final BusinessException ex) {
        final var responseStatus = UNPROCESSABLE_ENTITY;
        return ResponseEntity.status(responseStatus)
                .body(new ErrorResponse(responseStatus.value(), ex.getCode(), ex.getMessage(), null));
    }

}
