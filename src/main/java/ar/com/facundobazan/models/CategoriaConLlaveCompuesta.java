package ar.com.facundobazan.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaConLlaveCompuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    public CategoriaConLlaveCompuesta() {

    }

    public CategoriaConLlaveCompuesta(String nombre) {

        setNombre(nombre);
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
}
