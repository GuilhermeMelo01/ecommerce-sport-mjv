package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.dto.CompraDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.RespostaCompraDto;
import io.github.guilhermemelo01.ecommerce_sport.service.CompraPedidoImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class CompraController {

    private CompraPedidoImpl compraPedido;

    public CompraController(CompraPedidoImpl compraPedido){
        this.compraPedido = compraPedido;
    }

    @PostMapping("/comprar")
    public RespostaCompraDto executarComprar(@RequestBody CompraDto compraDto){
        return compraPedido.executarCompra(compraDto);
    }
}
