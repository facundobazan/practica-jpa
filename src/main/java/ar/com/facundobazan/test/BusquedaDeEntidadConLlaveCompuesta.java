package ar.com.facundobazan.test;

import ar.com.facundobazan.models.CategoriaConLlaveCompuesta;
import ar.com.facundobazan.models.CategoriaId;
import ar.com.facundobazan.utils.JPAUtil;

public class BusquedaDeEntidadConLlaveCompuesta {

    public static void main(String[] args) {
        /*Categoria celulares = new Categoria("Celulares");
        Producto celular = new Producto("Samsung", "Telefono usado", new BigDecimal(1000), celulares);

        EntityManager manager = JPAUtil.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(manager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(manager);

        manager.getTransaction().begin();

        categoriaDAO.insert(celulares);
        productoDAO.insert(celular);

        manager.getTransaction().commit();
        manager.close();*/

        //  Buscar una entidad con llave compuesta
        JPAUtil.getEntityManager().find(CategoriaConLlaveCompuesta.class, new CategoriaId("nombre", "password"));
    }
}
