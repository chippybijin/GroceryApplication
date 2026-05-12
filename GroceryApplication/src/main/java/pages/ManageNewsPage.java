package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement addNewNewsButton;
	@FindBy(id="news") WebElement newsTxtField;
	@FindBy(xpath="//button[@type='submit' and @name='create']") WebElement saveButton;
	@FindBy(xpath="//div[text()[contains(.,'News Created Successfully')]]") WebElement newsAddedSuccessMessage;
	@FindBy(xpath="//a[contains(text(),'Search')]") WebElement searchMainButton;
	@FindBy(xpath="//input[@name='un']") WebElement searchText;
	@FindBy(xpath="//button[@type='submit' and @name='Search']") WebElement searchButton;
	@FindBy(xpath="//td[text()='Test News by chippy']") WebElement matchingNews;
	
	
	
	public ManageNewsPage newButtonClick() {
		addNewNewsButton.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String news) {
		newsTxtField.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage saveBtnClick() {
		saveButton.click();
		return this;
	}
	
	public boolean isNewsAddedSuccessMessageDisplayed() {
		return newsAddedSuccessMessage.isDisplayed();
	}
	
	public ManageNewsPage mainSearchBtnClick() {
		searchMainButton.click();
		searchText.sendKeys("Test News by chippy");
		return this;
	}
	
	public ManageNewsPage searchBtnClick() {
		searchButton.click();
		return this;
	}
	
	public String getSearchedNews() {
		return matchingNews.getText();
	}
}
