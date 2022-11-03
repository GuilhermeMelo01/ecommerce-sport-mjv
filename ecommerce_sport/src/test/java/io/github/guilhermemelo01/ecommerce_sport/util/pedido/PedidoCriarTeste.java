package io.github.guilhermemelo01.ecommerce_sport.util.pedido;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Enderenco;
import io.github.guilhermemelo01.ecommerce_sport.model.Pagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoCriarTeste {

    public static Pedido pedidoCriado(){
        return new Pedido(1, LocalDateTime.now(), new Cliente(), new Pagamento());
    }
}
