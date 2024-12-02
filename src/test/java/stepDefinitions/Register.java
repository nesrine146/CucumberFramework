package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register {
	
	WebDriver driver;
	
	
	@Given("User navigates to Registrater Account page")
	public void user_navigates_to_registrater_account_page() {
		
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));

	   
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		driver.findElement(By.name("agree")).click();

	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

	    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
	 
	}

	@When("User selects yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	   
		
		
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(driver.findElement(By.xpath("div[contains(@class,'alert-dismissble')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	   
		
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   
		
	}

	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissble")).getText().contains("Warning: you must agree to the privacy"));
	    Assert.assertEquals("First Name must be between 1 and 32 characters",driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
	    Assert.assertEquals("Last Name must be between 1 and 32 characters",driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
	    Assert.assertEquals("E-Mail address doest not appear to be valid!",driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
	    Assert.assertEquals("Telephone must be between 3 and 32 characters",driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
	    Assert.assertEquals("Password must be between 4 and 20 characters",driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());

	}

}
