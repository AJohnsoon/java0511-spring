package com.example.jvspace.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
    @Serial
    private static final Long seriaVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. ID: " + id);
    }


}
