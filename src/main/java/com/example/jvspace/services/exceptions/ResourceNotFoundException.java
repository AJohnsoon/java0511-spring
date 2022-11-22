package com.example.jvspace.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final Long seriaVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. ID: " + id);
    }


}
