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
    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;
    @Column(name = "cidade", length = 30, nullable = false)
    private String cidade;
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    @Column(name = "complemento", length = 50)
    private String complemento;

    @OneToMany(mappedBy = "endereco")
    private List<Cliente> clientes = new ArrayList<>();
}
