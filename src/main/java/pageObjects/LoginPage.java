package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	private By signin = By.id("user_email");
	private By password = By.id("user_password");
	private By go = By.cssSelector("input[name='commit']");
	private By forgot = By.cssSelector("a[href*='password/new']");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public ForgotPassword forgotPassword() {
		driver.findElement(forgot).click();
		return new ForgotPassword(driver);

	}

	public WebElement getsignin() {

		return driver.findElement(signin);

	}

	public WebElement getpasswrd() {
		return driver.findElement(password);
	}

	public WebElement go() {
		return driver.findElement(go);
	}
}
