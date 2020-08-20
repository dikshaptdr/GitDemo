package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	//By signin = By.cssSelector("a[href*='sign_in']");
	private By signin = By.xpath("//span[contains(text(), 'Login')]");
	private By title = By.cssSelector(".text-center>h2");
	private By home = By.xpath("//a[text()='Home']");
	private By header= By.cssSelector("div[class*='video-banner'] h3");
	By popup = By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;  // given life to variable to remove 'NullPointerException'
	}

	public LoginPage getLogin() {
		driver.findElement(signin);
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigation() {
		return driver.findElement(home);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	
	public int getPopUpSize() {
		return driver.findElements(popup).size(); // cannot use IsDisplayed here since pop-up will always be present in DOM no matter what on UI
	}
	
	public WebElement getPopUp(){
		return driver.findElement(popup);
	}
	
}
