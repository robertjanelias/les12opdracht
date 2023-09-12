package com.example.les11model.exception;

import org.springframework.http.ResponseEntity;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
