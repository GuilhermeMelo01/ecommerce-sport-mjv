package io.github.guilhermemelo01.ecommerce_sport.dto;

public class RespostaCompraDto {

    private String codigoRastreamentoPedido;

    public RespostaCompraDto() {
    }

    public RespostaCompraDto(String codigoRastreamentoPedido) {
        this.codigoRastreamentoPedido = codigoRastreamentoPedido;
    }

    public String getCodigoRastreamentoPedido() {
        return codigoRastreamentoPedido;
    }

    public void setCodigoRastreamentoPedido(String codigoRastreamentoPedido) {
        this.codigoRastreamentoPedido = codigoRastreamentoPedido;
    }
}
