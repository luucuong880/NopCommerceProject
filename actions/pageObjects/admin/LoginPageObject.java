package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminLoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAdminEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToAdminPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public DashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getAdminDashBoardPage(driver);
	}

	public DashBoardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToAdminEmailTextbox(emailAddress);
		inputToAdminPasswordTextbox(password);
		return clickToLoginButton();
	}

}
