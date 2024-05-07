package PageObjectsModel.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UIHelper {
	
	
	/*	Open the Stream and give the path of file
		Open the Workbook for .xlsx format - XSSF class
		Get the Sheet
		Get the Row 
		Get the Cell
		Test data sheet is DemoTestData.xlsx and sheet name is UserDetails
	*/
	
	List<String> userDetails = new ArrayList<>();
	
	public List<String> getuserDataForRegistration(String sheetName, int rowNo) throws IOException {
		
		FileInputStream fis = new FileInputStream("/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/DemoTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rows = sheet.iterator();
		int lastRow = sheet.getLastRowNum();
		while(rows.hasNext()) {
			Row row=rows.next();
			if(row.getRowNum() == rowNo) {
				Iterator<Cell> cells=row.iterator();
				while(cells.hasNext()) {
					Cell cell = cells.next();
					String cellValue= cell.getStringCellValue();
					userDetails.add(cellValue);
					System.out.print(cellValue+ "   ");
				}
				System.out.println(" ");
			}
			
		}
		fis.close();
		return userDetails;
	}

}


/*
 * FileInputStream fis = new FileInputStream("/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/DemoTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rows = sheet.iterator();
		int lastRow = sheet.getLastRowNum();
		while(rows.hasNext()) {
			Row row=rows.next();
			Iterator<Cell> cells=row.iterator();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				String cellValue= cell.getStringCellValue();
				System.out.print(cellValue+ "   ");
			}
			System.out.println(" ");
		}
		fis.close();
	}

 * 
 * 
 */
 
