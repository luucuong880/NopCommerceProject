package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.SubMenuPageUI;

public class SubMenuPageObject extends BasePage {
	private WebDriver driver;

	public SubMenuPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToViewModButton(String textValue) {
		waitForElementClickable(driver, SubMenuPageUI.VIEW_MOD_BUTTON, textValue);
		clickToElement(driver, SubMenuPageUI.VIEW_MOD_BUTTON, textValue);
	}

	public void checkToRadioOrCheckboxButton(String textValue, String textValue1) {
		waitForElementClickable(driver, SubMenuPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
		checkToDefaultCheckboxOrRadio(driver, SubMenuPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
		sleepInSecond(2);
	}

	public boolean isItemChecked(String textValue, String textValue1) {
		waitForElementVisible(driver, SubMenuPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
		return isElementDisplayed(driver, SubMenuPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
	}

	public String totalPrices() {
		waitForElementVisible(driver, SubMenuPageUI.TOTAL_PRICES);
		return getElementText(driver, SubMenuPageUI.TOTAL_PRICES);
	}

	public ProductReviewPageObject clickToAddReviewLink() {
		waitForElementClickable(driver, SubMenuPageUI.REVIEW_LINK);
		clickToElement(driver, SubMenuPageUI.REVIEW_LINK);
		return PageGeneratorManager.getPageGeneratorManager().getProductReviewPage(driver);
	}

	public void waitSeconds() {
		sleepInSecond(2);
	}

	public void clickToWishlistAppleMacbookButton() {
		waitForElementClickable(driver, SubMenuPageUI.APPLE_WISH_LIST_BUTTON);
		clickToElement(driver, SubMenuPageUI.APPLE_WISH_LIST_BUTTON);
	}

	public String getAddWislistSuccessMessage() {
		waitForElementVisible(driver, SubMenuPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
		return getElementText(driver, SubMenuPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
	}

	public void clickToCloseSuccessMessage() {
		waitForElementClickable(driver, SubMenuPageUI.CLOSE_SUCCESS_MESSAGE);
		clickToElement(driver, SubMenuPageUI.CLOSE_SUCCESS_MESSAGE);
	}

	public void waitForSuccessMessageInvisible() {
		waitForElementInVisible(driver, SubMenuPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
	}

	public void clickToAppleMacbookProduct() {
		waitForElementClickable(driver, SubMenuPageUI.APPLE_PRODUCT);
		clickToElement(driver, SubMenuPageUI.APPLE_PRODUCT);
	}

	public void backToPreviousPage() {
		backToPage(driver);
	}

	public void clickToAsusProduct() {
		waitForElementClickable(driver, SubMenuPageUI.ASUS_PRODUCT);
		clickToElement(driver, SubMenuPageUI.ASUS_PRODUCT);
	}

	public void clickToHPEnvyProduct() {
		waitForElementClickable(driver, SubMenuPageUI.HP_ENVY_PRODUCT);
		clickToElement(driver, SubMenuPageUI.HP_ENVY_PRODUCT);
	}

	public void clickToHPSpectreProduct() {
		waitForElementClickable(driver, SubMenuPageUI.HP_SPECTRE_PRODUCT);
		clickToElement(driver, SubMenuPageUI.HP_SPECTRE_PRODUCT);
	}

	public void clickToSamsungProduct() {
		waitForElementClickable(driver, SubMenuPageUI.SAMSUNG_PRODUCT);
		clickToElement(driver, SubMenuPageUI.SAMSUNG_PRODUCT);
	}

	public void clickToWishlistButton() {
		waitForElementClickable(driver, SubMenuPageUI.WISH_LIST_BUTTON);
		clickToElement(driver, SubMenuPageUI.WISH_LIST_BUTTON);
	}

	public void waitForSecond() {
		sleepInSecond(3);
	}

	public void inputToQuantityTextbox(String string) {
		waitForElementVisible(driver, SubMenuPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver, SubMenuPageUI.QUANTITY_TEXTBOX, string);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, SubMenuPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, SubMenuPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToPagerButton(String classValue) {
		waitForElementClickable(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
		clickToElement(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
	}

	public String getAddToCartSuccessMessage() {
		waitForElementVisible(driver, SubMenuPageUI.ADD_CART_SUCCESS_MESSAGE);
		return getElementText(driver, SubMenuPageUI.ADD_CART_SUCCESS_MESSAGE);
	}

	public boolean isPageButtonDisplayed(String classValue) {
		return isElementDisplayed(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
	}

}
