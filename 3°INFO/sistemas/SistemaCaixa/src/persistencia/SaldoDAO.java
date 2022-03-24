/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Calendar;
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

    public boolean verificaData(Movimento m) {
        String daters = "2022-03-17";
        Calendar daters3 = m.getDataMov();
        Query q = em.createNativeQuery("select * from saldo where data = ?", Saldo.class);
        q.setParameter(1, daters);
        List lista = q.getResultList();
        if (!lista.isEmpty()) {
            System.out.println("Exiteste");
            return true;
        } else {
            System.out.println("Nao existe");
            return false;
            //cria um saldo com esse dia que não existe, tem que ajeitar ainda
        }
    }

    public void somaSaldoExistente(Saldo s, Movimento m) {
        double valor = m.getValor(); //precisa de uma variavel que receba a data pra conseguir jogar o valor no saldo certo
        double quantidadeInicial = s.getValor();
        double quantidadeFinal = quantidadeInicial + valor;
        s.setValor(quantidadeFinal);
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    public void somaSaldoQueNaoExistiaAntes(Saldo s, Movimento m) {
        //tem que criar primeiro um saldo com valor zero e mesmo dia do movimento criado
        //
        
        //perguntar pro lucio como faz pra pegar só um valor do banco de dados
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
