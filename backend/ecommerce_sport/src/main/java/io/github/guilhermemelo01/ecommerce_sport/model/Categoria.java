package io.github.guilhermemelo01.ecommerce_sport.model;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
>>>>>>> master

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
    private Long id;
=======
    @Column(name = "id", nullable = true)
    private Integer id;
>>>>>>> master

    @Column(name = "nome")
    private String nome;

<<<<<<< HEAD
    @OneToMany(mappedBy = "categoria")
    private Set<Produto> produtos = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
=======
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
>>>>>>> master
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

<<<<<<< HEAD
    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
=======
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
>>>>>>> master
