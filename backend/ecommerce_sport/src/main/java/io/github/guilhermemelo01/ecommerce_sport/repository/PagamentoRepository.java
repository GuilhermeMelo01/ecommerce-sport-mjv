package io.github.guilhermemelo01.ecommerce_sport.repository;

import io.github.guilhermemelo01.ecommerce_sport.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
