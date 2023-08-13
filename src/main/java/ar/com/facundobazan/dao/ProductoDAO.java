package ar.com.facundobazan.dao;

import ar.com.facundobazan.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductoDAO {

    private final EntityManager entityManager;

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

        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre = :string";
        return this.entityManager.createQuery(jpql, Producto.class).setParameter("nombre", string).getResultList();
    }

    public BigDecimal getPriceByProductName(String string) {

        return this.entityManager.createNamedQuery("Producto.consultaDePrecio", BigDecimal.class).setParameter("nombre", string).getSingleResult();
    }

    public List<Producto> consultarPorParametros(String nombre, String descripcion, BigDecimal precio, LocalDate fechaDeRegistro) {

        StringBuilder jpql = new StringBuilder("SELECT P FROM Producto P WHERE 1 = 1");
        TypedQuery<Producto> query = this.entityManager.createQuery(jpql.toString(), Producto.class);

        if (!nombre.isBlank()) {

            jpql.append(" AND p.nombre = :nombre");
            query.setParameter("nombre", nombre);
        }

        if (!descripcion.isBlank()) {

            jpql.append(" AND p.descripcion = :descripcion");
            query.setParameter("descripcion", descripcion);
        }
        if (precio != null && !precio.equals(new BigDecimal(0))) {

            jpql.append(" AND p.precio = :precio");
            query.setParameter("precio", precio);
        }
        if (fechaDeRegistro != null) {

            jpql.append(" AND p.fechaDeRegistro = :fechaDeRegistro");
            jpql.append(" AND p.fechaDeRegistro = :fechaDeRegistro");
        }

        return query.getResultList();
    }
}
