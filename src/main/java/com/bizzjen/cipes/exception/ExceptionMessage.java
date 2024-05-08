package com.bizzjen.cipes.exception;

public enum ExceptionMessage {
    NOT_FOUND("Request type does not exist"),
    DUPLICATE_FOUND("Already exist");

    private final String description;

    ExceptionMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
