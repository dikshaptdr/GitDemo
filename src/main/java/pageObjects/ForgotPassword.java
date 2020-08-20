package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	By email = By.id("user_email");
	By sendMeInstructions = By.xpath("//input[@value='Send Me Instruction']");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;  // given life to variable to remove 'NullPointerException'
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}
}
