package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.ProductoDAO;
import ar.com.facundobazan.models.Producto;
import ar.com.facundobazan.utils.JPAUtil;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PruebaDeParametros {

    public static void main(String[] args) throws FileNotFoundException {

        LoadRecords.cargarRegistros();
        ProductoDAO productoDAO = new ProductoDAO(JPAUtil.getEntityManager());

        List<Producto> productoNombre = productoDAO.consultarPorParametros("Samsung S20", null, null, null);
        List<Producto> productoDescripcion = productoDAO.consultarPorParametros(null, "nuevo", null, null);
        List<Producto> productoPrecio = productoDAO.consultarPorParametros(null, null, new BigDecimal(1000), null);
        List<Producto> productoFecha = productoDAO.consultarPorParametros(null, null, null, LocalDate.parse("2023-03-09"));

        for (Producto producto : productoNombre) System.out.println(producto.getDescripcion());
        for (Producto producto : productoDescripcion) System.out.println(producto.getDescripcion());
        for (Producto producto : productoPrecio) System.out.println(producto.getDescripcion());
        for (Producto producto : productoFecha) System.out.println(producto.getDescripcion());
    }
}
