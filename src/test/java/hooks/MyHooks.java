package hooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	private ConfigReader configReader;
	
	
	@Before
	public void setUp() {
		
		configReader = new ConfigReader();
		
		Properties prop = configReader.initializeProperties();
		
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		String ScenarioName = scenario.getName().replaceAll("", "");
		
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(srcScreenshot, "image2/png", ScenarioName);
		    
		}
		
		driver.quit();
		
	}

}
