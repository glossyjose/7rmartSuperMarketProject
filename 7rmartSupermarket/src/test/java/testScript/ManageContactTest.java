package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base{
	HomePage homepage;
	ManageContactPage contactPage;
	@Test(retryAnalyzer = retry.Retry.class, description="This testcase is to validate that the contact details can be updated successfully from the manage contact page")
	public void validateManageContactPage() throws IOException {
		String UsernameValue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(UsernameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		//ManageContactPage managecontact=new ManageContactPage(driver);
		contactPage=homepage.clickOnManageContactMoreInfo();
		
		FakerUtility fakerutility=new FakerUtility();
		String randomEmail=fakerutility.generateEmail();
		
		contactPage.clickEditContact().updateEmail(randomEmail).clickUpdateBtn();
		//managecontact.updateEmail(randomEmail);
		//managecontact.clickUpdateBtn();
		
		String alertSuccess=contactPage.getAlertText();
		Assert.assertTrue(alertSuccess.contains("Contact Updated Successfully"));
		
	}
}
