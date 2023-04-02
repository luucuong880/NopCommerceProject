package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.OrderPageUI;

public class OrderPageObject extends BasePage {
	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDetailsButtonEnable() {
		waitForElementVisible(driver, OrderPageUI.DETAILS_BUTTON);
		return isElementDisplayed(driver, OrderPageUI.DETAILS_BUTTON);
	}

	public void clickToDetailsButton() {
		waitForElementClickable(driver, OrderPageUI.DETAILS_BUTTON);
		clickToElement(driver, OrderPageUI.DETAILS_BUTTON);
	}

	public boolean isOrderOverviewDisplayed() {
		waitForElementVisible(driver, OrderPageUI.ORDER_OVERVIEW);
		return isElementDisplayed(driver, OrderPageUI.ORDER_OVERVIEW);
	}

	public boolean isBillingInfoDisplayed() {
		waitForElementVisible(driver, OrderPageUI.BILLING_INFO);
		return isElementDisplayed(driver, OrderPageUI.BILLING_INFO);
	}

	public boolean isShippingInfoDisplayed() {
		waitForElementVisible(driver, OrderPageUI.SHIPPING_INFO);
		return isElementDisplayed(driver, OrderPageUI.SHIPPING_INFO);
	}

	public boolean isPaymentMethodDisplayed() {
		waitForElementVisible(driver, OrderPageUI.PAYMENT_METHOD);
		return isElementDisplayed(driver, OrderPageUI.PAYMENT_METHOD);
	}

	public boolean isShippingMethodDisplayed() {
		waitForElementVisible(driver, OrderPageUI.SHIPPING_METHOD);
		return isElementDisplayed(driver, OrderPageUI.SHIPPING_METHOD);
	}

	public String getSKUText() {
		waitForElementVisible(driver, OrderPageUI.SKU_NUMBER);
		return getElementText(driver, OrderPageUI.SKU_NUMBER);
	}

	public String getProductName() {
		waitForElementVisible(driver, OrderPageUI.PRODUCT_NAME);
		return getElementText(driver, OrderPageUI.PRODUCT_NAME);
	}

	public String getPrice() {
		waitForElementVisible(driver, OrderPageUI.PRICE);
		return getElementText(driver, OrderPageUI.PRICE);
	}

	public String getQauntity() {
		waitForElementVisible(driver, OrderPageUI.QUANTITY);
		return getElementText(driver, OrderPageUI.QUANTITY);
	}

	public String getProductTotal() {
		waitForElementVisible(driver, OrderPageUI.PRODUCT_TOTAL);
		return getElementText(driver, OrderPageUI.PRODUCT_TOTAL);
	}

	public String getGiftWrapping() {
		waitForElementVisible(driver, OrderPageUI.GIFT_WRAPPING);
		return getElementText(driver, OrderPageUI.GIFT_WRAPPING);
	}

	public String getSubTotal() {
		waitForElementVisible(driver, OrderPageUI.SUB_TOTAL);
		return getElementText(driver, OrderPageUI.SUB_TOTAL);
	}

	public String getShippingCost() {
		waitForElementVisible(driver, OrderPageUI.SHIPPING_COST);
		return getElementText(driver, OrderPageUI.SHIPPING_COST);
	}

	public String getTaxValue() {
		waitForElementVisible(driver, OrderPageUI.TAX_VALUE);
		return getElementText(driver, OrderPageUI.TAX_VALUE);
	}

	public String getOrderTotal() {
		waitForElementVisible(driver, OrderPageUI.ORDER_TOTAL);
		return getElementText(driver, OrderPageUI.ORDER_TOTAL);
	}

	public CartPageObject clickToReOrderButton() {
		waitForElementClickable(driver, OrderPageUI.RE_ORDER_BUTTON);
		clickToElement(driver, OrderPageUI.RE_ORDER_BUTTON);
		return PageGeneraterManager.getCartPage(driver);
	}

	public void clickToDetailSecondButton() {
		waitForElementClickable(driver, OrderPageUI.DETAILS_SECOND_BUTTON);
		clickToElement(driver, OrderPageUI.DETAILS_SECOND_BUTTON);
	}
}
