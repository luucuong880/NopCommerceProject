package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.OrderPageUI;

public class OrderPageObject extends BasePage {
	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getOrderOverviewText(String classValue) {
		waitForElementVisible(driver, OrderPageUI.ORDER_OVERVIEW, classValue);
		return getElementText(driver, OrderPageUI.ORDER_OVERVIEW, classValue);
	}

	public String getBillingShippingAddress(String textValue, String className) {
		waitForElementVisible(driver, OrderPageUI.BILLING_SHIPPING_ADDRESS, textValue, className);
		return getElementText(driver, OrderPageUI.BILLING_SHIPPING_ADDRESS, textValue, className);
	}

	public String getTotalsInfoText(String textValue) {
		waitForElementVisible(driver, OrderPageUI.TOTALS_INFO, textValue);
		return getElementText(driver, OrderPageUI.TOTALS_INFO, textValue);
	}

	public String getInfoText(String classValue) {
		waitForElementVisible(driver, OrderPageUI.INFO_BY_DYNAMICS_CLASS, classValue);
		return getElementText(driver, OrderPageUI.INFO_BY_DYNAMICS_CLASS, classValue);
	}

	public boolean isDetailsButtonDisplayed() {
		waitForElementVisible(driver, OrderPageUI.DETAILS_BUTTON);
		return isElementDisplayed(driver, OrderPageUI.DETAILS_BUTTON);
	}

	public boolean isDetailsButtonByTextDisplayed(String textValue) {
		waitForElementVisible(driver, OrderPageUI.DETAILS_BUTTON_BY_TEXT, textValue);
		return isElementDisplayed(driver, OrderPageUI.DETAILS_BUTTON_BY_TEXT, textValue);
	}

	public void clickToDetailButton() {
		waitForElementClickable(driver, OrderPageUI.DETAILS_BUTTON);
		clickToElement(driver, OrderPageUI.DETAILS_BUTTON);
	}

	public void clickToDetailButtonByText(String textValue) {
		waitForElementClickable(driver, OrderPageUI.DETAILS_BUTTON_BY_TEXT, textValue);
		clickToElement(driver, OrderPageUI.DETAILS_BUTTON_BY_TEXT, textValue);
	}

	public CartPageObject clickToReOrderButton() {
		waitForElementClickable(driver, OrderPageUI.RE_ORDER_BUTTON);
		clickToElement(driver, OrderPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getPageGeneratorManager().getCartPage(driver);
	}

}
