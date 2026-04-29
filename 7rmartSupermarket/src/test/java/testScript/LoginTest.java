package testScript;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	HomePage homepage;
	@Test(priority=1, groups= {"regression"}, retryAnalyzer = retry.Retry.class, description="This testcase is to validate that the user is successfully logged in to the web application using valid credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException 
	{
		//String userNameValue="admin";
		//String passwordValue="admin";
		
		String userNameValue=ExcelUtility.getStringData(1, 0, "loginpage"); //retrieving username from the excel stored inside testData.xlsx 
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver); 
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue); //calling username and password in a chaining manner 
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		boolean homepage=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage, Constant.VALIDCREDENTIALMSG); //testcase will be failed when assert class returns false
	}
	@Test(priority=2, groups= {"sanity"},retryAnalyzer = retry.Retry.class,description="This testcase is to validate that the user is unable to login to the web application when wrong password is entered")
	public void verifyTheUserIsUnableToLoginUsingWrongPassword() throws IOException {
		String userNameValue=ExcelUtility.getStringData(2, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue).clickOnSignInBtn();
		//loginpage.enterPassword(passwordValue);
		//loginpage.clickOnSignInBtn();
		
		boolean alertmsg=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertmsg, Constant.INVALIDPASSWORDMSG);
	}
	@Test(priority=3,retryAnalyzer = retry.Retry.class,description="This testcase is to validate that the user is unable to login to the web application when wrong username is entered")
	public void verifyTheUserIsUnableToLoginUsingWrongUserName() throws IOException {
		String userNameValue=ExcelUtility.getStringData(3, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue).clickOnSignInBtn();
		//loginpage.enterPassword(passwordValue);
		//loginpage.clickOnSignInBtn();
		
		boolean alertmsg=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertmsg,Constant.INVALIDUSERNAMEMSG);
	}
	@Test(priority=4, groups= {"sanity"},retryAnalyzer = retry.Retry.class, description="This testcase is to validate that the user is unable to login to the web application when both the credentials are wrong")
	public void verifyTheUserIsUnableToLoginUsingInvalidCredentials() throws IOException {
		String userNameValue=ExcelUtility.getStringData(4, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(4, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue).clickOnSignInBtn();
		//loginpage.enterPassword(passwordValue);
		//loginpage.clickOnSignInBtn();
		
		boolean alertmsg=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertmsg,Constant.INVALIDCREDENTIALMSG);
	}
}
