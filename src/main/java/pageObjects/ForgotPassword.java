package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	
	
	public WebDriver driver;
	
By signin = By.id("user_email");
By instruction = By.cssSelector("input[name='commit']");

public ForgotPassword(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}




public WebElement getsignin() {
	
	return driver.findElement(signin);
	
}
public WebElement sendinstruction() {
	return driver.findElement(instruction);
}


	}


