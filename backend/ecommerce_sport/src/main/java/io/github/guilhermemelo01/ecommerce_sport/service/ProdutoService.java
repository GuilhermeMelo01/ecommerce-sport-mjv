package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.enums.Categoria;
import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> buscarPrecosMenores(Double preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }

    public List<Produto> buscarPorCategoria(Integer cod) {
        List<Produto> produtos = produtoRepository.findAll();
        List<Produto> produtoCategoria = new ArrayList<>();
        Categoria.toEnum(cod);
        for(Produto p: produtos){
            if(p.getCategoria().getCod().equals(cod)){
                produtoCategoria.add(p);
            }
        }
        return produtoCategoria;
    }


}