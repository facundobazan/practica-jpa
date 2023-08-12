package ar.com.facundobazan.dao;

import ar.com.facundobazan.models.Pedido;
import ar.com.facundobazan.vo.InformeDeVenta;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

    private EntityManager entityManager;

    public PedidoDAO(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void insert(Pedido pedido) {

        this.entityManager.persist(pedido);
    }

    public void update(Pedido pedido) {

        this.entityManager.merge(pedido);
    }

    public void delete(Pedido pedido) {

        pedido = this.entityManager.merge(pedido);
        this.entityManager.remove(pedido);
    }

    public Pedido findById(long id) {

        return this.entityManager.find(Pedido.class, id);
    }

    public List<Pedido> getAll() {

        // jpql -> java persistence query language
        String jqpl = "SELECT P Pedido AS P"; // No se utiliza el '*', se usa un token
        return this.entityManager.createQuery(jqpl, Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVendido(){

        return this.entityManager.createQuery(
                "SELECT SUM(P.valorTotal) FROM Pedidos AS P;",
                BigDecimal.class).getSingleResult();
    }

    public List<Object[]> informeDeVentas(){

        String spql = "SELECT producto.nombre, " +
                "SUM(item.cantidad), " +
                "MAX(P.fecha) " +
                "FROM Pedido AS P " +
                "JOIN P.items AS item " +
                "JOIN item.producto AS producto " +
                "GROUP BY producto.nombre " +
                "ORDER BY item.cantidad DESC;";
        return this.entityManager.createQuery(spql, Object[].class).getResultList();
    }

    public List<InformeDeVenta> informeDeVentasVO(){

        String spql = "SELECT new ar.com.facundobazan.vo.InformeDeVenta(producto.nombre, " +
                "SUM(item.cantidad), " +
                "MAX(P.fecha)) " +
                "FROM Pedido AS P " +
                "JOIN P.items AS item " +
                "JOIN item.producto AS producto " +
                "GROUP BY producto.nombre " +
                "ORDER BY item.cantidad DESC;";
        return this.entityManager.createQuery(spql, InformeDeVenta.class).getResultList();
    }
}
