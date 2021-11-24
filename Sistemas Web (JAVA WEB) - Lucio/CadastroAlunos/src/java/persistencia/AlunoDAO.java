/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Aluno;

/**
 *
 * @author 2info2021
 */
public class AlunoDAO {

    EntityManager em;

    public AlunoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Aluno a) {
        em.getTransaction().begin();
        if (a.getCodigo() == 0) {
            em.persist(a);
        } else {
            em.merge(a);
        }
        em.getTransaction().commit();
    }

    public Aluno localiza(int codigo) {
        Aluno a = em.find(Aluno.class, codigo);
        return a;
    }

    public void exclui(Aluno a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public List<Aluno> pesquisaAluno() {
        Query q = em.createQuery("select a from Aluno a order by a.nome");
        List<Aluno> listaAluno = q.getResultList();
        return listaAluno;
    }

    public List<Aluno> pesquisaAluno(Integer idFiliacao) {
        Query q = em.createQuery("select a from Aluno a where a.codigo = :codigo order by a.nome");
        q.setParameter("idFiliacao", idFiliacao);
        System.out.println(idFiliacao);
        List<Aluno> listaAluno = q.getResultList();
        return listaAluno;
    }
}
