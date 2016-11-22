package cherokees.jpa.entities.organisation;

import javax.persistence.*;

@Entity
public class Collaborator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	String firstName;
	String lastName;
	String codeAgency;
	@ManyToOne
	TrainingChoice trainingChoice;
	
	
	public Collaborator() {
	}

	public Collaborator(Integer id, String firstName, String lastName, String codeAgency,TrainingChoice trainingChoice) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.codeAgency = codeAgency;
		this.trainingChoice = trainingChoice;

	}

	public TrainingChoice getTrainingChoice() {
		return trainingChoice;
	}

	public void setTrainingChoice(TrainingChoice trainingChoice) {
		this.trainingChoice = trainingChoice;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCodeAgency() {
		return codeAgency;
	}


	public void setCodeAgency(String codeAgency) {
		this.codeAgency = codeAgency;
	}
}
