package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getChangePasswordSuccess() {
		waitForElementVisible(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASS_MESSAGE);
		return getElementText(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASS_MESSAGE);
	}

	public void clickToCloseContent() {
		waitForElementVisible(driver, ChangePasswordPageUI.CLOSE_CONTENT);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_CONTENT);
	}

	public String getErrorMessageAtPage() {
		waitForElementVisible(driver, ChangePasswordPageUI.ERROR_MESSAGE);
		return getElementText(driver, ChangePasswordPageUI.ERROR_MESSAGE);
	}

}
