/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void somaSaldoExistente(Saldo s, Movimento m) {
        double valor = m.getValor(); //precisa de uma variavel que receba a data pra conseguir jogar o valor no saldo certo
        s.setDataSaldo(m.getDataMov());
        //Query q = em.createNativeQuery("select valor from saldo where data = ?", Saldo.class);
        //q.setParameter(1, daters3);
        //List valorSaldo = q.getResultList();
        //System.out.println(valorSaldo);
        double quantidadeInicial = 0;
        double quantidadeFinal;
        if (m.getTipo() == "S") {
            quantidadeFinal = quantidadeInicial - valor;
        } else {
            quantidadeFinal = quantidadeInicial + valor;
        }
        s.setValor(quantidadeFinal);
        em.createNativeQuery("select valor from saldo where data = ?", Saldo.class);
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
