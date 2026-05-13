package textscripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainprojectcore.MainProjectBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends MainProjectBase{
	HomePage home;
	AdminUsersPage adminuserspage;
	@Test(description="user is trying to add new admin user")
	public void verifyAdditionOfNewAdminUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		home = loginpage.loginBtnClick();
		
		adminuserspage = home.clickAdminUsersMoreInfo();
				
		RandomDataUtility randomData = new RandomDataUtility();
		String adminUserName = randomData.randomUserName();//ExcelUtility.readStringData(0, 0, "AdminUsers");
		String adminPassword = randomData.randomPassword();//ExcelUtility.readStringData(0, 1, "AdminUsers");
		adminuserspage.newButtonClick().enterAdminUserName(adminUserName).enterAdminPassword(adminPassword).selectUsertType().saveBtnClick();
		boolean successMessageDisplayed = adminuserspage.isUserAddedSuccessMessageDisplayed();
		Assert.assertTrue(successMessageDisplayed, Constant.ADDNEWADMINERROR);
	}
	
	@Test(description="user is trying to search admin users")
	public void verifyAdminUserSearch() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		home = loginpage.loginBtnClick();
		adminuserspage = home.clickAdminUsersMoreInfo();
		adminuserspage.mainSearchBtnClick().enterSearchAdminUserName().selectUserType().searchAdminUserBtnClick();
		
		String searchedUserName = "chippy";
		String actualUserName = adminuserspage.getSearchedUserName();
		Assert.assertEquals(searchedUserName, actualUserName, Constant.ADMINUSERSEARCHERROR);
	}

}
