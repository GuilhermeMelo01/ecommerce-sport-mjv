package io.github.guilhermemelo01.ecommerce_sport.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class NovoClienteDto {

    @NotBlank(message = "Campo nome não pode ser vazio")
    @Length(min = 5, max = 20, message = "O nome deve ter entre 5 e 20 caracteres")
    private String nome;

    @NotBlank(message = "Campo senha não pode ser vazio")
    @Length(min = 5, max = 20, message = "A senha deve ter entre 5 e 20 caracteres")
    private String senha;

    @NotBlank(message = "Este campo não pode ser vazio")
    @Length(min = 11, max = 11, message = "O cpf deve ter 11 caracteres")
    private String cpf;

    @NotBlank(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;

    @NotBlank(message = "Campo logradouro não pode ser vazio")
    @Length(min = 10, max = 30, message = "Logradouro deve ter entre 10 e 30 caracteres")
    private String logradouro;

    @NotBlank(message = "Campo cidade não pode ser vazio")
    private String cidade;

    @NotBlank(message = "Campo bairro não pode ser vazio")
    private String bairro;

    @NotBlank(message = "Campo numero não pode ser vazio")
    private String numero;

    private String complemento;

    public NovoClienteDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
