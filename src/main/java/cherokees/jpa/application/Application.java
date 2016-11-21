package cherokees.jpa.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cherokees.jpa.business.*;
import cherokees.jpa.entities.TrainingCollaborator;

public class Application {

	public static void main(String[] args) throws IOException {
		CherokeeService service = new CherokeeService();
		List<TrainingCollaborator> listBadass =service.createCollaborator();
		
		service.createTraining(listBadass);
	}
	

	}
