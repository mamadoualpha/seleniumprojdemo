package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
     //Apply encapsulation by making WebElement private
	 @FindBy(linkText="Account")
	 private WebElement editAccountInfo;
	
	public WebElement editAccountInfo() {
		return editAccountInfo;
	
	

}}
