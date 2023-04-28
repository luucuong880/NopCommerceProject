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

	public void clickToConfirmButton(String idValue) {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON_BY_ID, idValue);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON_BY_ID, idValue);
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

	public Object getMessageSize() {
		waitForElementVisible(driver, CheckoutPageUI.MESSAGE_SIZE);
		return getElementSize(driver, CheckoutPageUI.MESSAGE_SIZE);
	}

	public Object getInfoBillingShipping(String textValue, String className) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_INFO, textValue, className);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO, textValue, className);
	}

	public String getTitleSuccessMessage() {
		waitForElementVisible(driver, CheckoutPageUI.TITLE_SUCCESS_MESSAGE);
		return getElementText(driver, CheckoutPageUI.TITLE_SUCCESS_MESSAGE);
	}

}
