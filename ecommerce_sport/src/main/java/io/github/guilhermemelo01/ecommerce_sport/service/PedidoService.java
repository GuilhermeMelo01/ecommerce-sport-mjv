package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoPedidoDto;
import io.github.guilhermemelo01.ecommerce_sport.enun.EstadoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.enun.TipoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.*;
import io.github.guilhermemelo01.ecommerce_sport.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Pedido fazerPedido(NovoPedidoDto novoPedidoDto) {
        //Cliente -> achar o id do cliente
        Cliente cliente = clienteRepository.findById(novoPedidoDto.getIdCliente()).orElseThrow();

        //Produto -> achar o id do produto requisitado
        Produto produto = produtoRepository.findById(novoPedidoDto.getIdProduto()).orElseThrow();

        //Pagamento -> Logica para ver qual vai ser o Estado do Pagamento de acordo com o Tipo
        EstadoPagamento estadoPagamento;
        Integer codTipoPagamento = novoPedidoDto.getTipoPagamento();
        if (codTipoPagamento > 3 || codTipoPagamento < 1) {
            throw new IllegalArgumentException("Não existe esse tipo de pagamento!");
        } else if (codTipoPagamento == 1) {
            estadoPagamento = EstadoPagamento.PENDENTE;
        } else {
            estadoPagamento = EstadoPagamento.QUITADO;
        }
        Pagamento pagamento = new Pagamento(null, estadoPagamento,
                TipoPagamento.toEnum(codTipoPagamento));

        //Pedido
        Pedido pedido = new Pedido(null, LocalDateTime.now(), cliente, pagamento);

        //Item Pedido
        ItemPedido iten = new ItemPedido(pedido, produto, novoPedidoDto.getQuantidade(), produto.getPreco());
        pedido.getItens().add(iten);

        pedido = pedidoRepository.save(pedido);
        clienteRepository.save(pedido.getCliente());
        pagamentoRepository.save(pedido.getPagamento());
        itemPedidoRepository.saveAll(pedido.getItens());
        produtoRepository.save(iten.getProduto());

        return pedido;
    }
}
