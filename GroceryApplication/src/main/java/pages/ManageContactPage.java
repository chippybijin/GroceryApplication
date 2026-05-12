package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	public WebDriver driver;
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	PageUtility pageObj = new PageUtility();
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") WebElement contactEditButton;
	@FindBy(id="phone") WebElement contactPhoneNumber;
	@FindBy(id="content") WebElement contactAddress;
	@FindBy(xpath="//button[@name='Update']") WebElement contactUpdateButton;
	@FindBy(xpath="//td[text()='566']") WebElement newAddedPhoneNumber;
	
	public ManageContactPage contactEditButtonClick() {
		contactEditButton.click();
		return this;
	}
	
	public ManageContactPage enterNewPhoneNumber(String phoneNumber) {
		contactPhoneNumber.clear();
		contactPhoneNumber.sendKeys(phoneNumber);
		return this;
	}
	
	public ManageContactPage enterNewAddress(String address) {
		contactAddress.clear();
		contactAddress.sendKeys(address);
		return this;
	}
	
	public ManageContactPage manageContactUpdateButtonClick() {
		pageObj.clickWithJSexecutor(driver, contactUpdateButton);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", contactUpdateButton);
		return this;
	}
	
	public String getUpdatedPhoneNumber() {
		return newAddedPhoneNumber.getText();
	}
}
