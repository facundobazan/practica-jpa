package ar.com.facundobazan.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha = LocalDate.now();
    private BigDecimal valorTotal;

    @ManyToOne
    private Cliente cliente;
    @OneToMany
    List<ItemsPedido> items;

    public Pedido() {

    }

    public Pedido(Cliente cliente) {
        setCliente(cliente);
    }

    public Pedido(LocalDate fecha, BigDecimal valorTotal, Cliente cliente) {

        setFecha(fecha);
        setValorTotal(valorTotal);
        setCliente(cliente);
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
