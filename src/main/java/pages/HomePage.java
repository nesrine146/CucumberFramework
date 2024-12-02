package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		elementUtils = new ElementUtils(driver);
		
	}
	
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
    public void selectLoginOption() {
    	
    	
    	elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);	
			
    }
	
    public void enterProductOnSearchBox(String productText) {
    	
    	elementUtils.javascriptType(searchBoxField, CommonUtils.EXPLICIT_WAIT_BASIC_TIME, productText);
    	
  
    }
    
    
    public void clickOnSearchButton() {
    	
    	elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
    }
	
	
	
	
	
	
	

}
