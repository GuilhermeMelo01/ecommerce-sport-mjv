package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> clientes = produtoService.buscarTodos();
        return ResponseEntity.ok().body(clientes);
    }

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome){
        List<Produto> produtos = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok().body(produtos);
    }

}
