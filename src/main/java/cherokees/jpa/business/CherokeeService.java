package cherokees.jpa.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import cherokees.jpa.entities.TrainingCollaborator;
import cherokees.jpa.entities.organisation.TrainingChoice;
import cherokees.jpa.manager.EmFactory;
import cherokees.jpa.manager.EmWorker;
import cherokees.jpa.entities.organisation.Collaborator;
import cherokees.jpa.entities.organisation.Training;

public class CherokeeService {
	
	  @PersistenceContext
	    EntityManager em;

	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public List<TrainingCollaborator> createTrainingCollaborator() throws IOException {

		List<TrainingCollaborator> imported = new ArrayList<TrainingCollaborator>();

		// getting the file
		File excel = new File("C:/code/workspace/formationCherokees/excel/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		// getting entries
		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];
		
	
		
		// implementing datas
		for (int i = 0; i < rowNum; i++) {
			try {
				XSSFRow row = ws.getRow(i);
				TrainingCollaborator collab = new TrainingCollaborator();
				collab.setId(i + 1);
				collab.setMonths(convertStringToInt(row, 0));
				collab.setCodeAgency(row.getCell(1).toString());
				collab.setNbDays(convertStringToFloat(row, 2));

				collab.setDueDate(row.getCell(3).getDateCellValue());

				collab.setRealDate(row.getCell(4).getDateCellValue());

				collab.setTrainingName(row.getCell(5).toString());
				collab.setPlace(row.getCell(6).toString());
				collab.setLastName(row.getCell(7).toString());
				collab.setFirstName(row.getCell(8).toString());
				collab.setProvider(row.getCell(9).toString());
				imported.add(collab);
		
				
		        
				System.out.println("import : " + collab.getId());
				System.out.println("import : " + collab.getDueDate());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		System.out.println("import : " + imported);
		return imported;
	}

	Integer convertStringToInt(XSSFRow row, int i) throws IllegalArgumentException {
		try {
			return Integer.valueOf(row.getCell(i).toString());
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	Float convertStringToFloat(XSSFRow row, int i) throws IllegalArgumentException {
		try {
			return Float.valueOf(row.getCell(i).toString());
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public void createTraining(List<TrainingCollaborator> Collaborators) {
		
		EntityManager emtrainee = EmFactory.createEntityManager();
		List<Training> list = new ArrayList<Training>();
		emtrainee.getTransaction().begin();
		for (TrainingCollaborator collab : Collaborators) {
			
			Training trainee = new Training();
			trainee.setNbDays(collab.getNbDays());
			trainee.setPlace(collab.getPlace());
			trainee.setTrainingName(collab.getTrainingName());
			trainee.setDueDate(collab.getDueDate());
			trainee.setRealDate(collab.getRealDate());
			trainee.setProvider(collab.getProvider());
			list.add(trainee);
			
			
	        emtrainee.persist(trainee);
	       
	        
		}
		 emtrainee.getTransaction().commit();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + list);
		
		emtrainee.close();
	}

	public void createCollaborator(List<TrainingCollaborator> Collaborators) {
		
		EntityManager emCollab = EmFactory.createEntityManager();
		emCollab.getTransaction().begin();
		List<Collaborator> list = new ArrayList<Collaborator>();
		for (TrainingCollaborator collab : Collaborators) {
			Collaborator collaborator = new Collaborator();
			collaborator.setCodeAgency(collab.getCodeAgency());
			collaborator.setFirstName(collab.getFirstName());
			collaborator.setLastName(collab.getLastName());
			list.add(collaborator);
			
			
			emCollab.persist(collaborator);
			
	        
		}
		emCollab.getTransaction().commit();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + list);
		emCollab.close();
		EmFactory.getInstance().close();
	}
	
}
