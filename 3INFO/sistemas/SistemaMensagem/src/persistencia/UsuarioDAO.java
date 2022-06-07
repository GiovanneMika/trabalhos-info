/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Usuario;

/**
 *
 * @author 2info2021
 */
public class UsuarioDAO {
    EntityManager em;

    public UsuarioDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Usuario u) {
        em.getTransaction().begin();
        if (u.getUsuario() == null) {
            em.persist(u);
        } else {
            em.merge(u);
        }
        em.getTransaction().commit();
    }
    
    public Usuario localiza(int id) {
        Usuario m = em.find(Usuario.class, id);
        return m;
    }

    public void excluiUsuario(Usuario u) {
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }

    public List<Usuario> pesquisa() {
        Query q = em.createQuery("select f from Usuario as f order by f.nome");
        List<Usuario> lista = q.getResultList();
        return lista;
    }

    public List<Usuario> pesquisa(String assunto) {
        Query q = em.createNativeQuery("select * from mensagem where assunto like ? order by nome ", Usuario.class);
        q.setParameter(1, '%' + assunto + '%');
        List<Usuario> lista = q.getResultList();
        return lista; 
    }
}
