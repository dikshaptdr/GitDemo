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

import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class validateNavigationBar extends BaseClass{

	public WebDriver driver;
	//public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException {

		//ways to access methods of another class
		// 1. Inheritance
		// 2. creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigation().isDisplayed());	
		//Log.info("Navigation bar is displayed");
	}

	@AfterTest
	public void teardown() {
		
		driver.close();
	}
}
