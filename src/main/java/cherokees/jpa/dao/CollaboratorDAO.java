package cherokees.jpa.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import cherokees.jpa.entities.Collaborator;
import cherokees.jpa.manager.TransactionHelper;

public class CollaboratorDAO {
	public Collaborator maybeAddCollab(Collaborator collab) {
		return TransactionHelper.transaction(em -> {
			try {
				Query q = em.createQuery("SELECT c FROM Collaborator c WHERE"
						+ " ((:lastName is null AND c.lastName is null) or (:lastName is not null AND c.lastName= :lastName))"
						+ " AND ((:firstName is null AND c.firstName is null) or (:firstName is not null AND c.firstName= :firstName))"
						+ " AND ((:codeAgency is null AND c.codeAgency is null) or (:codeAgency is not null AND c.codeAgency= :codeAgency))");
				q.setParameter("lastName", collab.getLastName());
				q.setParameter("firstName", collab.getFirstName());
				q.setParameter("codeAgency", collab.getCodeAgency());

				return (Collaborator) q.getSingleResult();
			} catch (NoResultException e) {

				em.persist(collab);
				return collab;
			}
		});
	}
}
