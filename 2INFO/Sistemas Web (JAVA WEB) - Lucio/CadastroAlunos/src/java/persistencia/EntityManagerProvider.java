package persistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private EntityManagerProvider() {
    }

    public static EntityManagerFactory getEMF() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PU");
        }
        return emf;
    }

    public static EntityManager getEM() {
        if (em == null) {
            em = getEMF().createEntityManager();
        }
        return em;
    }
}
