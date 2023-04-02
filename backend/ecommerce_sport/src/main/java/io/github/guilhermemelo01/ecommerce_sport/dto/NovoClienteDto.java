package io.github.guilhermemelo01.ecommerce_sport.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
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

}
