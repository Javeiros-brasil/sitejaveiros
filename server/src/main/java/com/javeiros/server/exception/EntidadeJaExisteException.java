package com.javeiros.server.exception;

public class EntidadeJaExisteException extends RuntimeException{
    public EntidadeJaExisteException(String message) {
        super(message);
    }
}
