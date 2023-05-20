package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {
	private WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getSKUText() {
		waitForElementVisible(driver, CheckoutPageUI.SKU_NUMBER);
		return getElementText(driver, CheckoutPageUI.SKU_NUMBER);
	}

	public String getBillingShippingAddress(String textValue, String className) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_SHIPPING_ADDRESS, textValue, className);
		return getElementText(driver, CheckoutPageUI.BILLING_SHIPPING_ADDRESS, textValue, className);
	}

	public String getPaymentShippingStatus(String className, String classValue) {
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_SHIPPING_METHOD, className, classValue);
		return getElementText(driver, CheckoutPageUI.PAYMENT_SHIPPING_METHOD, className, classValue);
	}

	public void clickToConfirmButton(String idValue) {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON_BY_ID, idValue);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON_BY_ID, idValue);
	}

	public boolean isThankYouMessageDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.THANK_YOU_MESSAGE);
		return isElementDisplayed(driver, CheckoutPageUI.THANK_YOU_MESSAGE);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, CheckoutPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, CheckoutPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getPageGeneratorManager().getCustomerInfoPage(driver);
	}

	public String getTitleSuccessMessage() {
		waitForElementVisible(driver, CheckoutPageUI.TITLE_SUCCESS_MESSAGE);
		return getElementText(driver, CheckoutPageUI.TITLE_SUCCESS_MESSAGE);
	}

}
