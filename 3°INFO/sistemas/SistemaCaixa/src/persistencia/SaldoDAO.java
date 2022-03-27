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
import vo.Saldo;
import vo.Movimento;

/**
 *
 * @author 2info2021
 */
public class SaldoDAO {

    EntityManager em;

    public SaldoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Saldo s, Movimento m) {
        em.getTransaction().begin();
        if (s.getId() == 0) {
            em.persist(s);
        } else {
            em.merge(s);
        }
        em.getTransaction().commit();
    }

    public boolean verificaData(Movimento m) {
        Calendar daters3 = m.getDataMov();
        Query q = em.createNativeQuery("select * from saldo where datasaldo = ?", Saldo.class);
        q.setParameter(1, daters3);
        List lista = q.getResultList();
        if (!lista.isEmpty()) {
            return true;
        } else {
            return false;
            //cria um saldo com esse dia que não existe, tem que ajeitar ainda
        }
    }

    public void somaSubtraiSaldo(Saldo s, Movimento m) {
        em.getTransaction().begin();
        double valor = m.getValor();
        s.setDataSaldo(m.getDataMov());
        if (m.getTipo().equals("E")) {
            Query q = em.createNativeQuery("update saldo set valor = valor+? where datasaldo>=?");
            q.setParameter(1, valor);
            q.setParameter(2, m.getDataMov());
            q.executeUpdate();
        } else {
            Query q = em.createNativeQuery("update saldo set valor = valor-? where datasaldo>=?");
            q.setParameter(1, valor);
            q.setParameter(2, m.getDataMov());
            q.executeUpdate();

        }

        em.getTransaction().commit();
    }

    public void somaSubtraiSaldo2(Saldo s, Movimento m) {
        em.getTransaction().begin();
        s.setDataSaldo(m.getDataMov()); // acho que não precisa dessa linha
        if (m.getTipo().equals("S")) {
            m.setValor(-m.getValor());
        }
        Query q = em.createNativeQuery("update saldo set valor = valor+? where datasaldo>=?");
        q.setParameter(1, m.getValor());
        q.setParameter(2, m.getDataMov());
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void somaSaldoAusente(Saldo s, Movimento m) {
        em.getTransaction().begin();
        if (m.getTipo().equals("S")) { //verifica se é saida ou entrada
            m.setValor(-m.getValor());
        }
        //pegador de valor da ultima data
        Query saldo = em.createNativeQuery("select valor from saldo where datasaldo<? order by datasaldo desc limit 1");
        saldo.setParameter(1, m.getDataMov());
        Object valorSaldo = saldo.getSingleResult();
        System.out.println(valorSaldo + "é o ultimo saldo");

        //criador de saldo
        s.setDataSaldo(m.getDataMov());
        s.setValor(m.getValor() + Double.parseDouble(valorSaldo.toString()));
        em.persist(s);

        //soma todas as datas maiores com a que esta sendo criada
        Query q = em.createNativeQuery("update saldo set valor = valor+? where datasaldo>?");
        q.setParameter(1, m.getValor());
        q.setParameter(2, m.getDataMov());
        q.executeUpdate();

        em.getTransaction().commit();
    }
}
