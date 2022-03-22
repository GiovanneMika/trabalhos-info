/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Date;
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

    public boolean verificaData() {
        String daters = "2022-03-17";
        Query q = em.createNativeQuery("select * from saldo where data = ?", Saldo.class);
        q.setParameter(1, daters);
        List lista = q.getResultList();
        if (!lista.isEmpty()) {
            System.out.println("Exiteste");
            return true;
        } else {
            System.out.println("Nao existe");
            //cria um saldo com esse dia que não existe, tem que ajeitar ainda
        }
        return false;
    }

    public void somaSaldoExistente(Saldo s, Movimento m) {
        double valor = m.getValor();
        double quantidadeInicial = s.getValor();
        double quantidadeFinal = quantidadeInicial + valor;
        s.setValor(quantidadeFinal);
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    /* public void criaSaldo(Movimento m) {
        em.getTransaction().begin();
        if (m.getDataMov() == 0) {
            em.persist(m);
        }else{
            em.merge(m);
        }
        em.getTransaction().commit();
    }*/
}
