package pageUI.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneraterManager;
import pageObject.user.CheckoutPageObject;
import pageObject.user.DesktopPageObject;

public class CartPageObject extends BasePage {
	private WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitleText() {
		waitForElementVisible(driver, CartPageUI.PAGE_TITLE_MESSAGE);
		return getElementText(driver, CartPageUI.PAGE_TITLE_MESSAGE);
	}

	public DesktopPageObject clickToEditButton() {
		waitForElementClickable(driver, CartPageUI.EDIT_BUTTON);
		clickToElement(driver, CartPageUI.EDIT_BUTTON);
		return PageGeneraterManager.getDesktopPage(driver);
	}

	public String getProductsName() {
		waitForElementVisible(driver, CartPageUI.PRODUCTS_NAME);
		return getElementText(driver, CartPageUI.PRODUCTS_NAME);
	}

	public String getProductsPrice() {
		waitForElementVisible(driver, CartPageUI.PRODUCTS_PRICE);
		return getElementText(driver, CartPageUI.PRODUCTS_PRICE);
	}

	public String getTotalPrice() {
		waitForElementVisible(driver, CartPageUI.TOTAL_PRICE);
		return getElementText(driver, CartPageUI.TOTAL_PRICE);
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, CartPageUI.REMOVE_BUTTON);
		clickToElement(driver, CartPageUI.REMOVE_BUTTON);
	}

	public String getOrderMessage() {
		waitForElementVisible(driver, CartPageUI.ORDER_MESSAGE);
		return getElementText(driver, CartPageUI.ORDER_MESSAGE);
	}

	public void inputToQuantityText(String string) {
		waitForElementVisible(driver, CartPageUI.QUANTITY_TEXT);
		sendkeyToElement(driver, CartPageUI.QUANTITY_TEXT, string);
	}

	public void clickToUpdateShoppingButton() {
		waitForElementClickable(driver, CartPageUI.UPDATE_SHOPPING_BUTTON);
		clickToElement(driver, CartPageUI.UPDATE_SHOPPING_BUTTON);
	}

	public CheckoutPageObject clickToCheckoutButton() {
		waitForElementClickable(driver, CartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, CartPageUI.CHECKOUT_BUTTON);
		return PageGeneraterManager.getCheckoutPage(driver);
	}

	public void selectGiftWrapping(String string) {
		waitForElementVisible(driver, CartPageUI.GIFT_WRAPPING);
		selectItemInCustomDropdown(driver, CartPageUI.GIFT_WRAPPING, "xpath=//option", string);
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
}
