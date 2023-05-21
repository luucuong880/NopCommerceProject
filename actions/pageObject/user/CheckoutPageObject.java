package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {
	private WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getInfoText(String classValue) {
		waitForElementVisible(driver, CheckoutPageUI.INFO_BY_DYNAMICS_CLASS, classValue);
		return getElementText(driver, CheckoutPageUI.INFO_BY_DYNAMICS_CLASS, classValue);
	}

	public String getBillingShippingAddress(String textValue, String className) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_SHIPPING_ADDRESS, textValue, className);
		return getElementText(driver, CheckoutPageUI.BILLING_SHIPPING_ADDRESS, textValue, className);
	}

	public String getTotalsInfoText(String classValue) {
		waitForElementVisible(driver, CheckoutPageUI.TOTALS_INFO, classValue);
		return getElementText(driver, CheckoutPageUI.TOTALS_INFO, classValue);
	}

	public void clickToContinueButton(String idValue) {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_ID, idValue);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_ID, idValue);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
	}

	public boolean isThankYouMessageDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.THANK_YOU_MESSAGE);
		return isElementDisplayed(driver, CheckoutPageUI.THANK_YOU_MESSAGE);
	}

	public String getProductNameText() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME);
		return getElementText(driver, CheckoutPageUI.PRODUCT_NAME);
	}

	public String getTitleSuccessMessage() {
		waitForElementVisible(driver, CheckoutPageUI.TITLE_SUCCESS_MESSAGE);
		return getElementText(driver, CheckoutPageUI.TITLE_SUCCESS_MESSAGE);
	}

	public boolean isOrderNumberDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER);
		return isElementDisplayed(driver, CheckoutPageUI.ORDER_NUMBER);
	}

}
