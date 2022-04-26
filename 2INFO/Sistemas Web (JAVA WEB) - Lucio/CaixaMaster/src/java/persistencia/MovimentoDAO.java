/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Movimento;

public class MovimentoDAO {

    EntityManager em;

    public MovimentoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Movimento m) {
        em.getTransaction().begin();
        if (m.getId() == 0) {
            em.persist(m);
        } else {
            em.merge(m);
        }
        em.getTransaction().commit();
    }

    public Movimento localiza(int id) {
        Movimento m = em.find(Movimento.class, id);
        return m;
    }

    public List<Movimento> pesquisa() {
        Query q = em.createQuery("select m from Movimento m order by m.data");
        List<Movimento> lista = q.getResultList();
        return lista;
    }

    public List<Movimento> pesquisaSaida() {
        Query q = em.createQuery("select m from Movimento m where m.tipo = 'saida' order by m.data");
        List<Movimento> lista = q.getResultList();
        return lista;
    }

    public List<Movimento> pesquisaEntrada() {
        Query q = em.createQuery("select m from Movimento m where m.tipo = 'entrada' order by m.data");
        List<Movimento> lista = q.getResultList();
        return lista;

    }

    public Double calcularSaldo() {
        Double entradas = calcularSaldoEntradas();
        Double saidas = calcularSaldoSaidas();
        Double saldo = entradas - saidas;
        return saldo;
    }

    public Double calcularSaldoEntradas() {
        Query q = em.createNativeQuery("select SUM(valor) from movimento where tipo = 'Entrada'");
        List<Double> lista = q.getResultList();
        Double saldo;
        if (lista.get(0) != null) {
            saldo = lista.get(0);
        } else {
            saldo = 0.0;
        }
        return saldo;
    }

    public Double calcularSaldoSaidas() {
        Query q = em.createNativeQuery("select SUM(valor) from movimento where tipo = 'Saida'");
        List<Double> lista = q.getResultList();
        Double saldo;
        if (lista.get(0) != null) {
            saldo = lista.get(0);
        } else {
            saldo = 0.0;
        }
        return saldo;
    }
}
