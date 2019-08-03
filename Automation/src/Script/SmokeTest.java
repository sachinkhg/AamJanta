package Script;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.GeneralUtility;
import Utility.SeleniumUtility;

public class SmokeTest extends Base{
	GeneralUtility gu = new GeneralUtility();
	SeleniumUtility su = new SeleniumUtility();
	
	@Test
	public void f() {
		//su.openBrowser(driverPath, browserName, baseUrl);
		//System.out.println("HellO World");
		gu.takeScreenshots();
	
		logger = Logger.getLogger(SmokeTest.class);
		logger.debug("Hello this is a debug message");	
	}
	@Parameters("baseConfigFile")
	@BeforeTest
	public void intiate(String baseConfigFile){
		gu.intialSetUp(baseConfigFile);
		su.openBrowser(driverPath, browserName, baseUrl);
	}
	@AfterTest
	public void TearDown(){
		driver.quit();
	}
}
