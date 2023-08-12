package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.CategoriaDAO;
import ar.com.facundobazan.dao.PedidoDAO;
import ar.com.facundobazan.dao.ProductoDAO;
import ar.com.facundobazan.models.*;
import ar.com.facundobazan.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDePedido {

    public static void main(String[] args) {

        registrarProducto();
        EntityManager em = JPAUtil.getEntityManager();
        Producto producto = new ProductoDAO(em).findById(1);

        PedidoDAO pedidoDao = new PedidoDAO(em);
        em.getTransaction().begin();
        Cliente cliente = new Cliente("Facundo", "33430025");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto, pedido));

        pedidoDao.insert(pedido);
        em.getTransaction().commit();
    }

    private static void registrarProducto() {
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
