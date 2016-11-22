package cherokees.jpa.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.cfg.CreateKeySecondPass;

import cherokees.jpa.business.CRUDService;
import cherokees.jpa.business.CherokeeService;
import cherokees.jpa.entities.TrainingCollaborator;
import cherokees.jpa.entities.organisation.Collaborator;
import cherokees.jpa.entities.organisation.Training;
import cherokees.jpa.entities.organisation.TrainingChoice;
import cherokees.jpa.manager.EmFactory;
import cherokees.jpa.dao.*;

public class Application {

	public static void main(String[] args) throws IOException {

		CherokeeDao cherokeeDao = new CherokeeDao();
		CollaboratorDAO collabDao = new CollaboratorDAO();
		TrainingDAO trainingDao = new TrainingDAO();
		TrainingChoiceDAO trainingChoiceDao = new TrainingChoiceDAO();
		CRUDService crud = new CRUDService();

		List<TrainingCollaborator> listImport = cherokeeDao.createTrainingCollaborator();
		List<Collaborator> listCollab = new ArrayList<>();
		List<Training> listTraining = new ArrayList<>();
		trainingDao.createTraining(listImport);
		collabDao.createCollaborator(listImport);
		trainingChoiceDao.createJoiningTable(listImport);

		// A ne pas toucher quoi qu'il arrive !!!
		EntityManager em = EmFactory.createEntityManager();
		em.getTransaction().begin();
		em.close();
		EmFactory.getInstance().close();
	}

}
