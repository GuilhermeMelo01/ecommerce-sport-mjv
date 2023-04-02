package io.github.guilhermemelo01.ecommerce_sport.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;
    @Column(name = "imagem_url")
    private String imagem_url;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "unidades_stock")
    private Integer unidadesNoStock;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
