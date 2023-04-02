package io.github.guilhermemelo01.ecommerce_sport.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @OneToOne(mappedBy = "endereco")
    private Pedido pedido;
    @OneToMany(mappedBy = "endereco")
    private List<Cliente> clientes = new ArrayList<>();
}
