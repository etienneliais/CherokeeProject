package cherokees.jpa.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import cherokees.jpa.entities.TrainingChoice;
import cherokees.jpa.manager.TransactionHelper;

public class TrainingChoiceDAO {
	/**
	 * @param listImported
	 * @return
	 */
	public TrainingChoice maybeAddTraineeChoice(TrainingChoice traineeChoice) {

		return TransactionHelper.transaction(em -> {

			try {

				Query q = em.createQuery("SELECT tc FROM TrainingChoice tc WHERE"
						+" ((:collaborator is null AND tc.collaborator is null) or (:collaborator is not null AND tc.collaborator= :collaborator))"
						+" AND ((:training is null AND tc.training is null) or (:training is not null AND tc.training= :training))")
						.setParameter("collaborator", traineeChoice.getCollaborator())
						.setParameter("training", traineeChoice.getTraining());
				return (TrainingChoice) q.getSingleResult();
			} catch (NoResultException e) {
				em.persist(traineeChoice);
				return traineeChoice;
			}

		});
	}
}
