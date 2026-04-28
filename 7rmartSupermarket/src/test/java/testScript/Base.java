package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver; // declared globally
	public Properties properties; //declare Properties class obj

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println(e);
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser");
		}

		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url")); //to launch url from the config.properties file using the key "url"
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
	}

	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException { //ITestResult is the interface which is provided by selenium
		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
			ScreenShotUtility scrShot = new ScreenShotUtility(); // create obj for instance method inside ScreenShotUtility
			scrShot.getScreenShot(driver, iTestResult.getName()); //getName() =>failed testcase name is returned
		}

	}

}
