package ar.com.facundobazan.dao;

import ar.com.facundobazan.models.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void insert(Categoria categoria) {

        this.entityManager.persist(categoria);
    }

    public void update(Categoria categoria){

        this.entityManager.merge(categoria);
    }

    public void delete(Categoria categoria){

        categoria = this.entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

    public Categoria findById(long id){

        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> getAll(){

        // jpql -> java persistence query language
        String jqpl = "SELECT C Categoria AS C"; // No se utiliza el '*', se usa un token
        return this.entityManager.createQuery(jqpl, Categoria.class).getResultList();
    }
}
