package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base{
	HomePage homepage;
	ManageCategoryPage categoryPage;
	@Test(retryAnalyzer = retry.Retry.class, description="This testcase is to validate that a new category can be created successfully with discount group")
	public void validateManageCategory() throws IOException {
		String UsernameValue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(UsernameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		
		//ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		categoryPage=homepage.clickOnManageCategoryMoreInfo();
		
		FakerUtility fakerutility=new FakerUtility();
		String nameRandom=fakerutility.generateName();
		categoryPage.clickNewButton().enterCategoryInfo(nameRandom).imageUpload().clickSaveButton();
		
		
//		managecategory.enterCategoryInfo(nameRandom);
//		
//		managecategory.imageUpload();
//		managecategory.clickSaveButton();
		
		String alertSuccess=categoryPage.getAlertText();
		Assert.assertTrue(alertSuccess.contains("Category Created Successfully"));
		
	}
		
}
