package com.bizzjen.cipes.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDetail {
    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;

    // timestamp, message, details
}
