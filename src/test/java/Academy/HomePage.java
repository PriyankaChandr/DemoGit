package Academy;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializing() throws IOException {
		driver = initializeDriver();

	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		if(l.getPopupSize()>0) {
			l.getPopup().click();
			}
		l.getLogin();
		
//To avoid more page objects we will remove this object and call it from method landingpage only
		LoginPage lp = new LoginPage(driver);
		lp.getsignin().sendKeys(Username);
		lp.getpasswrd().sendKeys(Password);
		
		//Log.info(text);
		lp.go().click();
		
		//forgot password
		ForgotPassword fp=lp.forgotPassword();
		fp.getsignin().sendKeys("abc@gmail.com");
		fp.sendinstruction().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider

	public Object[][] getData() {

		Object[][] data = new Object[1][2];
		// 0th row

		data[0][0] = "priyanka@abc.com";
		data[0][1] = "1234";

		// 1st row

		/*
		 * data[1][0]="abc@abc.com"; data[1][1]="123ac";
		 */
		return data;
	}
}
