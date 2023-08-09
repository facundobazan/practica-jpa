package ar.com.facundobazan.dao;

import ar.com.facundobazan.models.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDAO {

    private EntityManager entityManager;

    public ProductoDAO(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void insert(Producto producto) {

        this.entityManager.persist(producto);
    }

    public void update(Producto producto) {

        this.entityManager.merge(producto);
    }

    public void delete(Producto producto) {

        producto = this.entityManager.merge(producto);
        this.entityManager.remove(producto);
    }

    public Producto findById(long id) {

        return this.entityManager.find(Producto.class, id);
    }

    public List<Producto> getAll() {

        // jpql -> java persistence query language
        String jqpl = "SELECT P Poducto AS P"; // No se utiliza el '*', se usa un token
        return this.entityManager.createQuery(jqpl, Producto.class).getResultList();
    }

    public List<Producto> findByName(String string) {

        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre = :string;";
        return this.entityManager.createQuery(jpql, Producto.class).setParameter("nombre", string).getResultList();
    }

    public BigDecimal getPriceByProductName(String string) {

        String jpql = "SELECT P.precio FROM Producto AS P WHERE P.nombre = :string;";
        return this.entityManager.createQuery(jpql, BigDecimal.class).setParameter("nombre", string).getSingleResult();
    }
}
