package cherokees.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collaborator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String firstName;
	String lastName;
	String codeAgency;

	public Collaborator() {
	}

	public Collaborator(Integer id, String firstName, String lastName, String codeAgency) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.codeAgency = codeAgency;

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
