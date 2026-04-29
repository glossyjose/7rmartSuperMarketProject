package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username; //Usage of design pattern
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement signinbtn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement alertmsg;
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) //parameterized constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); //there are 2 parameters for initElements method =>used for initializing webElements ?? Can we use this method only inside constructor
	}
	
	public LoginPage enterUserName(String userNameValue) 
	{ 
		username.sendKeys(userNameValue);
		return this;
	} 
	public LoginPage enterPassword(String passwordValue)
	{
		password.sendKeys(passwordValue);
		return this;
	}
	
	public HomePage clickOnSignInBtn() 
	{
		//WaitUtility waitutility =new WaitUtility();
		//waitutility.waitForElementToBeClickable(driver, signinbtn);
		signinbtn.click();
		return new HomePage(driver);
	}
	
	public boolean isHomePageDisplayed() //this method is for validation
	{
		return dashboard.isDisplayed();
	}
	
	public boolean isAlertMessageDisplayed()
	{
		return alertmsg.isDisplayed();
	}
	
}
