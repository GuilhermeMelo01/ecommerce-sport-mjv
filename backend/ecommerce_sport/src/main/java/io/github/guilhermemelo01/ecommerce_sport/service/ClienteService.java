package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.dto.AtualizarClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.dto.NovoClienteDto;
import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Endereco;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.repository.EnderecoRepository;
import io.github.guilhermemelo01.ecommerce_sport.service.exception.ArgumentoInvalidoException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository){
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

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

    public void removerPorId(Long id) {
        clienteRepository.deleteById(id);
    }


}
