package io.github.guilhermemelo01.ecommerce_sport.dto;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.ItemPedido;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;

import java.util.Set;

public class CompraDto {

    private Cliente cliente;
    private Pedido pedido;
    private Set<ItemPedido> itens;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }
}
