package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WaitUtility waitUtility = new WaitUtility();
	
	@FindBy(name="username") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") WebElement loginButton;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement isDashboardDisplayed;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginTitle;
	
	// chaining
	public LoginPage enterUserName(String usernameValue) {
		userName.sendKeys(usernameValue);
		return this; // not redirected to any page
	}
	
	public LoginPage enterPassword(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}
	
	public HomePage loginBtnClick() {
		waitUtility.waitUntilElementToBeClickable(driver, loginButton);
		loginButton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return isDashboardDisplayed.isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return loginTitle.getText();
	}
}
