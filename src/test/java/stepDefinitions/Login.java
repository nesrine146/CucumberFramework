package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	
    WebDriver driver;
	private LoginPage loginPage;
	
	
	@Given("User has navigated to login page")
	public void User_navigates_to_login_page() {
		
		driver=DriverFactory.getDriver();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
			
	}
	
	
	@When("^User enters valid email address (\\S+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		
	    loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(emailText);


		
	}

	@When("^User enters valid password (\\S+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		
		
		loginPage.enterPassword(passwordText);
		
	    
		
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		loginPage.clickOnLoginButton();
	  
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
		
		
		
		
	}
	

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidEmailText) {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(invalidEmailText);
	    
		
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		
		loginPage.enterPassword(invalidPasswordText);
	    
		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_messge_about_credentials_mismatch() {
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("No match for E-Mail Address and/or Password"));
	   
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");


		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		loginPage.enterPassword("");


		
	}

	

}
