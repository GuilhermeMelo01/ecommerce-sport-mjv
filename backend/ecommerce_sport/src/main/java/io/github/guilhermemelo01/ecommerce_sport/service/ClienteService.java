package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.config.SecurityConfig;
import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteEnderecoDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.enums.EstadoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Enderenco;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.PagamentoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ArgumentoInvalidoException("Id não encotrado"));
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Transactional
    public void inserir(NovoClienteDto clienteDto) {
        Cliente cliente = new Cliente(null, clienteDto.getNome(),passwordEncoder.encode(clienteDto.getSenha())  , clienteDto.getCpf(),
                clienteDto.getTelefone(), clienteDto.getEmail());
        Enderenco enderenco = new Enderenco(clienteDto.getLogradouro(), clienteDto.getCidade(),
                clienteDto.getBairro(), clienteDto.getNumero(), clienteDto.getComplemento());
        cliente.setEnderenco(enderenco);
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Integer id, AtualizarClienteDto clienteDto) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());

        clienteRepository.save(cliente);
    }

    public void atualizarClienteEnderenco(Integer id, AtualizarClienteEnderecoDto clienteEnderecoDto) {
        Cliente cliente = buscarPorId(id);
        //Cliente
        cliente.setNome(clienteEnderecoDto.getNome());
        cliente.setCpf(clienteEnderecoDto.getCpf());
        cliente.setTelefone(clienteEnderecoDto.getTelefone());
        cliente.setEmail(clienteEnderecoDto.getEmail());
        //Enderenco
        cliente.getEnderenco().setLogradouro(clienteEnderecoDto.getLogradouro());
        cliente.getEnderenco().setCidade(clienteEnderecoDto.getCidade());
        cliente.getEnderenco().setBairro(clienteEnderecoDto.getBairro());
        cliente.getEnderenco().setNumero(clienteEnderecoDto.getNumero());
        cliente.getEnderenco().setComplemento(clienteEnderecoDto.getComplemento());

        clienteRepository.save(cliente);
    }

    public void removerPorId(Integer id) {
        clienteRepository.deleteById(id);
    }


}
