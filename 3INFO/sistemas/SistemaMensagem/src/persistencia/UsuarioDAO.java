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

    public boolean verificaLoginUsuario(String usuario, String senha) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("select * from Usuario where usuario like ? ");
        q.setParameter(1, usuario);
        Query q1 = em.createQuery("select * from Usuario where senha like ? ");
        q1.setParameter(1, senha);
        if (!q.getResultList().isEmpty() && !q1.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaLoginAdm(String usuario, String senha) {
        if (usuario.equalsIgnoreCase("Admin") && senha.equals("Admin")) {
            return true;
        } else {
            return false;
        }
    }

    public List<Usuario> pesquisa() {
        Query q = em.createQuery("select u from Usuario as u order by u.usuario");
        List<Usuario> lista = q.getResultList();
        return lista;
    }
    public Object pesquisaUsuario(String usuario, String senha){
        Query q = em.createNativeQuery("select * from Usuario where usuario = ? and senha = ? ");
        q.setParameter(1,usuario);
        q.setParameter(2,senha);
        return q.getSingleResult();
    }

    public List<Usuario> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from Usuario where nome like ? order by nome ", Usuario.class);
        q.setParameter(1, '%' + nome + '%');
        List<Usuario> lista = q.getResultList();
        return lista;
    }

}
