package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Enderenco;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import io.github.guilhermemelo01.ecommerce_sport.service.validacao.NovoClienteValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ArgumentoInvalidoException("Id não encotrado"));
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    @Transactional
    public void inserir(NovoClienteDto clienteDto){
        NovoClienteValidacao.apenasLetras(clienteDto);
        Cliente cliente = new Cliente(null, clienteDto.getNome(), clienteDto.getCpf(),
                clienteDto.getTelefone(), clienteDto.getEmail());
        Enderenco enderenco = new Enderenco(clienteDto.getLogradouro(), clienteDto.getCidade(),
                clienteDto.getBairro(), clienteDto.getNumero(), clienteDto.getComplemento());
        cliente.setEnderenco(enderenco);
        clienteRepository.save(cliente);
    }

    public void atualizar(Integer id, AtualizarClienteDto clienteDto){
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());

        clienteRepository.save(cliente);
    }




}
