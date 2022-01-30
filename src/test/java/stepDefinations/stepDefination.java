package stepDefinations;

import org.junit.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefination extends base{
	
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}
	
	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(string);
	}
	
	@Given("^Click on login link in homepage to land on secure sign in page$")
	public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page()throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		if(l.getPopupSize()>0) {
		l.getPopup().click();
		}
		
		l.getLogin();
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage lp = new LoginPage(driver);
		lp.getsignin().sendKeys(username);
		lp.getpasswrd().sendKeys(password);
		lp.go().click();
	}
	
	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in()throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		portalHomePage p = new portalHomePage(driver);
		Assert.assertTrue(p.getSearch().isDisplayed());
	}
@And("^Close browsers$")
public void close_browser()throws Throwable{
	driver.quit();
}
	
}