package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.model.Categoria;
import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.repository.CategoriaRespository;
import io.github.guilhermemelo01.ecommerce_sport.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRespository categoriaRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> buscarPrecosMenores(Double preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }

    public List<Produto> buscarPorCategoria(Integer idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria).orElseThrow();
        return categoria.getProdutos();
    }


}