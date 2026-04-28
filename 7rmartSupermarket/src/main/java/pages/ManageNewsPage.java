package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
//	@FindBy(xpath = "(//a[@class='small-box-footer'])[7]")
//	WebElement manageNewsMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtn;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(.,'News Created Successfully')]")
	WebElement alertMsg;
	//By alertLocator=By.xpath("//div[contains(@class,'alert-success') and contains(.,'News Created Successfully')]");
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void clickOnManageNewsMoreInfo() {
//		manageNewsMoreInfo.click();
//	}

	public ManageNewsPage clickNewButton() {
		newBtn.click();
		return this;
	}

	public ManageNewsPage enterNews(String newsText) {
		enterNews.sendKeys(newsText);
		return this;
		
	}
	
	public ManageNewsPage clickOnSaveButton() {
		saveBtn.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertMsg.isDisplayed();
	}
	
	public String verifyMessage() {
		//WaitUtility waitutility =new WaitUtility();
		//waitutility.waitForVisibilityOfElement(driver, alertLocator);
		String alertText=alertMsg.getText();
		return alertText;
	}
}
