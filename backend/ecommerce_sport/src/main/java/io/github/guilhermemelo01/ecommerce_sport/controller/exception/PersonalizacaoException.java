package io.github.guilhermemelo01.ecommerce_sport.controller.exception;

import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.PagamentoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PersonalizacaoException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroPadrao> metodoViolacaoItregidadeDadosException(
            DataIntegrityViolationException vide, HttpServletRequest request) {

        ErroValidacao erro = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value()
                , "Violação na integridade de dados",
                "Erro de integridade dos dados passados na requisição",
                "Verifique se todos os dados passados seguem as regras de integridade",
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErroPadrao> metodoEmptyResultDataAccessException(
            EmptyResultDataAccessException erdae, HttpServletRequest request) {

        ErroValidacao erro = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value()
                , "O dado solicitado está vazio",
                erdae.getMessage(),
                "Verifique se todos os dados solicitados existem",
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> metodoMethodArgumentNotValidException(
            MethodArgumentNotValidException manve, HttpServletRequest request) {

        ErroValidacao erro = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value()
                , "Argumento inválido", manve.getMessage(),
                "Verifique se todos os dados estão corretos", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

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

    @ExceptionHandler(PagamentoException.class)
    public ResponseEntity<ErroPadrao> metodoPagamentoException(PagamentoException pgme,
                                                                     HttpServletRequest request) {

        ErroValidacao error = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Procedimento de pagamento não concluido", pgme.getMessage(),
                "Verifique se não tem alguma pendencia no seu pagamento!", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}