package cherokees.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TrainingChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@ManyToOne
	Collaborator collaborator;
	@ManyToOne
	Training training;

	public TrainingChoice() {
	}


	public TrainingChoice(Integer id, Collaborator collaborator, Training training) {
		this.id = id;
		this.collaborator = collaborator;
		this.training = training;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}


}
