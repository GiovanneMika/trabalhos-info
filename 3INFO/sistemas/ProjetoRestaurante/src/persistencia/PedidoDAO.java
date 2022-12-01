/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Pedido;

/**
 *
 * @author pcnov
 */
public class PedidoDAO {

    EntityManager em;

    public PedidoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Pedido p) {
        em.getTransaction().begin();
        if (p.getId() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Pedido localiza(int id) {
        Pedido p = em.find(Pedido.class, id);
        return p;
    }

    public void exclui(Pedido p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Pedido> pesquisa() {
        Query q = em.createQuery("select p from Pedido as p order by p.estado");
        List<Pedido> lista = q.getResultList();
        return lista;
    }

    public List<Pedido> pesquisaPedido(int idmesa) {
        Query q = em.createNativeQuery("select * from pedido where idmesa=? and estado=? order by estado ", Pedido.class);
        q.setParameter(1, idmesa);
        q.setParameter(2, "Entregue");
        List<Pedido> lista = q.getResultList();
        return lista;
    }

    public List<Pedido> pesquisaPedidoCozinha() {
        Query q = em.createNativeQuery("select * from pedido where estado=? or estado=? order by estado ", Pedido.class);
        q.setParameter(1, "Pendente");
        q.setParameter(2, "Preparando");
        List<Pedido> lista = q.getResultList();
        return lista;
    }

    public List<Pedido> pesquisaPedidoPendente() {
        Query q = em.createNativeQuery("select * from pedido where estado=? order by estado ", Pedido.class);
        q.setParameter(1, "Pendente");
        List<Pedido> lista = q.getResultList();
        return lista;
    }

    public List<Pedido> pesquisaPedidoPreparando() {
        Query q = em.createNativeQuery("select * from pedido where estado=? order by estado ", Pedido.class);
        q.setParameter(1, "Preparando");
        List<Pedido> lista = q.getResultList();
        return lista;
    }

    public List<Pedido> pesquisaPedidoPronto() {
        Query q = em.createNativeQuery("select * from pedido where estado=? order by estado ", Pedido.class);
        q.setParameter(1, "Pronto");
        List<Pedido> lista = q.getResultList();
        return lista;
    }
}
