package com.example.Product.Inventory.API.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map;

@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CommonResponse> handleNoSuchElementException(NoSuchElementException e) {
        CommonResponse response = new CommonResponse(
                Instant.now().toString(),
                e.getClass().toString(),
                "No product found",
                null
        );

        log.error("NoSuchElementException");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        CommonResponse response = new CommonResponse(
                Instant.now().toString(),
                "VALIDATION_FAILED",
                "Invalid request data",
                errors
        );
        log.error("MethodArgumentNotValidException");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CommonResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        CommonResponse response = new CommonResponse(Instant.now().toString(),
                e.getClass().toString(),
                "Http message not readable",
                null
        );

        log.error("HttpMessageNotReadableException");

        return ResponseEntity.badRequest().body(response);
    }


}
