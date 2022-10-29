package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.repository.ProdutoRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id)
                .orElseThrow(ArgumentoInvalidoException::new);
    }

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public List<Produto> buscarPorNome(String nome){
        return produtoRepository.findByFirstnameIgnoreCase(nome);
    }

}
