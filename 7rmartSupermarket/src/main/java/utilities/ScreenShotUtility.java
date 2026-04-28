package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		//converting webdriver to screenshot mode(typecasting) - Selenium webdriver cannot take screenshot directly, so we typecast it to take screenshot
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot => interface provided by selenium to capture the failed image
		
		//this takes the screenshot and store it  temporary as a file
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //getScreenshotAs() - capture the screenshot and store it  temporary as a file
		
		//Creates date and time
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
		
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); //// OutputScreenShot"-the screenshot
																					//// is generated in this folder ie
																					//// the loctn only
		if (!f1.exists()) {
			f1.mkdirs(); // if directory does not exists, create a folder
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png"; //decides final screenshot path
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class copies screenshot from temp location to final location. now it is permanently saved into final folder
	}
}
