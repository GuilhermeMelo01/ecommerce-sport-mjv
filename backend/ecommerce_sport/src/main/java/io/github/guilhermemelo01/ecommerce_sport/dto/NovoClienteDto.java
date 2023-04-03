package io.github.guilhermemelo01.ecommerce_sport.dto;

import io.github.guilhermemelo01.ecommerce_sport.model.Endereco;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class NovoClienteDto {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    private Endereco endereco;

}
