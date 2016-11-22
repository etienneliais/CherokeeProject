package cherokees.jpa.entities.organisation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	float nbDays;
	String place;
	String trainingName;
	Date dueDate;
	Date realDate;
	String provider;
	/*@OneToMany
	TrainingChoice trainingChoice;*/
		
	public Training() {
		
	}

	public Training(Integer id, float nbDays, String place, String trainingName, Date dueDate, Date realDate,
			String provider) {
		this.id = id;
		this.nbDays = nbDays;
		this.place = place;
		this.trainingName = trainingName;
		this.dueDate = dueDate;
		this.realDate = realDate;
		this.provider = provider;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getNbDays() {
		return nbDays;
	}

	public void setNbDays(float nbDays) {
		this.nbDays = nbDays;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
}
