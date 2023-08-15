package ar.com.facundobazan.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaConLlaveCompuesta {

    @EmbeddedId
    private CategoriaId categoriaId;

    public CategoriaConLlaveCompuesta() {

    }

    public CategoriaConLlaveCompuesta(String nombre) {

        this.categoriaId = new CategoriaId(nombre, "12345");
    }

    public String getNombre() {

        return this.categoriaId.getNombre();
    }

    public void setNombre(String nombre) {

        this.categoriaId.setNombre(nombre);
    }
}
