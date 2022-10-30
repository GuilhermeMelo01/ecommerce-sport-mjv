package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoPedidoDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;
import io.github.guilhermemelo01.ecommerce_sport.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
        Pedido pedido = pedidoService.buscarPorId(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping
    public ResponseEntity<Void> fazerPedido(@RequestBody NovoPedidoDto pedidoDto){
        Pedido pedido = pedidoService.fazerPedido(pedidoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
