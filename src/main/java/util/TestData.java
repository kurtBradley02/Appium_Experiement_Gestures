package util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestData {
	
	private Sheet getSheet;

	private Workbook workbook;
	
	public TestData(String project) throws IOException {

		String userDir = System.getProperty("user.home");
		
		String filePath = userDir + "/OneDrive/Desktop/"+project+"/resources/TestData.xlsx";

		workbook = WorkbookFactory.create(new File(filePath));

	}
	
	public void setSheetName(String sheetName) {
		getSheet = workbook.getSheet(sheetName);
	}
	
	public String getData(int rowIndex,int columnIndex) {

		Row row = getSheet.getRow(rowIndex); 
		Cell cell = row.getCell(columnIndex); 
		return cell.getStringCellValue(); 
		
	}
	


}
