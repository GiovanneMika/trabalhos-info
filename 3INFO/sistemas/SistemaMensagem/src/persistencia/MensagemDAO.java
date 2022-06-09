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

    public List<Mensagem> pesquisa() {
        Query q = em.createQuery("select f from Mensagem as f order by f.nome");
        List<Mensagem> lista = q.getResultList();
        return lista;
    }

    public List<Usuario> pesquisa(String assunto) {
        Query q = em.createNativeQuery("select * from mensagem where assunto like ? order by id", Usuario.class);
        q.setParameter(1, '%' + assunto + '%');
        List<Usuario> lista = q.getResultList();
        return lista; 
    }
}
