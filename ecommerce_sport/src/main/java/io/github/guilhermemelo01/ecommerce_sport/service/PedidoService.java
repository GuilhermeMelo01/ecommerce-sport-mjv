package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoPedidoDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Pagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;
import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.PedidoRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido findById(Integer id){
        return pedidoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Pedido fazerPedido(NovoPedidoDto novoPedidoDto){
        Cliente cliente = clienteRepository.findById(novoPedidoDto.getIdCliente()).orElseThrow();
        Produto produto = produtoRepository.findById(novoPedidoDto.getIdProduto()).orElseThrow();
        Pagamento pagamento = new Pagamento();
        Pedido pedido = new Pedido(null, LocalDateTime.now(), novoPedidoDto.getQuantidade(), cliente, produto, pagamento);


        pedido = pedidoRepository.save(pedido);
        clienteRepository.save(pedido.getCliente());
        produtoRepository.save(pedido.getProduto());

        return pedido;
    }
}
