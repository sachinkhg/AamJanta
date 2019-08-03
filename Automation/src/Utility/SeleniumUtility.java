package Utility;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Model.TestStep;

public class SeleniumUtility extends Base{
	ExcelUtility eu = new ExcelUtility();
	WebElement element;
	By by;
	public void runtestStep(TestStep step, String locatorFilePath){
		try{
			by = eu.locatorValue(locatorFilePath, step.element);
			this.waitForElement(by);
			element = driver.findElement(by);
			switch(step.action){
			case "Click":
				element.click();
				break;
			case "Insert":
				element.sendKeys(step.value);
				break;
			case "Clear":
				element.clear();
				break;
			case "Hover": 
				this.hoverOnElement(element);
				break;
			case "HoverAndClick":
				Actions action = this.hoverOnElement(element);
				by = eu.locatorValue(locatorFilePath, step.value);
				this.ClickOnHoveredElement(action, by);
				break;
			default:
				break;
			}
		}catch(Exception e){
			logger = Logger.getLogger(ExcelUtility.class);
			logger.debug("element :" + inputFile + ";by :" + by);
			logger.debug(e.getMessage());
		}
	}
	private void waitForElement(By by) {
		List<WebElement> WaitElement;
		do{
			WaitElement = driver.findElements(by);		
		}while(WaitElement.size() == 0);
	}
	private void ClickOnHoveredElement(Actions action, By by) {
		action.click().build().perform();
	}
	private Actions hoverOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return action;
	}
	public void openBrowser(String driverPath, String browserName, String baseUrl){
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		driver.get(baseUrl);		
	}
}
