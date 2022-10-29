package io.github.guilhermemelo01.ecommerce_sport.controller.exception;

public class ValidationError extends StandardError {

    public ValidationError(Long timeStamp, Integer status, String error, String message, String sugestao, String path) {
        super(timeStamp, status, error, message, sugestao, path);
    }
}