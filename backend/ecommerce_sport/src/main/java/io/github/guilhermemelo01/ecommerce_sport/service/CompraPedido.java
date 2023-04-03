package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.CompraDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.RespostaCompraDto;


public interface CompraPedido {
    RespostaCompraDto executarCompra(CompraDto compraDto);
}
