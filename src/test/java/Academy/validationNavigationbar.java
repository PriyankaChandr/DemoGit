package Academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import pageObjects.LandingPage;
import resources.base;

public class validationNavigationbar extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializing() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test

	public void basePageNavigation() throws IOException {
		// TODO Auto-generated method stub

//creating object to  that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		l.getnavbar();

		// Validation something present or not
		Assert.assertTrue(l.getnavbar().isDisplayed());
		log.info("Successfully displayed navigation bar");
		System.out.println("Test completed");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
