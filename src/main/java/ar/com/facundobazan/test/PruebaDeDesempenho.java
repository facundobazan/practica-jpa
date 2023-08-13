package ar.com.facundobazan.test;

import ar.com.facundobazan.dao.PedidoDAO;
import ar.com.facundobazan.models.Pedido;
import ar.com.facundobazan.utils.JPAUtil;

import javax.persistence.EntityManager;

public class PruebaDeDesempenho {

    public static void main(String[] args) {

        //  LoadRecords.cargarRegistros();
        EntityManager entityManager = JPAUtil.getEntityManager();

        PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
        Pedido pedido = pedidoDAO.consultarPedidoConCliente(1L);

        entityManager.close();

        System.out.println(pedido.getCliente().getNombre());    //  No es traído por el cierre de la conexión y el lazy
        //  loader, se soluciona usando el JOIN FETCH en la consulta.
    }
}