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

    public void salva(Responsavel r) {
        em.getTransaction().begin();
        if (r.getId() == 0) {
            em.persist(r);
        } else {
            em.merge(r);
        }
        em.getTransaction().commit();
    }

    public Responsavel localiza(int id) {
        Responsavel r = em.find(Responsavel.class, id);
        return r;
    }

    public void exclui(Responsavel r) {
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
    }

    public List<Responsavel> pesquisa() {
        Query q = em.createQuery("select r from Responsavel r order by r.id");
        List<Responsavel> lista = q.getResultList();
        return lista;
    }
}
