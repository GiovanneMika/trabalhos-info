/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
