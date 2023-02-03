package io.github.guilhermemelo01.ecommerce_sport.service.exception;

public class PagamentoException extends RuntimeException {

    public PagamentoException() {
    }

    public PagamentoException(String message) {
        super(message);
    }

    public PagamentoException(String message, Throwable cause) {
        super(message, cause);
    }
}