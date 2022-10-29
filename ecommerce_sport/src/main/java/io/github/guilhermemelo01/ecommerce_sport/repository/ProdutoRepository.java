package io.github.guilhermemelo01.ecommerce_sport.repository;

import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
