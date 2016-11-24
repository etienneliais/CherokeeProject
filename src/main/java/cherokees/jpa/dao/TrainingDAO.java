package cherokees.jpa.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import cherokees.jpa.entities.Training;
import cherokees.jpa.manager.TransactionHelper;

public class TrainingDAO {
	public Training maybeAddTrainee(Training trainee) {

		return TransactionHelper.transaction(em -> {

			try {
				Query q = em.createQuery(
						"SELECT t FROM Training t WHERE"
						+" ((:nbDays is null AND t.nbDays is null) or (:nbDays is not null AND t.nbDays= :nbDays))"
						+" AND ((:place is null AND t.place is null) or (:place is not null AND t.place= :place))"
						+" AND ((:trainingName is null AND t.trainingName is null) or (:trainingName is not null AND t.trainingName= :trainingName ))"
						+" AND ((:dueDate is null AND t.dueDate is null) or (:dueDate is not null AND t.dueDate= :dueDate))"
						+" AND ((:realDate is null AND t.realDate is null) or (:realDate is not null AND t.realDate= :realDate))"
						+" AND ((:provider is null AND t.provider is null) or (:provider is not null AND t.provider= :provider))");
				q.setParameter("nbDays", trainee.getNbDays());
				q.setParameter("place", trainee.getPlace());
				q.setParameter("trainingName", trainee.getTrainingName());
				q.setParameter("dueDate", trainee.getDueDate());
				q.setParameter("realDate", trainee.getRealDate());
				q.setParameter("provider", trainee.getProvider());
				return (Training) q.getSingleResult();
			} catch (NoResultException e) {
				em.persist(trainee);

				return trainee;
			}

		});
	}
}