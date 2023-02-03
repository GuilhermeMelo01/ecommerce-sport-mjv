package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.service.ClienteService;
import io.github.guilhermemelo01.ecommerce_sport.util.cliente.ClienteAtualizarDtoTeste;
import io.github.guilhermemelo01.ecommerce_sport.util.cliente.ClienteCriarTeste;
import io.github.guilhermemelo01.ecommerce_sport.util.cliente.ClienteInserirDtoTeste;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteServiceMock;

    @BeforeEach
    void setUp(){
        List<Cliente> listaClientes = List.of(ClienteCriarTeste.clienteCriado());
        BDDMockito.when(clienteServiceMock.buscarTodos())
                .thenReturn(listaClientes);

        Cliente cliente = ClienteCriarTeste.clienteCriado();
        BDDMockito.when(clienteServiceMock.buscarPorId(ArgumentMatchers.any()))
                .thenReturn(cliente);

        BDDMockito.doNothing().when(clienteServiceMock).inserir(ArgumentMatchers.any());

        BDDMockito.doNothing().when(clienteServiceMock)
                .atualizarCliente(ArgumentMatchers.any(), ArgumentMatchers.any());

        BDDMockito.doNothing().when(clienteServiceMock)
                .atualizarClienteEnderenco(ArgumentMatchers.any(), ArgumentMatchers.any());

        BDDMockito.doNothing().when(clienteServiceMock)
                .removerPorId(ArgumentMatchers.any());
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado uma lista de clientes")
    void retornaListaDeClientes_QuandoTiverSucesso(){
        String nomeEsperado = ClienteCriarTeste.clienteCriado().getNome();
        List<Cliente> listaClientes = clienteController.buscarTodos().getBody();

        Assertions.assertThat(listaClientes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(listaClientes.get(0).getNome()).isEqualTo(nomeEsperado);
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado uma lista vazia")
    void retornaListaVazia_QuandoTiverSucesso(){
        List<Cliente> listaClientesMock = List.of(ClienteCriarTeste.clienteCriado());
        BDDMockito.when(clienteServiceMock.buscarTodos())
                .thenReturn(Collections.emptyList());

        List<Cliente> listaClientes = clienteController.buscarTodos().getBody();

        Assertions.assertThat(listaClientes)
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado um Cliente a partir do seu ID")
    void retornaClienteApartirDoId_QuandoTiverSucesso(){
        Integer idEsperado = ClienteCriarTeste.clienteCriado().getId();
        Cliente cliente = clienteController.buscarPorId(null).getBody();

        Assertions.assertThat(cliente)
                .isNotNull();

        Assertions.assertThat(cliente.getId()).isEqualTo(idEsperado);
    }

    @Test
    @DisplayName("Retorna sucesso quando for criado um novo cliente")
    void criaNovoCliente_QuandoTiverSucesso(){

        Assertions.assertThatCode(() -> clienteController.inserir(ClienteInserirDtoTeste.clienteCriado()))
                    .doesNotThrowAnyException();

        ResponseEntity<Void> entity = clienteController.inserir(ClienteInserirDtoTeste.clienteCriado());

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Retorna sucesso quando o cliente for atualizado parcialmente")
    void atualizaClienteParcialmente_QuandoTiverSucesso(){

        Assertions.assertThatCode(() -> clienteController.atualizar(1, ClienteAtualizarDtoTeste.clientePatchAtualizado()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = clienteController.atualizar(1, ClienteAtualizarDtoTeste.clientePatchAtualizado());

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Retorna sucesso quando o cliente for todo atualizado")
    void atualizaTodoCliente_QuandoTiverSucesso(){

        Assertions.assertThatCode(() -> clienteController.atualizar(
                1, ClienteAtualizarDtoTeste.clientePutAtualizado())).doesNotThrowAnyException();

        ResponseEntity<Void> entity = clienteController.atualizar(
                1, ClienteAtualizarDtoTeste.clientePutAtualizado());

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Retorna sucesso quando o cliente for removido")
    void removeCliente_QuandoTiverSucesso(){

        Assertions.assertThatCode(() -> clienteController.remover(1)).doesNotThrowAnyException();

        ResponseEntity<Void> entity = clienteController.remover(1);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Retorna IllegalArgumentException quando o cliente não for encotrado a partir do seu id")
    void retornaIllegalArgumentException_QuandoOClienteNaoForEcontrado(){
        Cliente cliente = ClienteCriarTeste.clienteCriado();
        BDDMockito.when(clienteServiceMock.buscarPorId(ArgumentMatchers.any()))
                .thenThrow(new IllegalArgumentException());

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> clienteController.buscarPorId(10));
    }


}