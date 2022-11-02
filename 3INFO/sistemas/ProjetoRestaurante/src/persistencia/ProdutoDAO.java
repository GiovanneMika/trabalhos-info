package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Produto;

public class ProdutoDAO {

    EntityManager em;

    public ProdutoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Produto p) {
        em.getTransaction().begin();
        if (p.getId() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Produto localiza(int id) {
        Produto p = em.find(Produto.class, id);
        return p;
    }

    public void exclui(Produto p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Produto> pesquisa() {
        Query q = em.createQuery("select p from Produto as p order by p.nome");
        List<Produto> lista = q.getResultList();
        return lista;
    }

    public List<Produto> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from produto where nome like ? order by nome ", Produto.class);
        q.setParameter(1, '%' + nome + '%');
        List<Produto> lista = q.getResultList();
        return lista;
    }

}
