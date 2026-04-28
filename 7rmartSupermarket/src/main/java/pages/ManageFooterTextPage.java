package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
//	@FindBy(xpath = "(//a[@class='small-box-footer'])[8]")
//	WebElement footerTextmoreInfo;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement addressEditBtn;
	@FindBy(xpath = "//textarea[@id=\"content\"]")
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumberField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertSuccess;

	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void clickOnManageFooterTextMoreInfo() {
//		footerTextmoreInfo.click();
//	}

	public ManageFooterTextPage clickEditButton() {
		addressEditBtn.click();
		return this;
	}

	public ManageFooterTextPage enterFooterTextinfo(String address, String email, String phoneNumber) {
		addressField.clear();
		addressField.sendKeys(address);

		emailField.clear();
		emailField.sendKeys(email);

		phoneNumberField.clear();
		phoneNumberField.sendKeys(phoneNumber);
		return this;

	}

	public ManageFooterTextPage clickUpdateButton() {
		updateBtn.click();
		return this;
	}
	
	public String getAlertText() {
		String alertText = alertSuccess.getText();
		return alertText;
	}
	
}
