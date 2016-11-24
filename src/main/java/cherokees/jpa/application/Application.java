package cherokees.jpa.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cherokees.jpa.dao.CollaboratorDAO;
import cherokees.jpa.dao.TrainingChoiceDAO;
import cherokees.jpa.dao.TrainingDAO;
import cherokees.jpa.entities.Collaborator;
import cherokees.jpa.entities.Training;
import cherokees.jpa.entities.TrainingChoice;
import cherokees.jpa.manager.TransactionHelper;

public class Application {

	public static void main(String[] args) throws IOException {

		CollaboratorDAO collabDao = new CollaboratorDAO();
		TrainingChoiceDAO trainingChoiceDao = new TrainingChoiceDAO();
		TrainingDAO trainingDao = new TrainingDAO();

		// getting the file
		File excel = new File("C:/code/workspace/excel/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");
		System.out.println();
		// getting entries
		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];

		// implementing datas
		try {
			for (int i = 1; i < rowNum; i++) {
				XSSFRow row = ws.getRow(i);

				Collaborator collaborator = new Collaborator();
				collaborator.setCodeAgency(row.getCell(1).toString());
				collaborator.setLastName(row.getCell(7).toString());
				collaborator.setFirstName(row.getCell(8).toString());
				collaborator = collabDao.maybeAddCollab(collaborator);
				
				 Training training = new Training();
				 training.setNbDays(convertStringToFloat(row, 2));
				 training.setDueDate(row.getCell(3).getDateCellValue());
				 training.setRealDate(row.getCell(4).getDateCellValue());
				 training.setTrainingName(row.getCell(5).toString());
				 training.setPlace(row.getCell(6).toString());
				 training.setProvider(row.getCell(9).toString());
				 training = trainingDao.maybeAddTrainee(training);
				
				 TrainingChoice trainingChoice = new TrainingChoice();
				 trainingChoice.setCollaborator(collaborator);
				 trainingChoice.setTraining(training);
				 trainingChoice =
				 trainingChoiceDao.maybeAddTraineeChoice(trainingChoice);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		// System.out.println("import : " + imported);

		// pour etre sur de fermer l'EntityManagerFactory
		TransactionHelper.close();
	}

	Integer convertStringToInt(XSSFRow row, int i) throws IllegalArgumentException {
		try {
			return Integer.valueOf(row.getCell(i).toString());
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	static Float convertStringToFloat(XSSFRow row, int i) throws IllegalArgumentException {
		try {
			return Float.valueOf(row.getCell(i).toString());
		} catch (Exception e) {
			System.out.println("alert probleme a la ligne " + i);
			throw new IllegalArgumentException();
		}
	}

}
