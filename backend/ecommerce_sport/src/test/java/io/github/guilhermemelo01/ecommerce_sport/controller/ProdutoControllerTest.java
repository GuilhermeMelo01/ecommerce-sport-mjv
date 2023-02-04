package io.github.guilhermemelo01.ecommerce_sport.controller;

import io.github.guilhermemelo01.ecommerce_sport.model.Categoria;
import io.github.guilhermemelo01.ecommerce_sport.model.Produto;
import io.github.guilhermemelo01.ecommerce_sport.service.ProdutoService;
import io.github.guilhermemelo01.ecommerce_sport.util.produto.CriarProdutoTest;
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

@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoServiceMock;

//    @BeforeEach
//    void setUp(){
//        List<Produto> listaProdutos = List.of(CriarProdutoTest.produtoCriado());
//        BDDMockito.when(produtoServiceMock.buscarTodos())
//                .thenReturn(listaProdutos);
//
//        BDDMockito.when(produtoServiceMock.buscarPorNome(ArgumentMatchers.any()))
//                .thenReturn(List.of(CriarProdutoTest.produtoCriado()));
//
//        BDDMockito.when(produtoServiceMock.buscarPrecosMenores(ArgumentMatchers.any()))
//                .thenReturn(List.of(CriarProdutoTest.produtoCriado()));
//
//        BDDMockito.when(produtoServiceMock.buscarPorCategoria(ArgumentMatchers.any()))
//                .thenReturn(List.of(CriarProdutoTest.produtoCriado()));
//    }
//
//    @Test
//    @DisplayName("Retorna sucesso quando for retornado uma lista de produtos")
//    void retornaListaDeClientes_QuandoTiverSucesso(){
//        String nomeEsperado = CriarProdutoTest.produtoCriado().getNome();
//        List<Produto> listaProdutos = produtoController.buscarTodos().getBody();
//
//        Assertions.assertThat(listaProdutos)
//                .isNotNull()
//                .isNotEmpty();
//
//        Assertions.assertThat(listaProdutos.get(0).getNome()).isEqualTo(nomeEsperado);
//    }
//
//    @Test
//    @DisplayName("Retorna sucesso quando for retornado uma lista vazia")
//    void retornaListaVazia_QuandoTiverSucesso(){
//        BDDMockito.when(produtoServiceMock.buscarTodos())
//                .thenReturn(Collections.emptyList());
//
//        List<Produto> listaProdutos = produtoController.buscarTodos().getBody();
//
//        Assertions.assertThat(listaProdutos)
//                .isNotNull()
//                .isEmpty();
//    }
//
//    @Test
//    @DisplayName("Retorna sucesso quando for retornado uma lista de produtos por nome")
//    void retornaListProdutoPorNome_QuandoTiverSucesso(){
//
//        List<Produto> produtos = produtoController.buscarPorNome(
//                CriarProdutoTest.produtoCriado().getNome()).getBody();
//
//        Assertions.assertThat(produtos)
//                .isNotNull()
//                .isNotEmpty();
//    }
//
//    @Test
//    @DisplayName("Retorna sucesso quando for retornado uma lista de produtos por preco")
//    void retornaListProdutoPorPrecoMenorQue_QuandoTiverSucesso(){
//        Double precoMaior = 11.0;
//        List<Produto> produtos = produtoController.buscarPrecosMenores(
//                CriarProdutoTest.produtoCriado().getPreco()).getBody();
//
//        Assertions.assertThat(produtos)
//                .isNotNull()
//                .isNotEmpty();
//
//        Assertions.assertThat(produtos.get(0).getPreco()).isLessThan(precoMaior);
//    }
//
//    @Test
//    @DisplayName("Retorna sucesso quando for retornado uma lista de produtos por categoria")
//    void retornaListaProdutoPorCategoria_QuandoTiverSucesso(){
//        Categoria categoriaEsperada = Categoria;
//
//        List<Produto> produtos = produtoController.buscarPorCategoria(null).getBody();
//
//        Assertions.assertThat(produtos)
//                .isNotNull()
//                .isNotEmpty();
//
//        Assertions.assertThat(produtos.get(0).getCategoria()).isEqualTo(categoriaEsperada);
//    }
}