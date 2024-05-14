package PageObjectsModel.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;


public class UIHelper {
	
	WebDriver driver;
	
	public UIHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public UIHelper() {
		
	}
	
	
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



	public void addRegisteredUsers(String regUsers, String sheetName) throws IOException {
		userDetails.clear();
		FileInputStream fis = new FileInputStream("/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/DemoTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		Iterator<Row> rows=sheet.iterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			row = sheet.createRow(lastRow+1);
			if(row.getRowNum() == lastRow+1 ) {
				Cell cell = row.createCell(0);
				cell.setCellValue(regUsers);
				break;
			}
		}
		FileOutputStream out = new FileOutputStream("/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/DemoTestData.xlsx");
		workbook.write(out);
		out.close();
	}
	
	public void takeSnap(String snapName)throws IOException {
		String fileName = snapName+".jpg";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/"+fileName));
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
		
	}
	
	public String takeSnapAndPath(String snapName)throws IOException {
		String fileName = snapName+".jpg";
		String path = "/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/"+fileName+".jpg";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File output = new File(path);
		Files.copy(file, output);
		return path;
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
 
 /*
  * 	<parameter name="urlAmz" value="https://www.amazon.in/"></parameter>
	<parameter name="searchSamsungKeyword1" value="samsung galaxy"></parameter>
	<parameter name="searchAppleKeyword1" value="iphone"></parameter>
	<parameter name="searchAppleKeyword2" value="iPad"></parameter>
	<parameter name="urlDemoWebShop" value="https://demowebshop.tricentis.com/"></parameter>
	<parameter name="" value=""></parameter>
  */
 
