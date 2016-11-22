package cherokees.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cherokees.jpa.entities.TrainingCollaborator;
import cherokees.jpa.entities.organisation.Training;
import cherokees.jpa.manager.EmFactory;

public class TrainingDAO {
	public void createTraining(List<TrainingCollaborator> Collaborators) {

		EntityManager emtrainee = EmFactory.createEntityManager();
		emtrainee.getTransaction().begin();
		List<Training> list = new ArrayList<Training>();

		for (TrainingCollaborator collab : Collaborators) {
			Training trainee = new Training();
			trainee.setNbDays(collab.getNbDays());
			trainee.setPlace(collab.getPlace());
			trainee.setTrainingName(collab.getTrainingName());
			trainee.setDueDate(collab.getDueDate());
			trainee.setRealDate(collab.getRealDate());
			trainee.setProvider(collab.getProvider());
			list.add(trainee);
			// emtrainee.persist(trainee);
			Query q = emtrainee.createQuery(
					"SELECT t FROM Training t WHERE t.nbDays=:nbDays AND t.place=:place AND t.trainingName=:trainingName AND t.dueDate=:dueDate AND t.realDate=:realDate AND t.provider=:provider");
			q.setParameter("nbDays", collab.getNbDays());
			q.setParameter("place", collab.getPlace());
			q.setParameter("trainingName", collab.getTrainingName());
			q.setParameter("dueDate", collab.getDueDate());
			q.setParameter("realDate", collab.getRealDate());
			q.setParameter("provider", collab.getProvider());
			if (q.getResultList().isEmpty()) {
				emtrainee.persist(trainee);

			}
			;

		}
		emtrainee.getTransaction().commit();
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + list);
		emtrainee.close();
	}

}
