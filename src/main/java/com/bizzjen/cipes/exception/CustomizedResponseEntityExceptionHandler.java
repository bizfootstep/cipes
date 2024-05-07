package com.bizzjen.cipes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CipesClassNotFoundException.class})
    public ResponseEntity<Object> handleClassNotFoundException
            (CipesClassNotFoundException classNotFoundException) {
        ErrorDetail errorDetail = new ErrorDetail(
                classNotFoundException.getMessage(),
                classNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(
//            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                ex.getMessage(),
//                null,
//                HttpStatus.BAD_REQUEST
//        );
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }


}
