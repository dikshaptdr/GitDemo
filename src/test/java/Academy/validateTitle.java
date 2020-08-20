package Academy;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;


public class validateTitle extends BaseClass{

	public WebDriver driver;
	LandingPage l = new LandingPage(driver);
	//public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		//log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		//log.info("Navigated to HomePage");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		//ways to access methods of another class
		// 1. Inheritance
		// 2. creating object to that class and invoke methods of it
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		//log.info("Successfully validated text message");
	}
	
	@Test
	public void validateHeader() {
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
	}

	@AfterTest
	public void teardown() {
		
		driver.close();
	}
	
}
