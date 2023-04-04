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

	public void checkToShipToTheSameAddress() {
		waitForElementVisible(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS);
		checkToDefaultCheckboxOrRadio(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CheckoutPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, CheckoutPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void selectCountryName(String string) {
		waitForElementVisible(driver, CheckoutPageUI.COUNTRY);
		selectItemInCustomDropdown(driver, CheckoutPageUI.COUNTRY, "xpath=//option", string);
	}

	public boolean isCountrySelected() {
		waitForElementVisible(driver, CheckoutPageUI.COUNTRY_DROPDOWN);
		return isElementSelected(driver, CheckoutPageUI.COUNTRY_DROPDOWN);
	}

	public void inputToCityAddressTextbox(String cityAddress) {
		waitForElementVisible(driver, CheckoutPageUI.CITY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CITY_ADDRESS_TEXTBOX, cityAddress);
	}

	public void inputToAddressTextbox(String address) {
		waitForElementVisible(driver, CheckoutPageUI.ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.ADDRESS_TEXTBOX, address);
	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, CheckoutPageUI.ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.ZIP_CODE_TEXTBOX, zipCode);
	}

	public void inputToPhoneTextbox(String phone) {
		waitForElementVisible(driver, CheckoutPageUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.PHONE_TEXTBOX, phone);
	}

	public void clickToContinueButtonAtBillingAddress() {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BILLING_ADDRESS);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BILLING_ADDRESS);
	}

	public void clickToContinueButtonAtShippingMethod() {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_SHIPPING_METHOD);
		clickToElement(driver, CheckoutPageUI.CONTINUE_SHIPPING_METHOD);
	}

	public void clickToContinueButtonAtPaymentMethod() {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_PAYMENT_METHOD);
		clickToElement(driver, CheckoutPageUI.CONTINUE_PAYMENT_METHOD);
	}

	public boolean isPaymentInfoDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_INFO_LOAD);
		return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_INFO_LOAD);
	}

	public void clickToContinueButtonAtPaymenInfo() {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_PAYMENT_INFO);
		clickToElement(driver, CheckoutPageUI.CONTINUE_PAYMENT_INFO);
	}

	public boolean isBillingInfoDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_INFO_WRAP);
		return isElementDisplayed(driver, CheckoutPageUI.BILLING_INFO_WRAP);
	}

	public boolean isShippingInfoDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.SHIPPING_INFO_WRAP);
		return isElementDisplayed(driver, CheckoutPageUI.SHIPPING_INFO_WRAP);
	}

	public boolean isPaymentMethodDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_METHOD_INFO);
		return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_METHOD_INFO);
	}

	public boolean isShippingMethodDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_INFO);
		return isElementDisplayed(driver, CheckoutPageUI.SHIPPING_METHOD_INFO);
	}

	public String getSKUText() {
		waitForElementVisible(driver, CheckoutPageUI.SKU_NUMBER);
		return getElementText(driver, CheckoutPageUI.SKU_NUMBER);
	}

	public String getProductName() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME);
		return getElementText(driver, CheckoutPageUI.PRODUCT_NAME);
	}

	public String getPrice() {
		waitForElementVisible(driver, CheckoutPageUI.PRICE);
		return getElementText(driver, CheckoutPageUI.PRICE);
	}

	public String getQauntity() {
		waitForElementVisible(driver, CheckoutPageUI.QUANTITY);
		return getElementText(driver, CheckoutPageUI.QUANTITY);
	}

	public String getProductTotal() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_TOTAL);
		return getElementText(driver, CheckoutPageUI.PRODUCT_TOTAL);
	}

	public boolean isGiftWrappingDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.GIFT_WRAPPING);
		return isElementDisplayed(driver, CheckoutPageUI.GIFT_WRAPPING);
	}

	public String getSubTotal() {
		waitForElementVisible(driver, CheckoutPageUI.SUB_TOTAL);
		return getElementText(driver, CheckoutPageUI.SUB_TOTAL);
	}

	public String getShippingCost() {
		waitForElementVisible(driver, CheckoutPageUI.SHIPPING_COST);
		return getElementText(driver, CheckoutPageUI.SHIPPING_COST);
	}

	public String getTaxValue() {
		waitForElementVisible(driver, CheckoutPageUI.TAX_VALUE);
		return getElementText(driver, CheckoutPageUI.TAX_VALUE);
	}

	public String getOrderTotal() {
		waitForElementVisible(driver, CheckoutPageUI.ORDER_TOTAL);
		return getElementText(driver, CheckoutPageUI.ORDER_TOTAL);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
	}

	public boolean isThankYouMessageDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.THANK_YOU_MESSAGE);
		return isElementDisplayed(driver, CheckoutPageUI.THANK_YOU_MESSAGE);
	}

	public boolean isOrderSuccessMessageDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	}

	public boolean isOrderLinkEnable() {
		waitForElementVisible(driver, CheckoutPageUI.OREDER_LINK);
		return isElementEnable(driver, CheckoutPageUI.OREDER_LINK);
	}

	public void checkCreditCart() {
		waitForElementVisible(driver, CheckoutPageUI.CREDIT_CART_BOX);
		checkToDefaultCheckboxOrRadio(driver, CheckoutPageUI.CREDIT_CART_BOX);
	}

	public void selectCreditCart(String string) {
		waitForElementVisible(driver, CheckoutPageUI.CREDIT_CART);
		selectItemInCustomDropdown(driver, CheckoutPageUI.CREDIT_CART, "xpath=//option", string);
	}

	public boolean isCreditCartSelected() {
		waitForElementVisible(driver, CheckoutPageUI.CREDIT_CART_DROPDOWN);
		return isElementSelected(driver, CheckoutPageUI.CREDIT_CART_DROPDOWN);
	}

	public void inputToCartNameTextbox(String cardName) {
		waitForElementVisible(driver, CheckoutPageUI.CART_NAME_TEXTOBX);
		sendkeyToElement(driver, CheckoutPageUI.CART_NAME_TEXTOBX, cardName);
	}

	public void inputToCartNumberTextbox(String cardNumber) {
		waitForElementVisible(driver, CheckoutPageUI.CART_NUMBER_TEXTOBX);
		sendkeyToElement(driver, CheckoutPageUI.CART_NUMBER_TEXTOBX, cardNumber);
	}

	public void selectExpireMonth(String string) {
		waitForElementVisible(driver, CheckoutPageUI.EXPIRE_MONTH);
		selectItemInCustomDropdown(driver, CheckoutPageUI.EXPIRE_MONTH, "xpath=//option", string);
	}

	public void selectExpireYear(String string) {
		waitForElementVisible(driver, CheckoutPageUI.EXPIRE_YEAR);
		selectItemInCustomDropdown(driver, CheckoutPageUI.EXPIRE_YEAR, "xpath=//option", string);
	}

	public void inputToCartCodeTextbox(String cardCode) {
		waitForElementVisible(driver, CheckoutPageUI.CART_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CART_CODE_TEXTBOX, cardCode);
	}

	public void selectNewAddress(String string) {
		waitForElementVisible(driver, CheckoutPageUI.NEW_ADDRESS);
		selectItemInCustomDropdown(driver, CheckoutPageUI.NEW_ADDRESS, "xpath=//option", string);
	}

	public void checkNextDayAir() {
		waitForElementVisible(driver, CheckoutPageUI.NEXTDAY_AIR);
		checkToDefaultCheckboxOrRadio(driver, CheckoutPageUI.NEXTDAY_AIR);
	}

	public boolean isNextDayAirDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.NEXTDAY_AIR);
		return isElementDisplayed(driver, CheckoutPageUI.NEXTDAY_AIR);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, CheckoutPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, CheckoutPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getPageGeneratorManager().getCustomerInfoPage(driver);
	}

}
