package Academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validationTitle extends base {
	public WebDriver driver;
	LandingPage l;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializing() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialised");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}

	@Test

	public void validateAppTitle() throws IOException {
		// TODO Auto-generated method stub

		//one is inheritance
		//creating object to that class and invoke methods of it
		l = new LandingPage(driver);
		
		// compare the text from the browser with actual value text
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		// Assert.assertTrue(true);
		log.info("Successfully get text");
	}
	
	
	@Test
	
	public void validateHeaderTitle() throws IOException {
		// TODO Auto-generated method stub
		
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");

	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
