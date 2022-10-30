package io.github.guilhermemelo01.ecommerce_sport.service.validacao;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;

public class NovoClienteValidacao {

    public static void apenasLetras(NovoClienteDto clienteDto){
        if(clienteDto.getNome().matches("[0-9]*")){
            throw new IllegalArgumentException("O campo nome não pode conter numeros");
        }
        if(clienteDto.getLogradouro().matches("[0-9]*")){
            throw new IllegalArgumentException("O campo logradouro não pode conter numeros");
        }
        if(clienteDto.getCidade().matches("[0-9]*")){
            throw new IllegalArgumentException("A campo cidade não pode conter numeros");
        }
        if(clienteDto.getBairro().matches("[0-9]*")){
            throw new IllegalArgumentException("O campo bairro não pode conter numeros");
        }
    }
}
