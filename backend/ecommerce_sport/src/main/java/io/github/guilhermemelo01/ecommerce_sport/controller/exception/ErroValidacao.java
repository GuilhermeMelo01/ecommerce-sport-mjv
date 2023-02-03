package io.github.guilhermemelo01.ecommerce_sport.controller.exception;

public class ErroValidacao extends ErroPadrao {

    public ErroValidacao(Long timeStamp, Integer status, String error, String message, String sugestao, String path) {
        super(timeStamp, status, error, message, sugestao, path);
    }
}