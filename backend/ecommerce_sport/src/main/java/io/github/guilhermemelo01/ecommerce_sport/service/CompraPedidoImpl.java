package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.CompraDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.RespostaCompraDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Enderenco;
import io.github.guilhermemelo01.ecommerce_sport.model.ItemPedido;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CompraPedidoImpl implements CompraPedido {

    private final ClienteRepository clienteRepository;

    public CompraPedidoImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public RespostaCompraDto executarCompra(CompraDto compraDto) {

        //Buscar o pedido
        Pedido pedido = compraDto.getPedido();

        //Gerar o codigo do rastreamento
        String codigoRastreamentoPedido = gerarCodigoRastreamentoPedido();

        //Colocar os itens pedidos no pedido.
        Set<ItemPedido> itens = compraDto.getItens();
        itens.forEach(pedido::add);

        //Colocar o para pedido para o cliente
        Cliente cliente = compraDto.getCliente();
        pedido.setCliente(cliente);
        clienteRepository.save(cliente);

        //Colocar o enderenço no pedido
        Enderenco enderenco = compraDto.getCliente().getEnderenco();
        pedido.getCliente().setEnderenco(enderenco);

        //Persistir no banco de dados
        clienteRepository.save(cliente);

        return new RespostaCompraDto(codigoRastreamentoPedido);
    }

    private String gerarCodigoRastreamentoPedido() {
        //Gerar com UUID
        return UUID.randomUUID().toString();
    }
}
