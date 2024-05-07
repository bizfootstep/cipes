package com.bizzjen.cipes.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<ResponseDetail> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {
//        HashMap<String, Object> response = new HashMap<>();
//        response.put("message", message);
//        response.put("httpStatus", httpStatus);
//        response.put("data", responseObject);
        ResponseDetail response = new ResponseDetail(message, httpStatus, responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }
}
