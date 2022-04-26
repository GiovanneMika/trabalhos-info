/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Movimento;

/**
 *
 * @author 2info2021
 */
public class MovimentoDAO {

    EntityManager em;

    public MovimentoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Movimento m) {
        em.getTransaction().begin();
        if (m.getId() == 0) {
            em.persist(m);
        }
        em.getTransaction().commit();
    }

    public Movimento localiza(int id) {
        Movimento m = em.find(Movimento.class, id);
        return m;
    }

    public List<Movimento> pesquisa() {
        Query q = em.createQuery("select m from Movimento as m order by m.dataMov");
        List<Movimento> lista = q.getResultList();
        return lista;
    }

    public List<Movimento> pesquisa(String descricao) {
        Query q = em.createNativeQuery("select * from movimento where descricao like ? order by descricao", Movimento.class);
        q.setParameter(1, '%' + descricao + '%');
        List<Movimento> lista = q.getResultList();
        return lista;
    }
    public List<Movimento> filtroMovimento(Calendar dataM1, Calendar dataM2){
        Query q = em.createNativeQuery("select * from movimento where datamov between ? and ? order by datamov ", Movimento.class);
        q.setParameter(1, dataM1);
        q.setParameter(2, dataM2);
        List<Movimento> lista = q.getResultList();
        return lista;
    }
}
