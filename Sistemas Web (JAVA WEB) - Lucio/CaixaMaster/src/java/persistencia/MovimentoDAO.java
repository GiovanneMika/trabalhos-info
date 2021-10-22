/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Movimento;

public class MovimentoDAO {

    EntityManager em;

    public MovimentoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Movimento p) {
        em.getTransaction().begin();
        if (p.getId() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Movimento localiza(int codigo) {
        Movimento p = em.find(Movimento.class, codigo);
        return p;
    }

    public void exclui(Movimento p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Movimento> pesquisa() {
        Query q = em.createQuery("select p from Movimento p order by p.nome");
        List<Movimento> lista = q.getResultList();
        return lista;
    }

    public List<Movimento> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from movimento where nome like :nome order by nome", Movimento.class);
        q.setParameter("nome", '%' + nome + '%');
        List<Movimento> lista = q.getResultList();
        return lista;
    }
}
