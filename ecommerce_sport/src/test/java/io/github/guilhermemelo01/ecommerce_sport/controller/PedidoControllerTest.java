package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.model.Cliente;
import io.github.guilhermemelo01.ecommerce_sport.model.Pedido;
import io.github.guilhermemelo01.ecommerce_sport.service.PedidoService;
import io.github.guilhermemelo01.ecommerce_sport.util.cliente.ClienteCriarTeste;
import io.github.guilhermemelo01.ecommerce_sport.util.pedido.FazerPedidoDtoTeste;
import io.github.guilhermemelo01.ecommerce_sport.util.pedido.PedidoCriarTeste;
import org.aspectj.lang.annotation.Before;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(SpringExtension.class)
class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private PedidoService pedidoServiceMock;

    @BeforeEach
    void setUp(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Pedido pedido = PedidoCriarTeste.pedidoCriado();
        BDDMockito.when(pedidoServiceMock.buscarPorId(ArgumentMatchers.any()))
                .thenReturn(pedido);

        BDDMockito.when(pedidoServiceMock.fazerPedido(ArgumentMatchers.any()))
                .thenReturn(FazerPedidoDtoTeste.fazerPedido());

        BDDMockito.doNothing().when(pedidoServiceMock)
                .cancelarPedido(ArgumentMatchers.any());
    }

    @Test
    @DisplayName("Retorna sucesso quando for retornado um Pedido a partir do seu ID")
    void retornaPedidoApartirDoId_QuandoTiverSucesso(){
        Integer idEsperado = PedidoCriarTeste.pedidoCriado().getId();
        Pedido pedido = pedidoController.buscarPorId(null).getBody();

        Assertions.assertThat(pedido)
                .isNotNull();

        Assertions.assertThat(pedido.getId()).isEqualTo(idEsperado);
    }

    @Test
    @DisplayName("Retorna sucesso quando for feito um novo pedido")
    void fazerNovoPedido_QuandoTiverSucesso(){

        Assertions.assertThatCode(() -> pedidoController.fazerPedido(FazerPedidoDtoTeste.fazerPedidoDto()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = pedidoController.fazerPedido(FazerPedidoDtoTeste.fazerPedidoDto());

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("Retorna sucesso quando o pedido for cancelado")
    void cancelarPedido_QuandoTiverSucesso(){

        Assertions.assertThatCode(() -> pedidoController.cancelar(1))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = pedidoController.cancelar(1);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Retorna IllegalArgumentException quando o pedido não for encotrado a partir do seu id")
    void retornaIllegalArgumentException_QuandoPedidoNaoForEcontrado(){
        BDDMockito.when(pedidoServiceMock.buscarPorId(ArgumentMatchers.any()))
                .thenThrow(new IllegalArgumentException());

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> pedidoController.buscarPorId(100));
    }
}