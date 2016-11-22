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
		
		CherokeeService service = new CherokeeService();
		CRUDService crud = new CRUDService();

		List<TrainingCollaborator> listImport = service.createTrainingCollaborator();
		List<Collaborator> listCollab = new ArrayList<>();
		List<Training> listTraining = new ArrayList<>();
		service.createTraining(listImport);
		service.createCollaborator(listImport);
		//service.createJoiningTable(listCollab, listTraining);
		EntityManager em = EmFactory.createEntityManager();
		em.getTransaction().begin();
		em.close();
		EmFactory.getInstance().close();
		
		
		
		
		
		//System.out.println("All : " + crud.findAllCollaborators());
		// Collaborator collaborator = new Collaborator();
		// Training training = new Training();
		// TrainingChoice trainingChoice = new TrainingChoice();
		
	}

}
