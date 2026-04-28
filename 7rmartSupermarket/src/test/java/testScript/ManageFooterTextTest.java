package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base{
	HomePage homepage;
	ManageFooterTextPage footertextPage;
	@Test(retryAnalyzer = retry.Retry.class, groups= {"sanity"}, description="This testcase is to validate that the content displayed in the footer section can be updated from the Manage Footer Text page")
	public void validateManageFooterText() throws IOException {
		String UsernameValue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(UsernameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		//ManageFooterTextPage managefooter=new ManageFooterTextPage(driver);
		footertextPage=homepage.clickOnManageFooterTextMoreInfo();
		
		FakerUtility fakerutility=new FakerUtility();
		String address=fakerutility.generateAddress();
		String email=fakerutility.generateEmail();
		String phoneNumber=fakerutility.generatePhoneNumer();
		
		footertextPage.clickEditButton().enterFooterTextinfo(address, email, phoneNumber).clickUpdateButton();
		
		//managefooter.enterFooterTextinfo(address, email, phoneNumber);
		
		//managefooter.clickUpdateButton();
		String alertSuccess=footertextPage.getAlertText();
		Assert.assertTrue(alertSuccess.contains("Footer Text Updated Successfully"));
		
	}

}
