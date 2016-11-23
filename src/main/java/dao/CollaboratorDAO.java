package cherokees.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cherokees.jpa.entities.TrainingCollaborator;
import cherokees.jpa.entities.organisation.Collaborator;
import cherokees.jpa.manager.EmFactory;

public class CollaboratorDAO {

	public void createCollaborator(List<TrainingCollaborator> Collaborators) {

		EntityManager emCollab = EmFactory.createEntityManager();
		emCollab.getTransaction().begin();
		List<Collaborator> list = new ArrayList<Collaborator>();

		for (TrainingCollaborator collab : Collaborators) {
			Collaborator collaborator = new Collaborator();
			collaborator.setCodeAgency(collab.getCodeAgency());
			collaborator.setFirstName(collab.getFirstName());
			collaborator.setLastName(collab.getLastName());
			list.add(collaborator);

			Query q = emCollab.createQuery(
					"SELECT c FROM Collaborator c WHERE c.lastName=:lastName AND c.firstName=:firstName AND c.codeAgency=:codeAgency");
			q.setParameter("lastName", collab.getLastName());
			q.setParameter("firstName", collab.getFirstName());
			q.setParameter("codeAgency", collab.getCodeAgency());
			if (q.getResultList().isEmpty()) {
				emCollab.persist(collaborator);
			}
			;

		}

		emCollab.getTransaction().commit();
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + list);
		emCollab.close();

	}

}
