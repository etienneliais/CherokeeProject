package cherokees.jpa.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainingCollaborator {

	int id;
	int months;
	String codeAgency;
	float nbDays;
	Date dueDate;
	Date realDate;
	String trainingName;
	String place;
	String lastName;
	String firstName;
	String provider;

	public TrainingCollaborator() {

	}

	public TrainingCollaborator(int id, int months, String codeAgency, float nbDays, Date dueDate, Date realDate,
			String trainingName, String place, String lastName, String firstName, String provider) {
		super();
		this.id = id;
		this.months = months;
		this.codeAgency = codeAgency;
		this.nbDays = nbDays;
		this.dueDate = dueDate;
		this.realDate = realDate;
		this.trainingName = trainingName;
		this.place = place;
		this.lastName = lastName;
		this.firstName = firstName;
		this.provider = provider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public String getCodeAgency() {
		return codeAgency;
	}

	public void setCodeAgency(String codeAgency) {
		this.codeAgency = codeAgency;
	}

	public float getNbDays() {
		return nbDays;
	}

	public void setNbDays(float nbDays) {
		this.nbDays = nbDays;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getRealDate() {
		return realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
}
