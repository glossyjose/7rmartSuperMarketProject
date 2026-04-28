package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
//	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
//	WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtnAdmin;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	WebElement alertSuccess;
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void clickAdminUsersMoreInfo() {
//		adminUsersMoreInfo.click();
//	}
	
	public AdminUsersPage clickNewButton() {
		newBtnAdmin.click();
		return this;
	}
	
	public AdminUsersPage enterUserInfo(String userNameValue, String passwordValue) {
		username.sendKeys(userNameValue);
		password.sendKeys(passwordValue);
		
		PageUtility pageutility=new PageUtility();
		pageutility.selectByIndexMethod(userTypeDropdown, 2);
		return this;
	}
	
	public AdminUsersPage clickSaveButton() {
		saveBtn.click();
		return this;
	}
	
	public String verifyAlert() {
		String alertText=alertSuccess.getText();
		return alertText;
	}


}
