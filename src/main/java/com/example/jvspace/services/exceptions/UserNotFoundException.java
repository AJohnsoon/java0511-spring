package com.example.jvspace.services.exceptions;

public class UserNotFoundException extends RuntimeException{
    private static final Long seriaVersionUID = 1L;

    public UserNotFoundException(Object id){
        super("Resource not found. ID: " + id);
    }
}
