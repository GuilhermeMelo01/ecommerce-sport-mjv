package io.github.guilhermemelo01.ecommerce_sport.service;

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

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(ArgumentoInvalidoException::new);
    }
}
