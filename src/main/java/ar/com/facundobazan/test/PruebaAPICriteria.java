package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.ProductoDAO;
import ar.com.facundobazan.models.Producto;
import ar.com.facundobazan.utils.JPAUtil;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PruebaAPICriteria {

    public static void main(String[] args) throws FileNotFoundException {

        LoadRecords.cargarRegistros();
        ProductoDAO productoDAO = new ProductoDAO(JPAUtil.getEntityManager());

        List<Producto> productosNombre = productoDAO.consultarPorParametrosConAPICriteria("iPhone", null, null, null);
        List<Producto> productosDescripcion = productoDAO.consultarPorParametrosConAPICriteria(null, "nuevo", null, null);
        List<Producto> productosPrecio = productoDAO.consultarPorParametrosConAPICriteria(null, null, new BigDecimal(100), null);
        List<Producto> productosFecha = productoDAO.consultarPorParametrosConAPICriteria(null, null, null, LocalDate.parse("2023-03-09"));

        for (Producto producto : productosNombre) System.out.println(producto.getDescripcion());
        for (Producto producto : productosDescripcion) System.out.println(producto.getDescripcion());
        for (Producto producto : productosPrecio) System.out.println(producto.getDescripcion());
        for (Producto producto : productosFecha) System.out.println(producto.getDescripcion());
    }
}
