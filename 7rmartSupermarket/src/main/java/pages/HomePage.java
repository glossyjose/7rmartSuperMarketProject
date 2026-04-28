package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logout;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[7]") WebElement manageNewsMoreInfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]") WebElement adminUsersMoreInfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]") WebElement managecategoryMoreInfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]") WebElement managecontactMoreInfo;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[8]") WebElement footerTextmoreInfo;
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}


	public ManageNewsPage clickOnManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
	
	public AdminUsersPage clickAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage clickOnManageCategoryMoreInfo() {
		managecategoryMoreInfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickOnManageContactMoreInfo() {
		managecontactMoreInfo.click();
		return new ManageContactPage(driver);
	}
	
	public ManageFooterTextPage clickOnManageFooterTextMoreInfo() {
		footerTextmoreInfo.click();
		return new ManageFooterTextPage(driver);
	}
	
	public void clickOnLogout() {
		admin.click();
		logout.click();
		
	}
}
