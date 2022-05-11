package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Funcionario;
import vo.Tabela;

public class FuncionarioDAO {

    EntityManager em;

    public FuncionarioDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Funcionario f) {
        em.getTransaction().begin();
        if (f.getMatricula() == 0) {
            em.persist(f);
        } else {
            em.merge(f);
        }
        em.getTransaction().commit();
    }

    public void salvaTabela(Tabela t) {
        em.getTransaction().begin();
        if (t.getId() == 0) {
            em.persist(t);
        } else {
            em.merge(t);
        }
        em.getTransaction().commit();
    }

    public Funcionario localiza(int codigo) {
        Funcionario f = em.find(Funcionario.class, codigo);
        return f;
    }

    public Tabela localizaTabela(int id) {
        Tabela t = em.find(Tabela.class, id);
        return t;
    }

    public void exclui(Funcionario f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    public List<Funcionario> pesquisa() {
        Query q = em.createQuery("select f from Funcionario as f order by f.nome");
        List<Funcionario> lista = q.getResultList();
        return lista;
    }

    public List<Funcionario> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from funcionario where nome like ? order by nome ", Funcionario.class);
        q.setParameter(1, '%' + nome + '%');
        List<Funcionario> lista = q.getResultList();
        return lista;
    }

}
