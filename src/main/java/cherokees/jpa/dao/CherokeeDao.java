package cherokees.jpa.dao;

import javax.persistence.EntityManager;

import cherokees.jpa.entities.organisation.Collaborator;
import cherokees.jpa.manager.EmFactory;

public class CherokeeDao {

	public Collaborator createOrUpdate(Collaborator collab) {
		System.out.println("collab is : "+collab);
		return EmFactory.transaction(em -> {

			if (collab.getId() != null) {
				Collaborator existing = this.findCollaboratorById(em, collab.getId());

				if (existing != null) {
					// update
					existing.setFirstName(collab.getFirstName());
					existing.setLastName(collab.getLastName());
					existing.setCodeAgency(collab.getCodeAgency());
					return existing;
				}
			}
			collab.setId(null);
			em.persist(collab);
			return collab;

		});
	}

	public Collaborator findCollaboratorById(EntityManager em, int Id) {
		return em.find(Collaborator.class, Id);
	}
}
