package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

//To run all tests together convert the project into testng.xml
//To run the project as maven, add the 'maven-surfire-plugin' into the 'pom.xml file
public class FourthTest extends Base {
	
	public WebDriver	driver;

	@Test
	public void testFoure() throws IOException, InterruptedException {
		
		System.out.println("Mamadou has updated this method");
		System.out.println("Test foure");
		
	  driver = initialiseDriver();
	  
	  driver.get("https://tutorialsninja.com/demo/");
	  
	  Thread.sleep(2000);
	  
	  Assert.assertTrue(false);
	  
	  
	}
	
	@AfterMethod
	public void closingBrowser() {
	driver.quit();
	}
}
