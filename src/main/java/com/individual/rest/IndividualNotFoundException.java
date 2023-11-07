package com.individual.rest;

public class IndividualNotFoundException extends RuntimeException{
    public IndividualNotFoundException(String message) {
        super(message);
    }

    public IndividualNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndividualNotFoundException(Throwable cause) {
        super(cause);
    }
}
