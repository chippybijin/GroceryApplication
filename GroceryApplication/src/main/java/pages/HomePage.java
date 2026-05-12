package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']") WebElement adminBtn;
	@FindBy(xpath="//a[i[contains(@class,'fa-power-off')]]") WebElement logoutBtn;
	@FindBy(xpath="//a[contains(@href,'/admin/list-admin') and contains(text(),'More info')]") WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[contains(@href,'/admin/list-contact') and contains(text(),'More info')]") WebElement manageContactsMoreInfo;
	@FindBy(xpath="//a[contains(@href,'list-news') and contains(@class,'small-box-footer')]") WebElement manageNewsMoreInfo;
	
	public HomePage clickAdminBtn() {
		adminBtn.click();
		return this;
	}
	
	public LoginPage clickLogoutBtn() {  
		logoutBtn.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageContactPage clickManageContachsMoreInfo() {
		manageContactsMoreInfo.click();
		return new ManageContactPage(driver);
	}
	
	public ManageNewsPage clickManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
}
