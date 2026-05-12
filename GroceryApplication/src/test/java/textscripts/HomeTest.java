package textscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainprojectcore.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends MainProjectBase{
	HomePage homepage;
	@Test(description="user is trying to logout")
	public void verifyUserIsAbleToLogOut() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		homepage = loginpage.loginBtnClick();
		homepage.clickAdminBtn();
		loginpage = homepage.clickLogoutBtn();
		String loginTitle = "7rmart supermarket";
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, loginTitle, Constant.LOGOUTERROR);
	}
}
