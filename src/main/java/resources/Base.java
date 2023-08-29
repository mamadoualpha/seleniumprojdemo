package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	//make the 'properties' global and public
	public Properties prop;

	public WebDriver initialiseDriver() throws IOException {


		// create the properties method
		 prop = new Properties();
		// get the project path and save it into 'propPath' variable
		String propPath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
		// create the 'FileInputStream' method and provide the 'data.properties' path as argument the save into 'fis' variable
		FileInputStream fis = new FileInputStream(propPath);
		// loads the properties file input stream
		prop.load(fis);
		// get the browser from data file and save it into a variable 'browserName'
		String browserName = prop.getProperty("browser");

		// call the browser here
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			// call the browser here
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		

		return driver;
	}

	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		
		return destinationFilePath;
	}
}


