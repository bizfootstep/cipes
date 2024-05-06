package com.bizzjen.cipes.exception;

public enum ExceptionMessage {
    NOT_FOUND("Request type does not exist");

    private String description;

    ExceptionMessage(String description) {
        this.description = description;
    }
}
