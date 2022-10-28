package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.repository.ProdutoRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ArgumentoInvalidoException("Id inválido: "+ id));
    }

}
