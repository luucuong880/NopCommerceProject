package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.PageGeneraterManager;
import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageObjects.admin.AdminLoginPO;
import pageUI.user.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorEmailMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_MESSAGE_ERROR);
		return getElementText(driver, LoginPageUI.EMAIL_MESSAGE_ERROR);
	}

	public String getMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESS_MESSAGE_ERROR);
		return getElementText(driver, LoginPageUI.UNSUCCESS_MESSAGE_ERROR);
	}

	public String getMessagePageTitle() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_PAGE_TITLE);
		return getElementText(driver, LoginPageUI.MESSAGE_PAGE_TITLE);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, LoginPageUI.REGISTER_LINK);
		clickToElement(driver, LoginPageUI.REGISTER_LINK);
	}

	public HomePageObject clickLoginButton() {
		waitForElementVisible(driver, LoginPageUI.BUTTON_DYNAMIC);
		clickToElement(driver, LoginPageUI.BUTTON_DYNAMIC);
		sleepInSecond(2);
		return PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);
	}

	public AdminLoginPO openAdminLoginPage() {
		driver.get("https://admin-demo.nopcommerce.com/");
		return PageGeneraterManager.getAdminLoginPage(driver);
	}

}
