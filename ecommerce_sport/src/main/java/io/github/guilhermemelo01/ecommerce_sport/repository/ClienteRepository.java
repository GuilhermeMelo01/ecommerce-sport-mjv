package io.github.guilhermemelo01.ecommerce_sport.repository;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
