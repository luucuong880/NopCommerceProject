package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
	private WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAdminEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public String getErrorEmailMessage() {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, AdminLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToAdminPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashBoardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getAdminDashBoardPage(driver);
	}

	public AdminDashBoardPO loginAsAdmin(String emailAddress, String password) {
		inputToAdminEmailTextbox(emailAddress);
		inputToAdminPasswordTextbox(password);
		return clickToLoginButton();
	}

}
