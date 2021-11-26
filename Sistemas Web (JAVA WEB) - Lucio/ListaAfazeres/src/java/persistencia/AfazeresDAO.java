/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Afazeres;

public class AfazeresDAO {

    EntityManager em;

    public AfazeresDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Afazeres a) {
        em.getTransaction().begin();
        if (a.getId() == 0) {
            em.persist(a);
        } else {
            em.merge(a);
        }
        em.getTransaction().commit();
    }

    public Afazeres localiza(int id) {
        Afazeres a = em.find(Afazeres.class, id);
        return a;
    }

    public void exclui(Afazeres a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public List<Afazeres> pesquisa() {
        Query q = em.createQuery("select a from Afazeres a order by a.id");
        List<Afazeres> lista = q.getResultList();
        return lista;
    }

    public List<Afazeres> pesquisaPrimeiro() {
        Query q = em.createQuery("select a from Afazeres a order by a.id");
        List<Afazeres> lista = q.getResultList();
        return lista;
    }

    public List<Afazeres> pesquisa(String descricao) {
        Query q = em.createNativeQuery("select * from Afazeres where descricao like :descricao order by id", Afazeres.class);
        q.setParameter("descricao", '%' + descricao + '%');
        List<Afazeres> lista = q.getResultList();
        return lista;
    }
}
