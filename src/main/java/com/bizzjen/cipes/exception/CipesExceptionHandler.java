package com.bizzjen.cipes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CipesExceptionHandler {

    @ExceptionHandler(value = {CipesClassNotFoundException.class})
    public ResponseEntity<Object> handleClassNotFoundException
            (CipesClassNotFoundException classNotFoundException) {
        CipesException cipesException = new CipesException(
                classNotFoundException.getMessage(),
                classNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cipesException, HttpStatus.NOT_FOUND);
    }
}
