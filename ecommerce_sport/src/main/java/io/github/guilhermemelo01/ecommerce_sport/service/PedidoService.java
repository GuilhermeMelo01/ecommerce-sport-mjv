package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.NovoPedidoDto;
import io.github.guilhermemelo01.ecommerce_sport.enun.EstadoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.enun.TipoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.*;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.ItemPedidoRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.PedidoRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public Pedido findById(Integer id){
        return pedidoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Pedido fazerPedido(NovoPedidoDto novoPedidoDto){
        Cliente cliente = clienteRepository.findById(novoPedidoDto.getIdCliente()).orElseThrow();
        Produto produto = produtoRepository.findById(novoPedidoDto.getIdProduto()).orElseThrow();
        Pagamento pagamento = new Pagamento(null, EstadoPagamento.QUITADO, TipoPagamento.PIX);
        Pedido pedido = new Pedido(null, LocalDateTime.now(), cliente, pagamento);
//        for(ItemPedido iten: novoPedidoDto.getItemPedido()){
//            iten.setProduto(iten.getProduto());
//            iten.setPreco(iten.getProduto().getPreco());
//            iten.setPedido();
//        }




        pedido = pedidoRepository.save(pedido);
        clienteRepository.save(pedido.getCliente());

        return pedido;
    }
}
