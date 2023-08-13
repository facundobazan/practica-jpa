package ar.com.facundobazan.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.consultaDePrecio", query = "SELECT P.precio FROM Producto AS P WHERE P.nombre = :string")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private LocalDate fechaDeRegistro = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    public Producto() {

    }

    public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {

        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCategoria(categoria);
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
