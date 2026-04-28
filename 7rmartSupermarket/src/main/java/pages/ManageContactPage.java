package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
//	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]") WebElement managecontactMoreInfo;
	@FindBy(xpath = "//i[contains(@class,'fas fa-edit')]") WebElement contactEdit;
	@FindBy(xpath = "//input[@id='email']") WebElement email;
	@FindBy(xpath="//button[@type='submit']") WebElement updateBtn;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertSuccess;
	
	public WebDriver driver;
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void clickOnManageContactMoreInfo() {
//		managecontactMoreInfo.click();
//	}
//	
	public ManageContactPage clickEditContact() {
		contactEdit.click();
		return this;
	}
	public ManageContactPage updateEmail(String emailValue) {
		email.clear();
		email.sendKeys(emailValue);
		return this;
	}
	public ManageContactPage clickUpdateBtn() {
		updateBtn.click();
		return this;
	}
	
	public String getAlertText() {
		String alertText=alertSuccess.getText();
		return alertText;
	}
}
