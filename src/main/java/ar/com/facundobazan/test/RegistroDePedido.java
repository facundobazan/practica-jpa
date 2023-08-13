package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.CategoriaDAO;
import ar.com.facundobazan.dao.ClienteDAO;
import ar.com.facundobazan.dao.PedidoDAO;
import ar.com.facundobazan.dao.ProductoDAO;
import ar.com.facundobazan.models.*;
import ar.com.facundobazan.utils.JPAUtil;
import ar.com.facundobazan.vo.InformeDeVenta;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class RegistroDePedido {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        registrarCategoria(em);
        registrarProducto(em);
        registrarCliente(em);
        registrarPedido(em);

        BigDecimal valorTotal = new PedidoDAO(em).valorTotalVendido();
        System.out.println("Total vendido: " + valorTotal);

        /*List<Object[]> informe = new PedidoDAO(em).informeDeVentas();
        for(Object[] obj: informe){

            System.out.println(String.format("%s - %d - %t", obj[0], obj[1], obj[2]));
        }*/
        List<InformeDeVenta> informe = new PedidoDAO(em).informeDeVentasVO();
        for (InformeDeVenta venta : informe) System.out.println(venta);

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
