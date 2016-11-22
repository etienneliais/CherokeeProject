package cherokees.jpa.manager;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface EmWorker {
	
	public void work(EntityManager em);
	
}
