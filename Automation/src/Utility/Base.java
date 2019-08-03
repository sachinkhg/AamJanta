package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

public class Base {
	public FileInputStream inputFile;
	public FileOutputStream outputFile;
	public Workbook workbook;
	public static WebDriver driver;
	public static Logger logger;
	
	public static String testScriptPath;
	public static String locatorFilePath;
	public static String driverPath;
	public static String browserName;
	public static String baseUrl;
	public static String downloadPath;
	public static String screenshotFolder;
	public static String testNGOutputFolderPath;
	
	public Base(){

	}
	
	public static void main(String[] args){
		ExcelUtility eu = new ExcelUtility();
		
		String filePath = "E:\\Test-P01.xlsx";
		String SheetName = "ImportTest";
		eu.readTestCase(filePath, SheetName);
	}	
}
