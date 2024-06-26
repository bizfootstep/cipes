package com.bizzjen.cipes.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDetail {
    private String message;
    private HttpStatus httpStatus;
    private Object data;
}
