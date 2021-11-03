/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Responsavel;

/**
 *
 * @author 2info2021
 */
public class ResponsavelDAO {

    EntityManager em;

    public ResponsavelDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Responsavel p) {
        em.getTransaction().begin();
        if (p.getId() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Responsavel localiza(int codigo) {
        Responsavel p = em.find(Responsavel.class, codigo);
        return p;
    }

    public void exclui(Responsavel p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Responsavel> pesquisa() {
        Query q = em.createQuery("select p from Responsavel p order by p.nome");
        List<Responsavel> lista = q.getResultList();
        return lista;
    }
}
