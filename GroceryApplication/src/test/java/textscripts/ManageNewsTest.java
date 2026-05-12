package textscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainprojectcore.MainProjectBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends MainProjectBase{
	HomePage home;
	ManageNewsPage manageNews;
	@Test(description="user is trying to manage news")
	public void verifyUserCanAbleToAddNews() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.loginBtnClick();
		
		manageNews = home.clickManageNewsMoreInfo();
		
		String news = ExcelUtility.readStringData(0, 0, "ManageNews");
		manageNews.newButtonClick().enterNews(news).saveBtnClick();
		boolean successMessageDisplayed = manageNews.isNewsAddedSuccessMessageDisplayed();
		Assert.assertTrue(successMessageDisplayed, Constant.ADDNEWSERROR);
	}
	
	@Test(description="user is trying to search newly added news")
	public void verifyNewsSearch() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.loginBtnClick();
		manageNews = home.clickManageNewsMoreInfo();
		manageNews.mainSearchBtnClick().searchBtnClick();
		String searchedNews = "Test News by chippy";
		String actualNews = manageNews.getSearchedNews();
		Assert.assertEquals(searchedNews, actualNews, Constant.NEWSSEARCHERROR);
	}
}
