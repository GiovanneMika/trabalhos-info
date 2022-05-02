package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Funcionario;

public class FuncionarioDAO {

    EntityManager em;

    public FuncionarioDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Funcionario f) {
        em.getTransaction().begin();
        if (f.getId() == 0) {
            em.persist(f);
        } else {
            em.merge(f);
        }
        em.getTransaction().commit();
    }

    public Funcionario localiza(int codigo) {
        Funcionario p = em.find(Funcionario.class, codigo);
        return p;
    }

    public void exclui(Funcionario f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    public List<Funcionario> pesquisa() {
        Query q = em.createQuery("select p from Funcionario as p order by p.nome");
        List<Funcionario> lista = q.getResultList();
        return lista;
    }

    public List<Funcionario> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from professor where nome like ? order by nome ", Funcionario.class);
        q.setParameter(1, '%' + nome + '%');
        List<Funcionario> lista = q.getResultList();
        return lista;
    }
}
