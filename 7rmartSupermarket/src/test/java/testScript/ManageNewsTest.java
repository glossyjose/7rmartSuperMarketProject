package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage homepage;
	ManageNewsPage newsPage;
	@Test(description="This testcase is to validate that the news can be created successfully from Manage News Page")
	public void verifyManageNews() throws IOException {
		String userNameValue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickOnSignInBtn();
		
		String newsText=ExcelUtility.getStringData(1, 0, "news");
		
		//ManageNewsPage managenews=new ManageNewsPage(driver);
		newsPage=homepage.clickOnManageNewsMoreInfo();
		newsPage.clickNewButton().enterNews(newsText).clickOnSaveButton();
		//managenews.enterNews(newsText);
		//managenews.clickOnSaveButton();
		
		String alertText=newsPage.verifyMessage();
		Assert.assertTrue(alertText.contains("News Created Successfully"));
		
	}
	
}
