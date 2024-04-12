package com.eazybytes.exception.handler;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(EmailAlreadyUsed.class)
//    public ResponseEntity<Map<String, Object>> handleEmailAlreadyUsed(EmailAlreadyUsed emailAlreadyUsed) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", Instant.now().toString());
//        response.put("status", HttpStatus.BAD_REQUEST.value());
//        response.put("message", emailAlreadyUsed.getMessage());
//        response.put("errorCode", "EMAIL_ALREADY_USED");
//        response.put("action", "Please use a different email address or contact support.");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationError(MethodArgumentNotValidException exception) {
        Map<String, String> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (existing, replacement) -> existing));

        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidFormatException(InvalidFormatException ex) {
        String fieldName = ex.getPath().stream()
                .reduce((first, second) -> second)
                .map(JsonMappingException.Reference::getFieldName)
                .orElse("unknown field");

        String expectedValues = Arrays.stream(ex.getTargetType().getEnumConstants())
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("error", "Invalid value for field");
        body.put("field", fieldName);
        body.put("expected", expectedValues);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(MailSendException.class)
//    public ResponseEntity<Map<String, Object>> handleMailSendException(MailSendException ex) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", Instant.now().toString());
//        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        response.put("message", ex.getMessage());
//        response.put("action", "Please try again later or contact support.");
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(ConfirmationEmailSentException.class)
//    public ResponseEntity<Map<String, Object>> handleConfirmationEmailSentException(ConfirmationEmailSentException ex) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", Instant.now().toString());
//        response.put("status", HttpStatus.OK.value());
//        response.put("message", ex.getMessage());
//        response.put("action", "Check your email inbox (and spam folder) for the confirmation link.");
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}
