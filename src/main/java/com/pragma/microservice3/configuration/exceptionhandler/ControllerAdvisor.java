package com.pragma.microservice3.configuration.exceptionhandler;

import com.pragma.microservice3.adapters.driven.service.exception.SmsNotSendException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(BindException bindException) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError error : bindException.getFieldErrors()) {
            errorMessage.append(error.getDefaultMessage()).append("; ");
        }
        errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                errorMessage.toString(),
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(SmsNotSendException.class)
    public ResponseEntity<ExceptionResponse> handleSmsNotSendException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                "Sms not send",
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }
}
