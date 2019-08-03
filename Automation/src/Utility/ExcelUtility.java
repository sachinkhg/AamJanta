package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import Model.Locator;
import Model.TestStep;

public class ExcelUtility extends Base{
	Sheet sheet;
	Row row;
	Cell cell;	
	Locator locator;
	
	public ArrayList<TestStep> readTestCase(String filePath, String SheetName){
		ArrayList<TestStep> testCase = new ArrayList<TestStep>();
		try{
			inputFile = this.readFile(filePath);
			workbook = this.readExcel(inputFile);
			Sheet sheet = workbook.getSheet(SheetName);
			Row row;
			if(!(inputFile.equals(null) || workbook.equals(null))){
				for(int rowIndex = 0; rowIndex < sheet.getLastRowNum(); rowIndex++){
					row = sheet.getRow(rowIndex + 1);
					testCase.add(new TestStep(row));
				}
			}
		}catch(Exception e){
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("inputFile :" + inputFile + ";workbook :" + workbook);
			logger.debug("sheet :" + sheet + ";row :" + row);
			logger.debug("testCase's size :" + testCase.size());
			logger.debug(e.getMessage());
		}
		return testCase;
	}
	public By locatorValue(String filePath, String element){
		By by = null;
		try{
			inputFile = this.readFile(filePath);
			workbook = this.readExcel(inputFile);
			sheet = workbook.getSheetAt(0);
			if(!(inputFile.equals(null) || workbook.equals(null))){
				for(int rowIndex = 0; rowIndex < sheet.getLastRowNum(); rowIndex++){
					cell = sheet.getRow(rowIndex + 1).getCell(1);
					if(this.getCellValue(cell).equals(element)){
						row = sheet.getRow(rowIndex + 1);
						locator = new Locator(row);
					}
				}
			}
			by = this.getElement(locator);
		}catch(Exception e){
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("inputFile :" + inputFile + ";workbook :" + workbook);
			logger.debug("sheet :" + sheet + ";cell :" + cell + ";row :" + row);
			logger.debug(e.getMessage());
		}
		return by;
	}
	private By getElement(Locator locator) {
		By by = null;
		try {
			switch(locator.attribute){
			case "id": 
				by = By.id(locator.attributeValue);
				break;
			case "name":
				by = By.name(locator.attributeValue);
				break;
			case "className": 
				by = By.className(locator.attributeValue);
				break;
			case "tagName":
				by = By.tagName(locator.attributeValue);
				break;
			case "linkText":
				by = By.linkText(locator.attributeValue);
				break;
			case "partialLinkText":
				by = By.partialLinkText(locator.attributeValue);
				break;
			case "xpath":
				by = By.xpath(locator.attributeValue);
				break;
			case "cssSelector":
				by = By.xpath(locator.attributeValue);
				break;
			default:
				break;
		}
		}catch(Exception e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("by :" + by);
			logger.debug(e.getMessage());
		}
		return by;
	}
	public String getCellValue(Cell cell) {
		String value = null;
		CellType cellType = cell.getCellType();
		try {
			switch(cellType){
				case FORMULA: 
					value = Double.toString(cell.getNumericCellValue()); 
					break;
				case STRING: 
					value =  cell.getStringCellValue();
					break;
				case NUMERIC:
					value = this.getNumricValue(cell);
					break;
				default:
					value = null;
					break;
			}
		}catch(Exception e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("value :" + value);
			logger.debug("cellType :" + cellType);
			logger.debug(e.getMessage());
		}	
		return value;
	}
	private String getNumricValue(Cell cell) {
		String value = null;
		Date date = null;
		try {
			if (DateUtil.isCellDateFormatted(cell)) {
				date = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				value = sdf.format(date);
			} else {
				value = new BigDecimal(Double.toString(cell.getNumericCellValue())).toPlainString();
			}
		}catch(Exception e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("value :" + value);
			logger.debug("date :" + date);
			logger.debug(e.getMessage());
		}
		return value;
	}
	public Workbook readExcel(FileInputStream inputFile) {
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inputFile);
		} catch (EncryptedDocumentException | IOException e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("wb :" + wb);
			logger.debug(e.getMessage());
		}
		return wb;
	}
	public FileInputStream readFile(String filePath) {
		FileInputStream	fileInput = null;
		try {
			fileInput = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("fileInput :" + fileInput);
			logger.debug(e.getMessage());
		}
		return fileInput;
	}
}
