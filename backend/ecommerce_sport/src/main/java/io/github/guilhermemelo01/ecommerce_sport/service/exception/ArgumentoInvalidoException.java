package io.github.guilhermemelo01.ecommerce_sport.service.exception;

public class ArgumentoInvalidoException extends RuntimeException {

    public ArgumentoInvalidoException() {
    }

    public ArgumentoInvalidoException(String message) {
        super(message);
    }

    public ArgumentoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}