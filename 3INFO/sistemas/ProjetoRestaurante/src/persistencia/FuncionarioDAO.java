/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Funcionario localiza(int id) {
        Funcionario f = em.find(Funcionario.class, id);
        return f;
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

    public List<Funcionario> pesquisaUsuario(String usuario) {
        Query q = em.createNativeQuery("select * from funcionario where usuario like ? order by usuario ", Funcionario.class);
        q.setParameter(1, usuario);
        List<Funcionario> lista = q.getResultList();
        return lista;
    }

    public boolean verificaFuncionarioExistente(String usuario) {
        Query q = em.createNativeQuery("select * from funcionario where usuario like ? ");
        q.setParameter(1, usuario);
        if (!q.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaLoginUsuario(String usuario, String senha) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("select * from Funcionario where usuario like ? ");
        q.setParameter(1, usuario);
        Query q1 = em.createNativeQuery("select * from Funcionario where senha like ? ");
        q1.setParameter(1, senha);
        if (!q.getResultList().isEmpty() && !q1.getResultList().isEmpty()) {
            em.getTransaction().commit();
            return true;
        } else {
            em.getTransaction().commit();
            return false;
        }
    }
}
