package io.github.guilhermemelo01.ecommerce_sport.dto;

import io.github.guilhermemelo01.ecommerce_sport.model.ItemPedido;

import java.util.Set;

public class NovoPedidoDto {

    private Integer idCliente;
    private Set<ItemPedido> itens;
    private Integer tipoPagamento;

    public NovoPedidoDto() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Integer tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
