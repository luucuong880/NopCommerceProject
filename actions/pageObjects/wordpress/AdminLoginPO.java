package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUI.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUsername) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getAdminDashboardPage(driver);
	}
}
