package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.NotebooksPageUI;

public class NotebooksPageObject extends BasePage {
	private WebDriver driver;

	public NotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getProductSize() {
		waitForElementVisible(driver, NotebooksPageUI.PRODUCT_SIZE);
		return getElementSize(driver, NotebooksPageUI.PRODUCT_SIZE);
	}

	public void waitSeconds() {
		sleepInSecond(2);
	}

	public void clickToWishlistAppleMacbookButton() {
		waitForElementClickable(driver, NotebooksPageUI.APPLE_WISH_LIST_BUTTON);
		clickToElement(driver, NotebooksPageUI.APPLE_WISH_LIST_BUTTON);
	}

	public String getAddWislistSuccessMessage() {
		waitForElementVisible(driver, NotebooksPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
		return getElementText(driver, NotebooksPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
	}

	public void clickToCloseSuccessMessage() {
		waitForElementClickable(driver, NotebooksPageUI.CLOSE_SUCCESS_MESSAGE);
		clickToElement(driver, NotebooksPageUI.CLOSE_SUCCESS_MESSAGE);
	}

	public void waitForSuccessMessageInvisible() {
		waitForElementInVisible(driver, NotebooksPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
	}

	public void clickToAppleMacbookProduct() {
		waitForElementClickable(driver, NotebooksPageUI.APPLE_PRODUCT);
		clickToElement(driver, NotebooksPageUI.APPLE_PRODUCT);
	}

	public void backToPreviousPage() {
		backToPage(driver);
	}

	public void clickToAsusProduct() {
		waitForElementClickable(driver, NotebooksPageUI.ASUS_PRODUCT);
		clickToElement(driver, NotebooksPageUI.ASUS_PRODUCT);
	}

	public void clickToHPEnvyProduct() {
		waitForElementClickable(driver, NotebooksPageUI.HP_ENVY_PRODUCT);
		clickToElement(driver, NotebooksPageUI.HP_ENVY_PRODUCT);
	}

	public void clickToHPSpectreProduct() {
		waitForElementClickable(driver, NotebooksPageUI.HP_SPECTRE_PRODUCT);
		clickToElement(driver, NotebooksPageUI.HP_SPECTRE_PRODUCT);
	}

	public void clickToSamsungProduct() {
		waitForElementClickable(driver, NotebooksPageUI.SAMSUNG_PRODUCT);
		clickToElement(driver, NotebooksPageUI.SAMSUNG_PRODUCT);
	}

	public void clickToWishlistButton() {
		waitForElementClickable(driver, NotebooksPageUI.WISH_LIST_BUTTON);
		clickToElement(driver, NotebooksPageUI.WISH_LIST_BUTTON);
	}

	public void waitForSecond() {
		sleepInSecond(3);
	}

	public void inputToQuantityTextbox(String string) {
		waitForElementVisible(driver, NotebooksPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver, NotebooksPageUI.QUANTITY_TEXTBOX, string);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, NotebooksPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, NotebooksPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToPagerButton(String classValue) {
		waitForElementClickable(driver, NotebooksPageUI.PAGE_BUTTON, classValue);
		clickToElement(driver, NotebooksPageUI.PAGE_BUTTON, classValue);
	}

	public String getAddToCartSuccessMessage() {
		waitForElementVisible(driver, NotebooksPageUI.ADD_CART_SUCCESS_MESSAGE);
		return getElementText(driver, NotebooksPageUI.ADD_CART_SUCCESS_MESSAGE);
	}

	public boolean isPageButtonDisplayed(String classValue) {
		return isElementDisplayed(driver, NotebooksPageUI.PAGE_BUTTON, classValue);
	}

}
