package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	// Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ---------------------- Locators ----------------------

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearchBox;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;

	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	WebElement validProduct;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
	WebElement noProductMessage;

	// ---------------------- Action Methods ----------------------

	// Enter product name
	public void enterProductName(String productName) {
		txtSearchBox.clear();
		txtSearchBox.sendKeys(productName);
	}

	// Click Search button
	public void clickSearchButton() {
		btnSearch.click();
	}

	// Check valid product displayed
	public boolean isValidProductDisplayed() {
		return validProduct.isDisplayed();
	}

	// Get No Product message
	public String getNoProductMessage() {
		return noProductMessage.getText();
	}
}
