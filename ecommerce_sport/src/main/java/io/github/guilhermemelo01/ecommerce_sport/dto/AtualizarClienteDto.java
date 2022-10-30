package io.github.guilhermemelo01.ecommerce_sport.dto;

public class AtualizarClienteDto {

    private String nome;
    private String telefone;
    private String email;

    public AtualizarClienteDto() {
    }

    public AtualizarClienteDto(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
