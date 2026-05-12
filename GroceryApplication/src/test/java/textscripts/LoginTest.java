package textscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainprojectcore.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends MainProjectBase{
	HomePage home; //global reference variable
	@Test(priority=1,description="user is trying to login with valid credentials", groups="smoke")
	public void verifyLoginWithValidCredentials() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		// same pages can be connected using chaining
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		home = loginpage.loginBtnClick();
		boolean dashboadDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboadDisplayed, Constant.VALIDCREDENTIALERROR);
	}
	
	@Test(priority=2,description="user is trying to login with invalid username", retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWithInvalidUserName() throws IOException {
		String userNameValue = ExcelUtility.readStringData(1, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(1, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue).loginBtnClick();
		String loginTitle = "7rmart supermarket";
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, loginTitle, Constant.INVALIDUSERNAMEERROR);
	}
	
	@Test(priority=3,description="user is trying to login with invalid password")
	public void verifyLoginWithInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(2, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(2, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue).loginBtnClick();
		String loginTitle = "7rmart supermarket";
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, loginTitle, Constant.INVALIDPASSWORDERROR);
	}
	
	@Test(priority=4,description="user is trying to login withinvalid username and password", groups="smoke", dataProvider="loginProvider")
	public void verifyLoginWithInvalidCredentials(String userNameValue, String passwordValue) throws IOException {
		//String userNameValue = ExcelUtility.readStringData(3, 0, "GroceryAppLogin");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue).loginBtnClick();
		String loginTitle = "7rmart supermarket";
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, loginTitle, Constant.INVALIDCREDENTIALSERROR);
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
