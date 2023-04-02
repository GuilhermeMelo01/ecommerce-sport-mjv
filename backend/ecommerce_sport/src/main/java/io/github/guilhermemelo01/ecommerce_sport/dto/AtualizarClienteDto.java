package io.github.guilhermemelo01.ecommerce_sport.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class AtualizarClienteDto {

    @NotBlank(message = "Campo nome não pode ser vazio")
    @Length(min = 5, max = 20, message = "O nome deve ter entre 5 e 20 caracteres")
    private String nome;

    @NotBlank(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;
}
