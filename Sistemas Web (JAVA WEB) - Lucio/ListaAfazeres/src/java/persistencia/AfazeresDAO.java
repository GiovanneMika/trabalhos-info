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

    public Afazeres localiza(int codigo) {
        Afazeres p = em.find(Afazeres.class, codigo);
        return p;
    }

    public void exclui(Afazeres a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public List<Afazeres> pesquisa() {
        Query q = em.createQuery("select p from Afazeres p order by p.nome");
        List<Afazeres> lista = q.getResultList();
        return lista;
    }

    public List<Afazeres> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from Afazeres where nome like :nome order by nome", Afazeres.class);
        q.setParameter("nome", '%' + nome + '%');
        List<Afazeres> lista = q.getResultList();
        return lista;
    }
}
