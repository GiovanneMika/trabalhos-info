package persistencia;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Emprestimo;

public class EmprestimoDAO {

    EntityManager em;

    public EmprestimoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Emprestimo e) {
        em.getTransaction().begin();
        if (e.getId() == 0) {
            em.persist(e);
        } else {
            em.merge(e);
        }
        em.getTransaction().commit();
    }

    public Emprestimo localiza(int id) {
        Emprestimo e = em.find(Emprestimo.class, id);
        return e;
    }

    public void exclui(Emprestimo e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public List<Emprestimo> pesquisa() {
        Query q = em.createQuery("select e from Emprestimo as e");
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

    public List<Emprestimo> pesquisaAtrasos(Date dataatual) {
        Query q = em.createNativeQuery("select * from emprestimo where dataprevista < ? and emprestado=1 order by dataprevista ", Emprestimo.class);
        q.setParameter(1, dataatual);
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

    public List<Emprestimo> pesquisaAtivos() {
        Query q = em.createNativeQuery("select * from emprestimo where emprestado = 1 order by dataprevista ", Emprestimo.class);
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

    public List<Emprestimo> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from emprestimo where nome like ? order by nome ", Emprestimo.class);
        q.setParameter(1, '%' + nome + '%');
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

    public List<Emprestimo> pesquisaMaq(Integer idmaq) {
        Query q = em.createNativeQuery("select * from emprestimo where idmaquina = ? and emprestado=1 order by dataemprestimo", Emprestimo.class);
        q.setParameter(1, idmaq);
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

    public List<Emprestimo> pesquisaIdmaq(Integer idmaq) {
        Query q = em.createNativeQuery("select * from emprestimo where idmaquina = ? order by dataemprestimo", Emprestimo.class);
        q.setParameter(1, idmaq);
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

    public List<Emprestimo> pesquisaIdagri(Integer idagri) {
        Query q = em.createNativeQuery("select * from emprestimo where idagricultor = ? order by dataprevista ", Emprestimo.class);
        q.setParameter(1, idagri);
        List<Emprestimo> lista = q.getResultList();
        return lista;
    }

}
