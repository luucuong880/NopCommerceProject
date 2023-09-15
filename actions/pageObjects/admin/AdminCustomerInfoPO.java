package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminCustomerInfoPageUI;

public class AdminCustomerInfoPO extends BasePage {
	private WebDriver driver;

	public AdminCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminCreateNewCustomerPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.ADD_NEW_BUTTON);
		sleepInSecond(5);
		return PageGeneraterManager.getAdminCreateNewCustomerPage(driver);
	}

	public void inputToEmailSearchTextbox(String userEmailAddress) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.EMAIL_SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.EMAIL_SEARCH_TEXTBOX, userEmailAddress);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.SEARCH_BUTTON);
	}

	public boolean isItemInTableDisplayed() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.TABLE);
		return isElementDisplayed(driver, AdminCustomerInfoPageUI.TABLE);
	}

	public void reloadPage() {
		refreshPage(driver);
		sleepInSecond(3);
	}

	public void inputToFirstNameSearchTextbox(String userFirstName) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.FIRST_NAME_SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.FIRST_NAME_SEARCH_TEXTBOX, userFirstName);
	}

	public void inputToLastNameSearchTextbox(String userLastName) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.LAST_NAME_SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.LAST_NAME_SEARCH_TEXTBOX, userLastName);
	}

	public void inputToCompanySearchTextbox(String company) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.COMPANY_SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.COMPANY_SEARCH_TEXTBOX, company);
	}

	public void selectMonthSearch(String string) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.MONTH);
		selectItemInCustomDropdown(driver, AdminCustomerInfoPageUI.MONTH, "xpath=//option", string);
	}

	public void selectDaySearch(String string) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.DAY);
		selectItemInCustomDropdown(driver, AdminCustomerInfoPageUI.DAY, "xpath=//option", string);
	}

	public boolean isMonthDisplayed() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.MONTH_SELECTED);
		return isElementDisplayed(driver, AdminCustomerInfoPageUI.MONTH_SELECTED);
	}

	public boolean isMonth2Displayed() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.MONTH_SELECTED_2);
		return isElementDisplayed(driver, AdminCustomerInfoPageUI.MONTH_SELECTED_2);
	}

	public boolean isDayDisplayed() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.DAY_SELECTED);
		return isElementDisplayed(driver, AdminCustomerInfoPageUI.DAY_SELECTED);
	}

	public AdminEditPO clickToEditButton() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.EDIT_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.EDIT_BUTTON);
		sleepInSecond(3);
		return PageGeneraterManager.getAdminEditPage(driver);
	}

	public void waitForAjaxLoading() {
		waitForElementInVisible(driver, AdminCustomerInfoPageUI.AJAX_BUSY_ICON);

	}

	public AdminAddNewAddressPO clickToEditAddressButton() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.EDIT_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.EDIT_ADDRESS_BUTTON);
		return PageGeneraterManager.getAdminAddNewAddressPage(driver);
	}

}
