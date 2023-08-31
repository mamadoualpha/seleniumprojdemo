package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

//To run all tests together convert the project into testng.xml
//To run the project as maven, add the 'maven-surfire-plugin' into the 'pom.xml file

public class SecTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("Krish has updated this file");
		System.out.println("Test two");
		
		driver = initialiseDriver();
		  
		driver.get("https://tutorialsninja.com/demo/");
		  
		Thread.sleep(2000);
		driver.quit();
	}

}
