package io.github.guilhermemelo01.ecommerce_sport.dto;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Endereco;
import io.github.guilhermemelo01.ecommerce_sport.model.ItemPedido;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;
import lombok.Data;

import java.util.Set;

@Data
public class CompraDto {

    private Cliente cliente;
    private Endereco endereco;
    private Pedido pedido;
    private Set<ItemPedido> itens;
}
