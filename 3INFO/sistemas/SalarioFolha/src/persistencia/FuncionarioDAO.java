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

    public void salvaINSS(Tabela t) {
        em.getTransaction().begin(); //talvez compense criar um objeto para o inss, irrf e salario familia, em classes separadas
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

    public Object preencheINSS(Tabela t) {
        //setador de teto INSS

        Query preenchedor = em.createQuery("select t.tinss1, t.tinss2, t.tinss3, t.tinss4, t.ainss1, t.ainss2, t.ainss3, t.ainss4  from Tabela as t");
        return preenchedor;
    }
}
