package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.CartPageUI;

public class CartPageObject extends BasePage {
	private WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DesktopPageObject clickToEditButton() {
		waitForElementClickable(driver, CartPageUI.EDIT_BUTTON);
		clickToElement(driver, CartPageUI.EDIT_BUTTON);
		return PageGeneratorManager.getPageGeneratorManager().getDesktopPage(driver);
	}

	public String getProductsName() {
		waitForElementVisible(driver, CartPageUI.PRODUCTS_NAME);
		return getElementText(driver, CartPageUI.PRODUCTS_NAME);
	}

	public String getPriceByDynamicValue(String classValue) {
		waitForElementVisible(driver, CartPageUI.PRICE_BY_DYNAMIC_CLASS, classValue);
		return getElementText(driver, CartPageUI.PRICE_BY_DYNAMIC_CLASS, classValue);
	}

	public void clickToButton(String classValue) {
		waitForElementClickable(driver, CartPageUI.BUTTON_BY_DYNAMIC_CLASS, classValue);
		clickToElement(driver, CartPageUI.BUTTON_BY_DYNAMIC_CLASS, classValue);
	}

	public String getOrderMessage() {
		waitForElementVisible(driver, CartPageUI.ORDER_MESSAGE);
		return getElementText(driver, CartPageUI.ORDER_MESSAGE);
	}

	public void inputToQuantityText(String string) {
		waitForElementVisible(driver, CartPageUI.QUANTITY_TEXT);
		sendkeyToElement(driver, CartPageUI.QUANTITY_TEXT, string);
	}

	public CheckoutPageObject openCheckoutPage(String classValue) {
		waitForElementClickable(driver, CartPageUI.BUTTON_BY_DYNAMIC_CLASS, classValue);
		clickToElement(driver, CartPageUI.BUTTON_BY_DYNAMIC_CLASS, classValue);
		return PageGeneratorManager.getPageGeneratorManager().getCheckoutPage(driver);
	}

	public String getOrderSubtotal() {
		waitForElementVisible(driver, CartPageUI.OREDER_SUBTOTAL);
		return getElementText(driver, CartPageUI.OREDER_SUBTOTAL);
	}

	public boolean isGiftWrappingselected() {
		waitForElementVisible(driver, CartPageUI.GIFT_WRAPPING_RADIO);
		return isElementSelected(driver, CartPageUI.GIFT_WRAPPING_RADIO);
	}

	public void checkToTermsOfService() {
		waitForElementVisible(driver, CartPageUI.TERMS_OF_SERVICE);
		checkToDefaultCheckboxOrRadio(driver, CartPageUI.TERMS_OF_SERVICE);
	}

	public boolean isTermsOfServiceChecked() {
		waitForElementVisible(driver, CartPageUI.TERMS_OF_SERVICE);
		return isElementDisplayed(driver, CartPageUI.TERMS_OF_SERVICE);
	}

	public boolean isProductsAttributeDisplayed(String attributeValue) {
		waitForElementVisible(driver, CartPageUI.PRODUCTS_ATTRIBUTE, attributeValue);
		return isElementDisplayed(driver, CartPageUI.PRODUCTS_ATTRIBUTE, attributeValue);
	}

	public boolean isButtonDisplayed(String classValue) {
		waitForElementVisible(driver, CartPageUI.BUTTON_BY_DYNAMIC_CLASS, classValue);
		return isElementDisplayed(driver, CartPageUI.BUTTON_BY_DYNAMIC_CLASS, classValue);
	}

	public boolean isEditButtonDisplayed() {
		waitForElementVisible(driver, CartPageUI.EDIT_BUTTON);
		return isElementDisplayed(driver, CartPageUI.EDIT_BUTTON);
	}

	public void inputToQuantityTextbox(String textValue) {
		waitForElementVisible(driver, CartPageUI.QUANTITY_TEXT);
		sendkeyToElement(driver, CartPageUI.QUANTITY_TEXT, textValue);
	}

}
