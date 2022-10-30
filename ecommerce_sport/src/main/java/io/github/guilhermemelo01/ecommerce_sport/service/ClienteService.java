package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(ArgumentoInvalidoException::new);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public void atualizarCliente(Integer id, AtualizarClienteDto clienteDto){
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());

        clienteRepository.save(cliente);
    }
}
