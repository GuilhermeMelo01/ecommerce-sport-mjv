package io.github.guilhermemelo01.ecommerce_sport.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "quantidade_total")
    private Integer quantidadeTotal;

    @Column(name = "data_pedido")
    @CreationTimestamp
    private LocalDateTime dataPedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco")
    private Endereco endereco;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itemPedidos = new HashSet<>();

    public void add(ItemPedido item){
        if(item != null){
            if(this.itemPedidos == null){
                itemPedidos = new HashSet<>();
            }
            itemPedidos.add(item);
            item.setPedido(this);
        }
    }
}
