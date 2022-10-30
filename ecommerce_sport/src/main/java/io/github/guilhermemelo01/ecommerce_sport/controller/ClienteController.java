package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> clientes = clienteService.buscarTodos();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id,
                                          @RequestBody AtualizarClienteDto clienteDto){
        clienteService.atualizarCliente(id, clienteDto);
        return ResponseEntity.noContent().build();
    }

}
