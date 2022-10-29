package io.github.guilhermemelo01.ecommerce_sport.controller.exception;

import java.io.Serializable;

public class ErroPadrao implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String sugestao;
    private String message;
    private String path;

    public ErroPadrao() {
    }

    public ErroPadrao(Long timeStamp, Integer status, String error, String message, String sugestao, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.sugestao = sugestao;
        this.path = path;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}