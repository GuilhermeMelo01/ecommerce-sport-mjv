package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoPedidoDto;
import io.github.guilhermemelo01.ecommerce_sport.enun.EstadoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.enun.TipoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.*;
import io.github.guilhermemelo01.ecommerce_sport.repository.*;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
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


    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ArgumentoInvalidoException("Id não encotrado"));
    }

//    @Transactional
//    public Pedido fazerPedido(NovoPedidoDto novoPedidoDto) {
//        Cliente cliente = clienteRepository.findById(
//                novoPedidoDto.getIdCliente()).orElseThrow(() -> new ArgumentoInvalidoException("Id não encotrado"));
//
//        Produto produto = produtoRepository.findById(
//                novoPedidoDto.getIdProduto()).orElseThrow();
//
//        EstadoPagamento estadoPagamento;
//        Integer codTipoPagamento = novoPedidoDto.getTipoPagamento();
//        if (codTipoPagamento > 3 || codTipoPagamento < 1) {
//            throw new IllegalArgumentException("Não existe esse tipo de pagamento!");
//        } else if (codTipoPagamento == 1) {
//            estadoPagamento = EstadoPagamento.PENDENTE;
//        } else {
//            estadoPagamento = EstadoPagamento.QUITADO;
//        }
//
//        Pagamento pagamento = new Pagamento(null, estadoPagamento,
//                TipoPagamento.toEnum(codTipoPagamento));
//
//        Pedido pedido = new Pedido(null, LocalDateTime.now(), cliente, pagamento);
//
//        ItemPedido itemPedido = new ItemPedido(pedido, produto,
//                novoPedidoDto.getQuantidade(), produto.getPreco());
//        pedido.getItens().add(itemPedido);
//
//        pedido = pedidoRepository.save(pedido);
//        clienteRepository.save(pedido.getCliente());
//        pagamentoRepository.save(pedido.getPagamento());
//        itemPedidoRepository.saveAll(pedido.getItens());
//        produtoRepository.save(itemPedido.getProduto());
//
//        return pedido;
//    }

    @Transactional
    public Pedido fazerPedido(NovoPedidoDto novoPedidoDto) {
        Cliente cliente = clienteRepository.findById(
                novoPedidoDto.getIdCliente()).orElseThrow(() -> new ArgumentoInvalidoException("Id não encotrado"));

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

        Pedido pedido = new Pedido(null, LocalDateTime.now(), cliente, pagamento);

        for (ItemPedido ip : novoPedidoDto.getItens()) {
            Integer produtoId = ip.getProduto().getId();
            Produto produto = produtoRepository.findById(produtoId).orElseThrow();
            ip.setPedido(pedido);

            ip.getProduto().setNome(produto.getNome());
            ip.getProduto().setPreco(produto.getPreco());
            ip.getProduto().setCategoria(produto.getCategoria());
            ip.setProduto(produto);

            ip.setQuantidade(ip.getQuantidade());
            ip.setPreco(produto.getPreco());

            pedido.getItens().add(ip);
            produto.getItens().add(ip);

            pedidoRepository.save(pedido);
            produtoRepository.save(produto);
            itemPedidoRepository.saveAll(pedido.getItens());
        }

        pedido = pedidoRepository.save(pedido);
        clienteRepository.save(pedido.getCliente());
        pagamentoRepository.save(pedido.getPagamento());
        itemPedidoRepository.saveAll(pedido.getItens());

        return pedido;
    }

    public void deletarPorId() {

    }
}
