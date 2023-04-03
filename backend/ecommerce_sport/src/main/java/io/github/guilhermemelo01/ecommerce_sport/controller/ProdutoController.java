package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> clientes = produtoService.buscarTodos();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/buscarNome")
    public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam String nome){
        List<Produto> produtos = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/buscarPreco")
    public ResponseEntity<List<Produto>> buscarPrecosMenores(@RequestParam Double preco){
        List<Produto> produtos = produtoService.buscarPrecosMenores(preco);
        return ResponseEntity.ok().body(produtos);
    }
}
