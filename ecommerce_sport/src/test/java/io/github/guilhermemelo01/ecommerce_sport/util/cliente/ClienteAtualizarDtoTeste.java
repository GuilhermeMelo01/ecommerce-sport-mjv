package io.github.guilhermemelo01.ecommerce_sport.util.cliente;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteEnderecoDto;

public class ClienteAtualizarDtoTeste {

    public static AtualizarClienteDto clientePatchAtualizado() {
        AtualizarClienteDto dto = new AtualizarClienteDto();
        dto.setNome("Guilherme");
        dto.setEmail("Teste@gmail.com");
        dto.setTelefone("4093284028");
        return dto;
    }

    public static AtualizarClienteEnderecoDto clientePutAtualizado() {
        AtualizarClienteEnderecoDto dto = new AtualizarClienteEnderecoDto();
        dto.setNome("Monalisa");
        dto.setCpf("1234567890");
        dto.setTelefone("4093284028");
        dto.setEmail("Gui@gmail.com");
        dto.setLogradouro("Rua celso ribeiro");
        dto.setCidade("Caucaia");
        dto.setBairro("Montese");
        dto.setNumero("10000");
        dto.setComplemento("Igreja Matriz");
        return dto;
    }
}
