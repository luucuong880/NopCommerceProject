package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.AddressPageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddButton() {
		waitForElementVisible(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);

	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, AddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
	}

	public void selectCountryDropDownList(String countryName) {
		waitForElementVisible(driver, AddressPageUI.COUNTRY_SELECT);
		selectItemInCustomDropdown(driver, AddressPageUI.COUNTRY_SELECT, "xpath=//option", countryName);

	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, AddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.CITY_TEXTBOX, city);

	}

	public void inputToAddressTextbox(String address) {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_TEXTBOX, address);

	}

	public void inputToZipCodeTextbox(String code) {
		waitForElementVisible(driver, AddressPageUI.CODE_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.CODE_TEXTBOX, code);

	}

	public void inputToPhoneTextbox(String phone) {
		waitForElementVisible(driver, AddressPageUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.PHONE_TEXTBOX, phone);

	}

	public void clickToSaveAddressButton() {
		waitForElementVisible(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);

	}

	public String getNameMessage() {
		waitForElementVisible(driver, AddressPageUI.NAME_MESSAGE);
		return getElementText(driver, AddressPageUI.NAME_MESSAGE);

	}

	public String getEmailMessage() {
		waitForElementVisible(driver, AddressPageUI.EMAIL_MESSAGE);
		return getElementText(driver, AddressPageUI.EMAIL_MESSAGE);

	}

	public String getPhoneMessage() {
		waitForElementVisible(driver, AddressPageUI.PHONE_MESSAGE);
		return getElementText(driver, AddressPageUI.PHONE_MESSAGE);

	}

	public String getAddressMessage() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_MESSAGE);
		return getElementText(driver, AddressPageUI.ADDRESS_MESSAGE);

	}

	public String getCityZipCodeMessage() {
		waitForElementVisible(driver, AddressPageUI.CITY_MESSAGE);
		return getElementText(driver, AddressPageUI.CITY_MESSAGE);

	}

	public String getCountryMessage() {
		waitForElementVisible(driver, AddressPageUI.COUNTRY_MESSAGE);
		return getElementText(driver, AddressPageUI.COUNTRY_MESSAGE);

	}

}
