package cherokees.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cherokees.jpa.entities.TrainingCollaborator;
import cherokees.jpa.entities.organisation.Collaborator;
import cherokees.jpa.entities.organisation.Training;
import cherokees.jpa.entities.organisation.TrainingChoice;
import cherokees.jpa.manager.EmFactory;

public class TrainingChoiceDAO {
	public void createJoiningTable(List<TrainingCollaborator> trainingCollaborators) {

		EntityManager emJoin = EmFactory.createEntityManager();
		emJoin.getTransaction().begin();
		List<TrainingChoice> listTrainingChoice = new ArrayList<>();

		for (TrainingCollaborator collab : trainingCollaborators) {
			TrainingChoice trainingChoice = new TrainingChoice();

			Query q = emJoin.createQuery("select c from Collaborators c where c.lastName=:lastName"); // AND
																										// c.firstName=:firstName
																										// AND
																										// c.codeAgency=:codeAgency");
			q.setParameter("firtName", collab.getFirstName());
			// q.setParameter("lastName",collab.getLastName());
			// q.setParameter("codeAgency",collab.getCodeAgency());
			Collaborator collabo = (Collaborator) q.getSingleResult();
			trainingChoice.setCollaborator(collabo);

			Query q2 = emJoin.createQuery("select t Training t WHERE t.trainingName=:trainingName"); // t.nbDays=:nbDays
																										// AND
																										// t.place=:place
																										// AND
																										// t.trainingName=:trainingName
																										// AND
																										// t.dueDate=:dueDate
																										// AND
																										// t.realDate=:realDate
																										// AND
																										// t.provider=:provider");
			q2.setParameter("nbDays", collab.getNbDays());
			// q2.setParameter("place", collab.getPlace());
			// q2.setParameter("trainingName", collab.getTrainingName());
			// q2.setParameter("dueDate", collab.getDueDate());
			// q2.setParameter("realDate", collab.getRealDate());
			// q2.setParameter("provider", collab.getProvider());
			Training train = (Training) q2.getSingleResult();
			trainingChoice.setTraining(train);

			listTrainingChoice.add(trainingChoice);

			/*
			 * Query q = emJoin.createQuery(
			 * "SELECT k FROM trainingChoice k WHERE k.collaborator=:collaborator AND k.training=:training"
			 * ); k.setParameter("collaborator",
			 * trainingChoice.getCollaborator()); k.setParameter("training",
			 * trainingChoice.getTraining()); if (k.getResultList().isEmpty()) {
			 */
			emJoin.persist(trainingChoice);

			// };

		}
		emJoin.getTransaction().commit();
		emJoin.close();
	}

}
