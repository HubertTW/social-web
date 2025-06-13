package com.example.social_web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class MyServiceExceptionHandler {

    @ExceptionHandler(MyServiceException.class)
    public ResponseEntity<?> handleMyServiceError(MyServiceException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "scope", "MyServiceOnly",
                        "error", "MyServiceException",
                        "message", e.getMessage()
                ));
    }
}
