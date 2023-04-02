package io.github.guilhermemelo01.ecommerce_sport.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "rastreamento_pedido")
    private String rastreamentoPedido;
    @Column(name = "data_pedido")
    @CreationTimestamp
    private LocalDateTime dataPedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itemPedidos = new HashSet<>();

    public void add(ItemPedido itemPedido){
        if(itemPedido != null){
            if(this.itemPedidos == null){
                this.itemPedidos = new HashSet<>();
            }
            itemPedidos.add(itemPedido);
            itemPedido.setPedido(this);
        }
    }
}
