package com.example.jvspace.services.exceptions;

public class ResourceNotAcceptableException extends RuntimeException{

    public ResourceNotAcceptableException(Object id){
        super("Not Acceptable");
    }
}
