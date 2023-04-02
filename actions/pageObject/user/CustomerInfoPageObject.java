package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void checkToGenderMale() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_CHECKBOX);
		checkToDefaultCheckboxOrRadio(driver, CustomerInfoPageUI.GENDER_MALE_CHECKBOX);
	}

	public void checkToGenderFeMale() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_FEMALE_CHECKBOX);
		checkToDefaultCheckboxOrRadio(driver, CustomerInfoPageUI.GENDER_FEMALE_CHECKBOX);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTOBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRSTNAME_TEXTOBOX, firstName);
	}

	public void inputToLastNameTextbox(String lasttName) {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, lasttName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void selectDayDropdownList(String textItem) {
		waitForElementVisible(driver, CustomerInfoPageUI.DAY_SELECT);
		selectItemInCustomDropdown(driver, CustomerInfoPageUI.DAY_SELECT, "xpath=//option", textItem);
	}

	public void selectMonthDropdownList(String textItem) {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_SELECT);
		selectItemInCustomDropdown(driver, CustomerInfoPageUI.MONTH_SELECT, "xpath=//option", textItem);
	}

	public void selectYearDropdownList(String textItem) {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_SELECT);
		selectItemInCustomDropdown(driver, CustomerInfoPageUI.YEAR_SELECT, "xpath=//option", textItem);
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, CustomerInfoPageUI.LOGOUT_LINK);
		clickToElement(driver, CustomerInfoPageUI.LOGOUT_LINK);

	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	public OrderPageObject clickToOrdersButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.ORDER_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.ORDER_BUTTON);
		return PageGeneraterManager.getOrderPage(driver);
	}

}
