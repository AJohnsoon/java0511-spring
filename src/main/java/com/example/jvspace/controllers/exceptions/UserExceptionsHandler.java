package com.example.jvspace.controllers.exceptions;

import com.example.jvspace.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class UserExceptionsHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(UserNotFoundException e, HttpServletRequest request){
        String message = "Resource not found";
        HttpStatus status = HttpStatus.NO_CONTENT;
        StandardError err = new StandardError(Instant.now(), status.value(), message, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
