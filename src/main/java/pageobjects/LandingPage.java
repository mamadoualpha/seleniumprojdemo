package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	//create object for page factory
	@FindBy(xpath="//span[contains(text(),'My Account')]")//locator
	//Apply encapsulation by making WebElement private
	private WebElement myAccountDropdown;//variable
	
	//create method to return this Web element
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	public WebElement loginOption() {
		return loginOption;
	}
	

}
