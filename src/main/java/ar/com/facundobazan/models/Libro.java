package ar.com.facundobazan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "libros")
public class Libro extends Producto {

    private String autor;
    private int paginas;

    public Libro() {

    }

    public Libro(BigDecimal precio, Categoria categoria, String autor, int paginas) {

        this.autor = autor;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
