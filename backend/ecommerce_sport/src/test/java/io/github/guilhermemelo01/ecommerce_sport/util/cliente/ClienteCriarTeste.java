package io.github.guilhermemelo01.ecommerce_sport.util.cliente;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Enderenco;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;

import java.util.List;

public class ClienteCriarTeste {

    public static Cliente clienteCriado(){
        return new Cliente(1, "Guilherme", "1234567890", "4093284028",
                "Gui@gmail.com", new Enderenco(), List.of(new Pedido()));
    }
}
