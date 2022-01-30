 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	//object define on top
	
	public WebDriver driver;
	
private By login = By.cssSelector("a[href*='sign_in']");
private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
private By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
private By header = By.cssSelector("div[class*='video-banner'] h3");
private By popup = By.xpath("//div[@class='div[class='sumome-react-svg-image-container']']");
//creating constructor to give life to driver

public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}

//methods define below
public LoginPage getLogin() {
	
	driver.findElement(login).click();
	LoginPage lp = new LoginPage(driver);
	return lp;
}
public int getPopupSize() {
	return driver.findElements(popup).size();
}
public WebElement getPopup() {
	return driver.findElement(popup);
}
public WebElement getTitle() {
	
	return driver.findElement(title);
}
public WebElement getHeader() {
	
	return driver.findElement(header);
}
public WebElement getnavbar() {
	
	return driver.findElement(navbar);
}
	}


