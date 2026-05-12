package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object= new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropWithIndex(WebElement element, int value) {
		Select object= new Select(element);
		object.selectByIndex(value);
	}
	
	public void selectByVisibleText(WebElement element, String value) {
		Select object= new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void deSelectDragDropWithValue(WebElement element, String value) {
		Select object= new Select(element);
		object.deselectByValue(value);
	}
	
	public void clickWithJSexecutor(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	public void verifyScrollJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
}
