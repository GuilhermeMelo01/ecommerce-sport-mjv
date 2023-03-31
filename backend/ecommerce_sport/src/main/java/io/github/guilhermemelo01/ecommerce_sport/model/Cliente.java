package io.github.guilhermemelo01.ecommerce_sport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.guilhermemelo01.ecommerce_sport.enums.Perfil;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;
import java.util.stream.Collectors;

<<<<<<< HEAD

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
=======
@Entity
@Table(name = "cliente")
public class Cliente {
>>>>>>> master

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

<<<<<<< HEAD
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

=======
    @JsonIgnore
    @Column(name = "senha")
    private String senha;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Email
>>>>>>> master
    @Column(name = "email", nullable = false)
    private String email;


    @CollectionTable(name = "perfil")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil")
    private Set<Integer> perfis = new HashSet<>();

    @Embedded
    private Enderenco enderenco;
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

<<<<<<< HEAD
    public Long getId() {
=======
    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String senha, String cpf,
                   String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf,
                   String telefone, String email, Enderenco enderenco, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        addPerfil(Perfil.CLIENTE);
        this.enderenco = enderenco;
        this.pedidos = pedidos;
    }

    public Integer getId() {
>>>>>>> master
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Perfil> getPerfis(){
        return perfis.stream().map(Perfil::toEnum).collect(Collectors.toSet());
    }
    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCod());
    }

    public Enderenco getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(Enderenco enderenco) {
        this.enderenco = enderenco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
