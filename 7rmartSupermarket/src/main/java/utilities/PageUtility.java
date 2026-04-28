package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	//public WebDriver driver;

	//Select class Methods
	public void selectByVisibleTextMethod(WebElement elementName, String visibleText) {
		Select select = new Select(elementName);
		select.selectByVisibleText(visibleText);
	}

	public void selectByIndexMethod(WebElement elementName, int index) {
		Select select = new Select(elementName);
		select.selectByIndex(index);
	}

	public void selectByValueMethod(WebElement elementName, String value) {
		Select select = new Select(elementName);
		select.selectByValue(value);
	}
	
	//Actions class method
	public void dragAndDropMethod(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
	}

	public void rightClickMethod(WebDriver driver, WebElement elementName) {
		Actions actions = new Actions(driver);
		actions.contextClick(elementName).perform();
	}

	public void mouseHoverMethod(WebDriver driver, WebElement elementName) {
		Actions actions = new Actions(driver);
		actions.moveToElement(elementName).perform();
	}

	public void doubleClickMethod(WebDriver driver, WebElement elementName) {
		Actions actions = new Actions(driver);
		actions.doubleClick(elementName).perform();
	}

	public void clickMethod(WebDriver driver, WebElement elementName) {
		Actions actions = new Actions(driver);
		actions.click(elementName).perform();
	}
}