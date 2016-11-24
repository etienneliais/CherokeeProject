package cherokees.jpa.manager;

import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransactionHelper {
	private static EntityManagerFactory instance = Persistence.createEntityManagerFactory("cherokee");

	private TransactionHelper() {
	}

	public static void close() {
		instance.close();
		instance = null;
	}

	public static <T> T transaction(Function<EntityManager, T> worker) {
		if (instance == null)
			throw new RuntimeException("Attention, l'EntityManagerFactory a déjà été fermé!");

		EntityManager em = instance.createEntityManager();
		try {
			em.getTransaction().begin();

			T result = worker.apply(em);

			em.getTransaction().commit();

			return result;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
}
