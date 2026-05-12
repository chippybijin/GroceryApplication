package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	PageUtility pageObj = new PageUtility();
	
	@FindBy(xpath="//h1[text()='Admin Users']") WebElement adminUsersTitle;
	@FindBy(xpath="//a[@Class=\"btn btn-rounded btn-danger\"]") WebElement newButton;
	@FindBy(id="username") WebElement adminUserName;
	@FindBy(id="password") WebElement adminUserPassword;
	@FindBy(id="user_type") WebElement adminUserType;
	@FindBy(xpath="//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButtonMain;
	@FindBy(id="un") WebElement usernameSearch;
	@FindBy(id="ut") WebElement userTypeSearch;
	@FindBy(xpath="//button[@name='Search']") WebElement searchButton;
	@FindBy(xpath="//td[text()='chippy']") WebElement matchingAdminUser;
	
	public String getTitle() {
		return adminUsersTitle.getText();
	}
	
	public AdminUsersPage newButtonClick() {
		newButton.click();
		return this;
	}
	
	public AdminUsersPage saveBtnClick() {
		saveButton.click();
		return this;
	}
	
	public AdminUsersPage enterAdminUserName(String adminUsernameValue) {
		adminUserName.sendKeys(adminUsernameValue);
		return this;
	}
	
	public AdminUsersPage enterAdminPassword(String adminPasswordValue) {
		adminUserPassword.sendKeys(adminPasswordValue);
		return this;
	}
	
	public AdminUsersPage selectUsertType() {
		pageObj.selectByVisibleText(adminUserType,"Admin");
		//Select userType = new Select(adminUserType);
		//userType.selectByVisibleText("Admin");
		return this;
	}
	
	public boolean isUserAddedSuccessMessageDisplayed() {
		return successAlert.isDisplayed();
	}
	
	public AdminUsersPage mainSearchBtnClick() {
		searchButtonMain.click();
		usernameSearch.sendKeys("chippy");
		pageObj.selectByVisibleText(userTypeSearch,"Admin");
		//Select userTypeforSearch = new Select(userTypeSearch);
		//userTypeforSearch.selectByVisibleText("Admin");
		searchButton.click();
		return this;
	}
	
	public String getSearchedUserName() {
		return matchingAdminUser.getText();
	}
}
