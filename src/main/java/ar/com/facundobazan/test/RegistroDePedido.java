package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.*;
import ar.com.facundobazan.models.*;
import ar.com.facundobazan.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDePedido {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        registrarCategoria(em);
        registrarProducto(em);
        registrarCliente(em);
        registrarPedido(em);
        em.close();
    }

    private static void registrarPedido(EntityManager em) {

        em.getTransaction().begin();

        Pedido pedido = new Pedido(new ClienteDAO(em).findById(1L));
        pedido.agregarItems(new ItemsPedido(
                5,
                new ProductoDAO(em).findById(1L),
                pedido));


        new PedidoDAO(em).insert(pedido);

        em.getTransaction().commit();
    }

    private static void registrarCliente(EntityManager em) {

        em.getTransaction().begin();

        new ClienteDAO(em).insert(new Cliente("Facundo", "33430025"));

        em.getTransaction().commit();
    }

    private static void registrarCategoria(EntityManager em) {

        em.getTransaction().begin();

        new CategoriaDAO(em).insert(new Categoria("Celulares"));

        em.getTransaction().commit();
    }

    private static void registrarProducto(EntityManager em) {

        em.getTransaction().begin();

        new ProductoDAO(em).insert(new Producto(
                "Samsung",
                "Telefono usado",
                new BigDecimal(1000),
                new CategoriaDAO(em).findById(1L)));

        em.getTransaction().commit();
    }
}
