package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.PageUtility;

public class ManageCategoryPage {
//	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
//	WebElement managecategoryMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtn;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryname;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement sourceElement;
	@FindBy(xpath = "(//ul[@tabindex='-1'])[2]")
	WebElement targetElement;
	@FindBy(xpath = "//input[@type='file']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertSuccess;

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void clickOnManageCategoryMoreInfo() {
//		managecategoryMoreInfo.click();
//	}

	public ManageCategoryPage clickNewButton() {
		newBtn.click();
		return this;
	}

	public ManageCategoryPage enterCategoryInfo(String categoryName) {
		categoryname.sendKeys(categoryName);
		sourceElement.click();
		return this;

		//PageUtility pageutility = new PageUtility();
		//pageutility.dragAndDropMethod(driver, sourceElement, targetElement);

	}

	public ManageCategoryPage imageUpload() {
		choosefile.sendKeys(Constant.ORANGEIMAGE);
		return this;
	}

	public ManageCategoryPage clickSaveButton() {
		saveBtn.click();
		return this;
	}

	public String getAlertText() {
		String alertText = alertSuccess.getText();
		return alertText;
	}

}
