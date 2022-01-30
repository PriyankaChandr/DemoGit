package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {

	public WebDriver driver;
	
	private By search = By.id("search-courses");
	
	public portalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getSearch() {
		
		return driver.findElement(search);
	
	}

}
