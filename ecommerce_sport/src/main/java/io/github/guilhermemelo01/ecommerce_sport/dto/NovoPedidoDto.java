package io.github.guilhermemelo01.ecommerce_sport.dto;

import io.github.guilhermemelo01.ecommerce_sport.model.ItemPedido;

import java.util.List;

public class NovoPedidoDto {

    private Integer idCliente;
    private Integer idProduto;
    private List<ItemPedido> itemPedido;
    private Integer quantidade;

    public NovoPedidoDto() {
    }

    public NovoPedidoDto(Integer idCliente, Integer idProduto, List<ItemPedido> itemPedido, Integer quantidade) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.itemPedido = itemPedido;
        this.quantidade = quantidade;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
