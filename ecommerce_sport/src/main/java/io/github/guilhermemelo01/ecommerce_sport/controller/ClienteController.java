package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteEnderecoDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody NovoClienteDto clienteDto){
        clienteService.inserir(clienteDto);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id,
                                          @Valid @RequestBody AtualizarClienteDto clienteDto){
        clienteService.atualizarCliente(id, clienteDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id,
                                          @Valid @RequestBody AtualizarClienteEnderecoDto clienteEnderecoDto){
        clienteService.atualizarClienteEnderenco(id, clienteEnderecoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        clienteService.removerPorId(id);
        return ResponseEntity.noContent().build();
    }
}
