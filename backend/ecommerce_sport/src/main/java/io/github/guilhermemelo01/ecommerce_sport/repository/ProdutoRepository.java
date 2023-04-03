package io.github.guilhermemelo01.ecommerce_sport.repository;

import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContaining(String nome);

    List<Produto> findByPrecoLessThan(Double preco);
}
