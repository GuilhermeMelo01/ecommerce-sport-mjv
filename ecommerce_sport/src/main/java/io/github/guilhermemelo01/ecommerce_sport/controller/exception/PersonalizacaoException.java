package io.github.guilhermemelo01.ecommerce_sport.controller.exception;

import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PersonalizacaoException {

    @ExceptionHandler(ArgumentoInvalidoException.class)
    public ResponseEntity<ErroPadrao> metodoArgumentoInvalidoException(ArgumentoInvalidoException aie,
                                                                       HttpServletRequest request) {

        ErroValidacao error = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Argumento inválido", aie.getMessage(),
                "Verifique se preencheu o campo 'Id', com um id existente!", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadrao> metodoHttpMessageNotReadableException(HttpMessageNotReadableException hmnre,
                                                                            HttpServletRequest request) {

        ErroValidacao error = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Esta faltando informar algum requisito", hmnre.getMessage(),
                "Verifique se preencheu todos os campos obrigatório!", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErroPadrao> metodoNullPointerException(NullPointerException npe,
                                                                 HttpServletRequest request) {

        ErroValidacao error = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Argumento inválido", npe.getMessage(),
                "Verifique se preencheu todos os campos com argumentos válidos!", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroPadrao> metodoIllegalArgumentException(IllegalArgumentException iae,
                                                                     HttpServletRequest request) {

        ErroValidacao error = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Requisito espera outro tipo de valor", iae.getMessage(),
                "Verifique se preencheu algum campo com um tipo não esperado!", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}