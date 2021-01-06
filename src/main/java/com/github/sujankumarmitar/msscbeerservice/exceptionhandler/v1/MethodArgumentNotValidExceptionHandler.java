package com.github.sujankumarmitar.msscbeerservice.exceptionhandler.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toUnmodifiableList;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidRequestBodyResponse> handleException(MethodArgumentNotValidException exception) {
        List<RequestBodyError> errors = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::buildViolation)
                .collect(toUnmodifiableList());

        return ResponseEntity
                .badRequest()
                .body(new InvalidRequestBodyResponse(errors));
    }

    private RequestBodyError buildViolation(FieldError error) {
        String message = error.getDefaultMessage();
        String propertyPath = error.getField();
        String invalidValue = valueOf(error.getRejectedValue());

        return new RequestBodyError(message, propertyPath, invalidValue);
    }
}
