package cherokees.jpa.entities.organisation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TrainingChoice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		Integer id;
		
		
		public TrainingChoice() {
			super();
		}


		public TrainingChoice(Integer id) {
			super();
			this.id = id;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}
}
