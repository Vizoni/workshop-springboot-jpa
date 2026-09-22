package com.raphaelvizoni.spring_first_project.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id: " + id);
    }
}
