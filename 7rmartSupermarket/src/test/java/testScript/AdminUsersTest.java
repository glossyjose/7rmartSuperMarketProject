package testScript;

import java.io.IOException;


import org.testng.annotations.Test;
import org.testng.Assert;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	HomePage homepage;
	AdminUsersPage usersPage;
	@Test(retryAnalyzer = retry.Retry.class, description="This testcase is to validate that the new admin user profile can be created successfully.")
	public void verifyAdminUsersPage() throws IOException {
		String userNameValue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		FakerUtility fakerutility=new FakerUtility();
		String fakeusername=fakerutility.generateUsername();
		String fakepassword=fakerutility.generatePassword();
		
		//AdminUsersPage adminuserpage=new AdminUsersPage(driver);
		usersPage=homepage.clickAdminUsersMoreInfo();
		usersPage.clickNewButton().enterUserInfo(fakeusername, fakepassword).clickSaveButton();
		
		
//		adminuserpage.enterUserInfo(fakeusername, fakepassword);
//		adminuserpage.clickSaveButton();

		String alertSuccess=usersPage.verifyAlert();
		Assert.assertTrue(alertSuccess.contains("User Created Successfully"));
	}
}
