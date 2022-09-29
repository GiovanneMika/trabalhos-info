package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Agricultor;

public class AgricultorDAO {

    EntityManager em;

    public AgricultorDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Agricultor a) {
        em.getTransaction().begin();
        if (a.getId() == 0) {
            em.persist(a);
        } else {
            em.merge(a);
        }
        em.getTransaction().commit();
    }

    public Agricultor localiza(int id) {
        Agricultor a = em.find(Agricultor.class, id);
        return a;
    }

    public void exclui(Agricultor a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public List<Agricultor> pesquisa() {
        Query q = em.createQuery("select a from Agricultor as a order by a.nome");
        List<Agricultor> lista = q.getResultList();
        return lista;
    }

    public List<Agricultor> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from agricultor where nome like ? order by nome ", Agricultor.class);
        q.setParameter(1, '%' + nome + '%');
        List<Agricultor> lista = q.getResultList();
        return lista;
    }

}
