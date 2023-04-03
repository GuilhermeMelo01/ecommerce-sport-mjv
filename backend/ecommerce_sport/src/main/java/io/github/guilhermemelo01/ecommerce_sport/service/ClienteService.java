package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteEnderecoDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Endereco;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.EnderecoRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ArgumentoInvalidoException("Id não encotrado"));
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Transactional
    public void inserir(NovoClienteDto clienteDto){
        Endereco endereco = clienteDto.getEndereco();
        enderecoRepository.save(endereco);

        Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getCpf(), clienteDto.getTelefone(),
                clienteDto.getEmail(), endereco);
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Long id, AtualizarClienteDto clienteDto) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());

        clienteRepository.save(cliente);
    }

//    public void atualizarClienteEnderenco(Integer id, AtualizarClienteEnderecoDto clienteEnderecoDto) {
//        Cliente cliente = buscarPorId(id);
//        //Cliente
//        cliente.setNome(clienteEnderecoDto.getNome());
//        cliente.setCpf(clienteEnderecoDto.getCpf());
//        cliente.setTelefone(clienteEnderecoDto.getTelefone());
//        cliente.setEmail(clienteEnderecoDto.getEmail());
//        //Enderenco
//        cliente.getEnderenco().setLogradouro(clienteEnderecoDto.getLogradouro());
//        cliente.getEnderenco().setCidade(clienteEnderecoDto.getCidade());
//        cliente.getEnderenco().setBairro(clienteEnderecoDto.getBairro());
//        cliente.getEnderenco().setNumero(clienteEnderecoDto.getNumero());
//        cliente.getEnderenco().setComplemento(clienteEnderecoDto.getComplemento());
//
//        clienteRepository.save(cliente);
//    }

    public void removerPorId(Long id) {
        clienteRepository.deleteById(id);
    }


}
