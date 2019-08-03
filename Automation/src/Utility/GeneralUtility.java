package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;

public class GeneralUtility extends Base{
	ExcelUtility eu = new ExcelUtility();
	public static void deleteFile(String filePath){
		File file = new File(filePath);
		file.delete();
	}
	public void takeScreenshots(){
		File currentScreenshotFolder = null;
		File screenShot = null;
		try {
			currentScreenshotFolder = new File(screenshotFolder + File.separator +new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date()));
			currentScreenshotFolder.mkdir();
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			screenShot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, new File(currentScreenshotFolder + "/screenshot" + new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date())+".png"));
		} catch (IOException e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("currentScreenshotFolder :" + currentScreenshotFolder + ";screenShot :" + screenShot);
			logger.debug(e.getMessage());
		}
	}
	
	public void intialSetUp(String baseConfigFile){
		Sheet sheet = null;
		try {
		ExcelUtility eu = new ExcelUtility();
		inputFile = eu.readFile(baseConfigFile);
		workbook = eu.readExcel(inputFile);
		sheet = workbook.getSheetAt(0);
		
		testScriptPath = eu.getCellValue(sheet.getRow(1).getCell(2));
		locatorFilePath = eu.getCellValue(sheet.getRow(2).getCell(2));
		driverPath = eu.getCellValue(sheet.getRow(3).getCell(2));
		browserName = eu.getCellValue(sheet.getRow(4).getCell(2));
		baseUrl = eu.getCellValue(sheet.getRow(5).getCell(2));
		downloadPath = eu.getCellValue(sheet.getRow(6).getCell(2));
		screenshotFolder = eu.getCellValue(sheet.getRow(7).getCell(2));
		testNGOutputFolderPath = eu.getCellValue(sheet.getRow(8).getCell(2));
		} catch(Exception e) {
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("inputFile :" + inputFile + ";workbook :" + workbook);
			logger.debug("sheet :" + sheet);
			logger.debug("testScriptPath :" + testScriptPath + ";locatorFilePath :" + locatorFilePath);
			logger.debug("driverPath :" + driverPath + ";browserName :" + browserName);
			logger.debug("baseUrl :" + baseUrl + ";downloadPath :" + downloadPath);
			logger.debug("screenshotFolder :" + screenshotFolder + ";testNGOutputFolderPath :" + testNGOutputFolderPath);
			logger.debug(e.getMessage());
		}
	}	
}
