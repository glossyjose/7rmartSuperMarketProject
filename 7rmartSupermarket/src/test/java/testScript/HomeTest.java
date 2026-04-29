package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	@Test(description="This testcase is to validate that the user is successfully logged out from the application")
	public void verifyLogout() throws IOException {
		String userNameValue=ExcelUtility.getStringData(1, 0, "loginpage"); //retrieving username from the excel stored inside testData.xlsx 
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver); 
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		//HomePage logout=new HomePage(driver);
		loginpage=homepage.clickOnLogout();
		
	}
}
