package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.BaseClass;

import org.junit.runner.RunWith;
import org.testng.Assert;


public class StepDefination extends BaseClass{

    @Given("^Initialise the browser with chrome$")
    public void initialise_the_browser_with_chrome() throws Throwable {
    	driver=initializeDriver();
    }
    
    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    
    @And("^Click on login link in home page to land on Secure Signin Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_signin_page() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	if(l.getPopUpSize()>0)
    		l.getPopUp().click();
		LoginPage lp = l.getLogin();
    }

    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
    	lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
        PortalHomePage p = new PortalHomePage(driver);
        Assert.assertTrue(p.getSearchBox().isDisplayed());
    }
    
    @And("^Close Browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

}