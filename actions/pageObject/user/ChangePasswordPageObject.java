package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneraterManager;
import pageUI.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPassword(String oldPass) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD, oldPass);
	}

	public void inputToNewPassword(String newPass) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD, newPass);

	}

	public void clickToChangePasswordButton() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public String getChangePasswordSuccess() {
		waitForElementVisible(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASS_MESSAGE);
		return getElementText(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASS_MESSAGE);
	}

	public void inputToConfirmNewPassword(String confirmPass) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD, confirmPass);
	}

	public void clickToCloseContent() {
		waitForElementVisible(driver, ChangePasswordPageUI.CLOSE_CONTENT);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_CONTENT);
	}

	public void waitForContentInvisible() {
		waitForElementInVisible(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementVisible(driver, ChangePasswordPageUI.LOGOUT_LINK);
		clickToElement(driver, ChangePasswordPageUI.LOGOUT_LINK);
		return PageGeneraterManager.getHomePage(driver);
	}
}
