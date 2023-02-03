package io.github.guilhermemelo01.ecommerce_sport.util.cliente;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;

public class ClienteInserirDtoTeste {

    public static NovoClienteDto clienteCriado() {
        NovoClienteDto dto = new NovoClienteDto();
        dto.setNome("Guilherme");
        dto.setCpf("1234567890");
        dto.setTelefone("4093284028");
        dto.setEmail("Gui@gmail.com");
        dto.setLogradouro("Rua celso ribeiro");
        dto.setCidade("Fortaleza");
        dto.setBairro("Palmirim");
        dto.setNumero("4000");
        dto.setComplemento("Igreja Matriz");
        return dto;
    }
}
