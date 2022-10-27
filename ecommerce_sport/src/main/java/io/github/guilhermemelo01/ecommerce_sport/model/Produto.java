package io.github.guilhermemelo01.ecommerce_sport.model;

import io.github.guilhermemelo01.ecommerce_sport.enun.Categoria;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    private Integer categoria; //Quero apenas o cod da categoria

    @OneToOne(mappedBy = "produto") // Mapeamento 1 para 1
    private Pedido pedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria(){
        return Categoria.toEnum(categoria);
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
