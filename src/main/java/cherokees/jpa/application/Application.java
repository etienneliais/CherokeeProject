package cherokees.jpa.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.cfg.CreateKeySecondPass;

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
		List<TrainingCollaborator> listBadass = service.createTrainingCollaborator();
		service.createTraining(listBadass);
		service.createCollaborator(listBadass);
		
		
		//Collaborator collaborator = new Collaborator();
		//Training training = new Training();
		//TrainingChoice trainingChoice = new TrainingChoice();
		

	}

}
