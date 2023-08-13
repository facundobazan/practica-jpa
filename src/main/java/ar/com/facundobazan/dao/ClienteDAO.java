package ar.com.facundobazan.dao;

import ar.com.facundobazan.models.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDAO {

    private final EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void insert(Cliente cliente) {

        this.entityManager.persist(cliente);
    }

    public void update(Cliente cliente) {

        this.entityManager.merge(cliente);
    }

    public void delete(Cliente cliente) {

        cliente = this.entityManager.merge(cliente);
        this.entityManager.remove(cliente);
    }

    public Cliente findById(long id) {

        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> getAll() {

        // jpql -> java persistence query language
        String jqpl = "SELECT C Cliente AS C"; // No se utiliza el '*', se usa un token
        return this.entityManager.createQuery(jqpl, Cliente.class).getResultList();
    }

    public List<Cliente> findByName(String string) {

        String jpql = "SELECT C FROM Cliente AS C WHERE C.nombre = :string";
        return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nombre", string).getResultList();
    }
}
