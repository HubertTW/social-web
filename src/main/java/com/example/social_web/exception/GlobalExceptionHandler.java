package com.example.social_web.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        //json response
        Map<String, Object> response = new HashMap<>();
        response.put("status", 500);
        response.put("error",  e.getClass().getSimpleName());
        response.put("meta", Map.of(
                "env", "production",
                "traceId", UUID.randomUUID().toString()
        ));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}

