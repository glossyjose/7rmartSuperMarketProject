package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement element, String filepath) {
		element.sendKeys(filepath);
		
	}
	
	public void fileUploadUsingRobotClass(WebElement element, String filepath) throws AWTException {
		StringSelection stringSelection=new StringSelection(filepath); //CREATE object for stringSelection class and pass the path inside StringSelection
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); //file path will get copied into clipboard
		Robot robot=new Robot(); //it is a class, create object
		robot.delay(2000); //delay is given if it gets delayed to load the page (ms)
		robot.keyPress(KeyEvent.VK_CONTROL); //KeyEvent is a class and VK_Control is a method inside this class (this is to press control button)
		robot.keyPress(KeyEvent.VK_V); //to press V button
		
		robot.keyRelease(KeyEvent.VK_CONTROL); //to release control button
		robot.keyRelease(KeyEvent.VK_V); //to release V button
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
