package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.CategoriaDAO;
import ar.com.facundobazan.dao.ProductoDAO;
import ar.com.facundobazan.models.Categoria;
import ar.com.facundobazan.models.Producto;
import ar.com.facundobazan.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {

    public static void main(String[] args) {
        Categoria celulares = new Categoria("Celulares");
        Producto celular = new Producto("Samsung", "Telefono usado", new BigDecimal(1000), celulares);

        EntityManager manager = JPAUtil.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(manager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(manager);

        manager.getTransaction().begin();

        categoriaDAO.insert(celulares);
        productoDAO.insert(celular);

        manager.getTransaction().commit();
        manager.close();

    }
}
