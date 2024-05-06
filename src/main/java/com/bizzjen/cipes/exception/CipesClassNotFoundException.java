package com.bizzjen.cipes.exception;

public class CipesClassNotFoundException extends RuntimeException{
    public CipesClassNotFoundException(String message) {
        super(message);
    }

    public CipesClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
