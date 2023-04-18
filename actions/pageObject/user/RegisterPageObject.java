package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import nopcommerce.user.BasePage;
import pageUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Register success message is displayed")
	public boolean registerSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
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

}
