package io.github.guilhermemelo01.ecommerce_sport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.guilhermemelo01.ecommerce_sport.enun.EstadoPagamento;
import io.github.guilhermemelo01.ecommerce_sport.enun.TipoPagamento;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pagamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer estadoPagamento; //Integer pq quero apenas o cod do estadoPagamento

    private Integer tipoPagamento;

    @JsonIgnore
    @OneToOne(mappedBy = "pagamento")
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, TipoPagamento tipoPagamento) {
        this.id = id;
        this.estadoPagamento = (estadoPagamento == null) ? null : estadoPagamento.getCod();
        this.tipoPagamento =  (tipoPagamento == null) ? null : tipoPagamento.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
    }

    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.toEnum(tipoPagamento);
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
