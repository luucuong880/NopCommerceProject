package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminAddNewAddressPageUI;

public class AddNewAddressPageObject extends BasePage {
	private WebDriver driver;

	public AddNewAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String userFirstName) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.FIRST_NAME_TEXTBOX, userFirstName);
	}

	public void inputToLastNameTextbox(String userLastName) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.LAST_NAME_TEXTBOX, userLastName);
	}

	public void inputToEmailTextbox(String userEmailAddress) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.EMAIL_TEXTBOX, userEmailAddress);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.COMPANY_TEXTBOX, company);
	}

	public void selectCountryName(String string) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.COUNTRY_NAME);
		selectItemInCustomDropdown(driver, AdminAddNewAddressPageUI.COUNTRY_NAME, "xpath=//option", string);
	}

	public boolean isCountrySelectedDisplayed() {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.COUNTRY_DROPDOWN);
		return isElementDisplayed(driver, AdminAddNewAddressPageUI.COUNTRY_DROPDOWN);
	}

	public void inputToCountryTextbox(String country) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.COUNTRY_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.COUNTRY_TEXTBOX, country);
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address_1) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.ADDRESSS_1_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.ADDRESSS_1_TEXTBOX, address_1);
	}

	public void inputToAddress2Textbox(String address_2) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.ADDRESSS_2_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.ADDRESSS_2_TEXTBOX, address_2);
	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.CODE_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.CODE_TEXTBOX, zipCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewAddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminAddNewAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminAddNewAddressPageUI.SAVE_BUTTON);
	}

	public void inputToAllAndClickSaveButton(String userFirstName, String userLastName, String userEmailAddress, String company, String city, String address_1, String address_2, String zipCode, String phoneNumber, String faxNumber) {
		sleepInSecond(3);
		inputToFirstNameTextbox(userFirstName);
		inputToLastNameTextbox(userLastName);
		inputToEmailTextbox(userEmailAddress);
		inputToCompanyTextbox(company);
		selectCountryName("Viet Nam");
		inputToCountryTextbox(company);
		inputToCityTextbox(city);
		inputToAddress1Textbox(address_1);
		inputToAddress2Textbox(address_2);
		inputToZipCodeTextbox(zipCode);
		inputToPhoneNumberTextbox(phoneNumber);
		inputToFaxNumberTextbox(faxNumber);
		clickToSaveButton();
	}

	public boolean isCountry_2_SelectedDisplayed() {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.COUNTRY_2_DROPDOWN);
		return isElementDisplayed(driver, AdminAddNewAddressPageUI.COUNTRY_2_DROPDOWN);
	}

	public void inputEditAndClickSaveButton(String userFirstName, String userLastName, String userEmailAddress, String company, String country, String city, String address_1, String address_2, String zipCode, String phoneNumber, String faxNumber) {
		inputToFirstNameTextbox(userFirstName);
		inputToLastNameTextbox(userLastName);
		inputToEmailTextbox(userEmailAddress);
		inputToCompanyTextbox(company);
		selectCountryName("Japan");
		inputToCityTextbox(city);
		inputToAddress1Textbox(address_1);
		inputToAddress2Textbox(address_2);
		inputToZipCodeTextbox(zipCode);
		inputToPhoneNumberTextbox(phoneNumber);
		inputToFaxNumberTextbox(faxNumber);
		clickToSaveButton();
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, AdminAddNewAddressPageUI.SUCCESS_MESSAGE);
	}

	public EditPageObject clickToBackCustomerDetailsButton() {
		waitForElementClickable(driver, AdminAddNewAddressPageUI.BACK_CUSTOMER_BUTTON);
		clickToElement(driver, AdminAddNewAddressPageUI.BACK_CUSTOMER_BUTTON);
		return PageGeneraterManager.getAdminEditPage(driver);
	}

	public EditPageObject clickToBackCustomerLink() {
		sleepInSecond(3);
		waitForElementClickable(driver, AdminAddNewAddressPageUI.BACK_CUSTOMER_LINK);
		clickToElement(driver, AdminAddNewAddressPageUI.BACK_CUSTOMER_LINK);
		return PageGeneraterManager.getAdminEditPage(driver);
	}
}
