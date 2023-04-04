package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register button")
	public void clickToRegisterButton(String valueItem) {
		waitForElementClickable(driver, RegisterPageUI.DYNAMIC_BUTTON_BY_ID, valueItem);
		clickToElement(driver, RegisterPageUI.DYNAMIC_BUTTON_BY_ID, valueItem);
	}

	@Step("Get Error Message At Fields")
	public String getErrorMessageWithDynamicValue(String errorMessage) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessage);
		return getElementText(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessage);
	}

	@Step("Enter to Fields textbox with value is {0}")
	public void inputToTextboxByID(String textboxID, String value) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_TEXTOBX_BY_ID, textboxID);
		sendkeyToElement(driver, RegisterPageUI.DYNAMIC_TEXTOBX_BY_ID, value, textboxID);
	}

	@Step("Click to Radio Button with value is {0}")
	public void clickToRadioButtonByID(String radioButtonByID) {
		waitForElementClickable(driver, RegisterPageUI.DYNAMIC_TEXTOBX_BY_ID, radioButtonByID);
		checkToDefaultCheckboxOrRadio(driver, RegisterPageUI.DYNAMIC_TEXTOBX_BY_ID, radioButtonByID);
	}

	@Step("Click to Radio Button with value is {0}")
	public void selectToDropdownByName(String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, RegisterPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, RegisterPageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
	}

	@Step("Verify Register success message is displayed")
	public boolean registerSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public LoginPageObject openLoginPage() {
		waitForElementClickable(driver, RegisterPageUI.LOGIN_LINK);
		clickToElement(driver, RegisterPageUI.LOGIN_LINK);
		return PageGeneratorManager.getPageGeneratorManager().getLoginPage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE_ERROR);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE_ERROR);
	}

}
