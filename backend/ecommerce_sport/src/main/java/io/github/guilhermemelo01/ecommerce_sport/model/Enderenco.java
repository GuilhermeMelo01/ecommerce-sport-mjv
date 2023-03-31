package io.github.guilhermemelo01.ecommerce_sport.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class Enderenco {

    @Column(name = "end_logradouro", length = 50, nullable = false)
    private String logradouro;
    @Column(name = "end_cidade", length = 30, nullable = false)
    private String cidade;
    @Column(name = "end_bairro", length = 30, nullable = false)
    private String bairro;
    @Column(name = "end_numero", length = 10, nullable = false)
    private String numero;
    @Column(name = "end_complemento", length = 50)
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
