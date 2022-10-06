/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Maquina;

public class MaquinaDAO {

    EntityManager em;

    public MaquinaDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Maquina a) {
        em.getTransaction().begin();
        if (a.getId() == 0) {
            em.persist(a);
        } else {
            em.merge(a);
        }
        em.getTransaction().commit();
    }

    public Maquina localiza(int id) {
        Maquina a = em.find(Maquina.class, id);
        return a;
    }

    public void exclui(Maquina a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public List<Maquina> pesquisa() {
        Query q = em.createQuery("select a from Maquina as a order by a.nome");
        List<Maquina> lista = q.getResultList();
        return lista;
    }

    public List<Maquina> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from agricultor where nome like ? order by nome ", Maquina.class);
        q.setParameter(1, '%' + nome + '%');
        List<Maquina> lista = q.getResultList();
        return lista;
    }
    

}

