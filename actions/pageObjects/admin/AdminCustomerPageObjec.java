package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminCreateNewCustomerPageUI;

public class AdminCustomerPageObjec extends BasePage {
	private WebDriver driver;

	public AdminCustomerPageObjec(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String userEmailAddress) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.EMAIL_TEXTBOX, userEmailAddress);
	}

	public void inputToPasswordTextbox(String userPassword) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.PASSWORD_TEXTBOX, userPassword);
	}

	public void inputToFirstNameTextbox(String userFirstName) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.FIRST_NAME_TEXTBOX, userFirstName);
	}

	public void inputToLastNameTextbox(String userLastName) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.LAST_NAME_TEXTBOX, userLastName);
	}

	public void checkGenderRadio() {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.GENDER_RADIO);
		checkToDefaultCheckboxOrRadio(driver, AdminCreateNewCustomerPageUI.GENDER_RADIO);
	}

	public boolean isGenderSelectedDisplayed() {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.GENDER_RADIO);
		return isElementDisplayed(driver, AdminCreateNewCustomerPageUI.GENDER_RADIO);
	}

	public void inputToDateOfBirth(String string) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, string);
	}

	public void checkActiveBox() {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.ACTIVE_BOX);
		checkToDefaultCheckboxOrRadio(driver, AdminCreateNewCustomerPageUI.ACTIVE_BOX);
	}

	public boolean isActiveDisplayed() {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.ACTIVE_BOX);
		return isElementDisplayed(driver, AdminCreateNewCustomerPageUI.ACTIVE_BOX);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.COMPANY_TEXTBOX, company);
	}

	public void inputToAdminComment(String string) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.ADMIN_COMMENT);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.ADMIN_COMMENT, string);
	}

	public void clickToSaveAndContinueButton() {
		waitForElementClickable(driver, AdminCreateNewCustomerPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminCreateNewCustomerPageUI.SAVE_BUTTON);
		sleepInSecond(3);
	}

	public boolean getSuccessMessage() {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, AdminCreateNewCustomerPageUI.SUCCESS_MESSAGE);
	}

	public AdminCustomerInfoPO clickToBackCustomerListButton() {
		waitForElementClickable(driver, AdminCreateNewCustomerPageUI.BACK_CUSTOMER_BUTTON);
		clickToElement(driver, AdminCreateNewCustomerPageUI.BACK_CUSTOMER_BUTTON);
		sleepInSecond(3);
		return PageGeneraterManager.getAdminCustomerInfoPage(driver);
	}

	public void clickToCloseSuccessMessage() {
		waitForElementClickable(driver, AdminCreateNewCustomerPageUI.CLOSE_BUTTON);
		clickToElement(driver, AdminCreateNewCustomerPageUI.CLOSE_BUTTON);
	}

}
