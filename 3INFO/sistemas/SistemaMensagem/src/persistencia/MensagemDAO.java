/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Calendar;
import java.util.List;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Usuario;
import vo.Mensagem;

public class MensagemDAO {

    EntityManager em;
    Usuario u = new Usuario();
    public MensagemDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Mensagem m) {
        em.getTransaction().begin();
        if (m.getId() == 0) {
            em.persist(m);
        } else {
            em.merge(m);
        }
        em.getTransaction().commit();
    }
    
    public Mensagem localiza(int id) {
        Mensagem m = em.find(Mensagem.class, id);
        return m;
    }

    public void excluiMensagem(Mensagem m) {
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }

    public List<Mensagem> pesquisa1(String dest) {
        Query q = em.createNativeQuery("select * from mensagem where destinatario = ?  order by data", Mensagem.class);
        q.setParameter(1, dest);
        List<Mensagem> lista = q.getResultList();
        return lista;
    }

    public List<Mensagem> pesquisa(String assunto) {
        Query q = em.createNativeQuery("select * from mensagem where assunto like ? order by id", Mensagem.class);
        q.setParameter(1, '%' + assunto + '%');
        List<Mensagem> lista = q.getResultList();
        return lista; 
    }
}
