/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 2info2021
 */
public class EntityManagerProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private EntityManagerProvider() {
    }

    public static EntityManagerFactory getEMF() {
        if (emf == null) {
            Properties prop = new Properties();
            prop.setProperty("javax.persistence.jdbc.url", "jdbc:mysql://localhost/restaurante");
            prop.setProperty("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            prop.setProperty("javax.persistence.jdbc.password", "vertrigo");
            prop.setProperty("javax.persistence.jdbc.user", "root");
            emf = Persistence.createEntityManagerFactory("ProjetoRestaurantePU", prop);
        }
        return emf;
    }

    public static EntityManager getEM() {
        if (em == null) {
            em = getEMF().createEntityManager();

        }
        return em;
    }

    public static void reset() {
        emf = null;
        em = null;
    }
}
