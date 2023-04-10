package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.AddressPageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementVisible(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);

	}

	public String getTextboxValueByClass(String textboxClass) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_TEXTBOX_BY_CLASS, textboxClass);
		return getElementText(driver, AddressPageUI.DYNAMIC_TEXTBOX_BY_CLASS, textboxClass);
	}

	public String getAlertMessageDisplayed() {
		waitForAlertPresence(driver);
		return getAlertText(driver);
	}

	public void acceptAlert() {
		acceptAlert(driver);
	}

	public String getBodyMessageText() {
		waitForElementVisible(driver, AddressPageUI.BODY_MESSAGE);
		return getElementText(driver, AddressPageUI.BODY_MESSAGE);
	}

}
