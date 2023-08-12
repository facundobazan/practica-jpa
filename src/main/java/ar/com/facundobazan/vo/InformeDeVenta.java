package ar.com.facundobazan.vo;

import java.time.LocalDate;

public class InformeDeVenta {

    private String nombreDelProducto;
    private long cantidadDelProducto;
    private LocalDate fechaDeUltimaVenta;

    public InformeDeVenta(String nombreDelProducto, Long cantidadDelProducto, LocalDate fechaDeUltimaVenta) {
        this.nombreDelProducto = nombreDelProducto;
        this.cantidadDelProducto = cantidadDelProducto;
        this.fechaDeUltimaVenta = fechaDeUltimaVenta;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public Long getCantidadDelProducto() {
        return cantidadDelProducto;
    }

    public void setCantidadDelProducto(Long cantidadDelProducto) {
        this.cantidadDelProducto = cantidadDelProducto;
    }

    public LocalDate getFechaDeUltimaVenta() {
        return fechaDeUltimaVenta;
    }

    public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
        this.fechaDeUltimaVenta = fechaDeUltimaVenta;
    }

    @Override
    public String toString() {
        return "InformeDeVenta{" +
                "nombreDelProducto='" + nombreDelProducto + '\'' +
                ", cantidadDelProducto=" + cantidadDelProducto +
                ", fechaDeUltimaVenta=" + fechaDeUltimaVenta +
                '}';
    }
}
