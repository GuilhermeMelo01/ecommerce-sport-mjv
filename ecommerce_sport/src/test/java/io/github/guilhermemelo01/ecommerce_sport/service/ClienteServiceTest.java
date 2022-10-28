package io.github.guilhermemelo01.ecommerce_sport.service;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.repository.ClienteRepository;
import io.github.guilhermemelo01.ecommerce_sport.util.ClienteCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepositoryMock;

    @BeforeEach
    void setUp(){
        List<Cliente> listaClientes = List.of(ClienteCreator.clienteCriado());
        BDDMockito.when(clienteRepositoryMock.findAll())
                .thenReturn(listaClientes);

        Cliente cliente = ClienteCreator.clienteCriado();
        BDDMockito.when(clienteRepositoryMock.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(cliente));
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado uma lista de clientes")
    void retornaListaDeClientes_QuandoTiverSucesso(){
        String nomeEsperado = ClienteCreator.clienteCriado().getNome();
        List<Cliente> listaClientes = clienteService.buscarTodos();

        Assertions.assertThat(listaClientes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(listaClientes.get(0).getNome()).isEqualTo(nomeEsperado);
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado uma lista vazia")
    void retornaListaVazia_QuandoTiverSucesso(){
        BDDMockito.when(clienteRepositoryMock.findAll())
                .thenReturn(Collections.emptyList());

        List<Cliente> listaClientes = clienteService.buscarTodos();

        Assertions.assertThat(listaClientes)
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado um Cliente a partir do seu ID")
    void retornaClienteApartirDoId_QuandoTiverSucesso(){
        Integer idEsperado = ClienteCreator.clienteCriado().getId();
        Cliente cliente = clienteService.buscarPorId(null);

        Assertions.assertThat(cliente)
                .isNotNull();

        Assertions.assertThat(cliente.getId()).isEqualTo(idEsperado);
    }

    @Test
    @DisplayName("Retorna IllegalArgumentException quando o cliente não for encotrado a partir do seu id")
    void retornaIllegalArgumentException_QuandoOClienteNaoForEcontrado(){
        BDDMockito.when(clienteRepositoryMock.findById(ArgumentMatchers.any()))
                .thenThrow(new IllegalArgumentException());

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> clienteService.buscarPorId(10));
    }


    
}