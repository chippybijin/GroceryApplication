package textscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainprojectcore.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageContactTest extends MainProjectBase{
	HomePage home;
	ManageContactPage manageContactPage;
	@Test(description="user is trying to manage contacts")
	public void verifyManageContactAction() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "GroceryAppLogin");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryAppLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(userNameValue).enterPassword(passwordValue);
		home = loginpage.loginBtnClick();
		
		manageContactPage = home.clickManageContachsMoreInfo();
		
		manageContactPage.contactEditButtonClick();
		RandomDataUtility randomData = new RandomDataUtility();
		String phoneNumber = randomData.randomMobileNumber();
		String NewAddress = ExcelUtility.readStringData(0, 0, "ManageContactAddress");
		manageContactPage.enterNewPhoneNumber(phoneNumber).enterNewAddress(NewAddress).manageContactUpdateButtonClick();
		//String actualPhoneNumberAdded = "566";
		String phoneNumberAdded = manageContactPage.getUpdatedPhoneNumber();
		Assert.assertEquals(phoneNumber, phoneNumberAdded, Constant.MANAGECONTACTERROR);
	}
}
