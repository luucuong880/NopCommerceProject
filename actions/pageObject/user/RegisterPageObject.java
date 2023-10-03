package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import nopcommerce.admin.PageGeneraterManager;
import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageObjects.admin.AdminLoginPO;
import pageUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Register success message is displayed")
	public String registerSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE_ERROR);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE_ERROR);
	}

	@Step("Click to Register button")
	public void clickToRegisterButton(String valueItem) {
		waitForElementClickable(driver, RegisterPageUI.DYNAMIC_BUTTON_BY_ID, valueItem);
		clickToElement(driver, RegisterPageUI.DYNAMIC_BUTTON_BY_ID, valueItem);
	}

	public AdminLoginPO openAdminLoginPage() {
		driver.get("https://admin-demo.nopcommerce.com/");
		return PageGeneraterManager.getAdminLoginPage(driver);
	}

	public HomePageObject clickToNopCommerceLogo() {
		waitForElementClickable(driver, RegisterPageUI.NOCOMMERCE_LOGO);
		clickToElement(driver, RegisterPageUI.NOCOMMERCE_LOGO);
		return PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);
	}

}
