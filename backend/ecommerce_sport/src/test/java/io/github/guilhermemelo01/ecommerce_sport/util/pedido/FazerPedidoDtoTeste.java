package io.github.guilhermemelo01.ecommerce_sport.util.pedido;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.NovoPedidoDto;
import io.github.guilhermemelo01.ecommerce_sport.enums.EstadoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.enums.TipoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

public class FazerPedidoDtoTeste {
    private static ItemPedido ip = new ItemPedido(new Pedido(), new Produto(), 2, 30.0);

    public static NovoPedidoDto fazerPedidoDto() {
        NovoPedidoDto dto = new NovoPedidoDto();
        Pagamento pagamento = new Pagamento(1, EstadoPagamento.QUITADO, TipoPagamento.PIX);
        dto.setIdCliente(1);
        dto.setItens(new HashSet<>(List.of(ip)));
        dto.setTipoPagamento(pagamento.getTipoPagamento().getCod());
        return dto;
    }

    public static Pedido fazerPedido(){
        return new Pedido(
                1, LocalDateTime.now(),
                new Cliente(1, "Testestes", "94320482934", "1239183018", "Gui@gmail.com"),
                new Pagamento(1, EstadoPagamento.QUITADO, TipoPagamento.PIX), new HashSet<>(List.of(ip)));
    }
}
