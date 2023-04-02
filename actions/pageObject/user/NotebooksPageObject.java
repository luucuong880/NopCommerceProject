package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.NotebooksPageUI;

public class NotebooksPageObject extends BasePage {
	private WebDriver driver;

	public NotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectToSortBy(String textItem) {
		waitForElementVisible(driver, NotebooksPageUI.SORT_BY);
		selectItemInCustomDropdown(driver, NotebooksPageUI.SORT_BY, "xpath=//option", textItem);
	}

	public boolean isSortByA_Z() {
		waitForElementVisible(driver, NotebooksPageUI.SORT_BY_A_Z);
		return isElementSelected(driver, NotebooksPageUI.SORT_BY_A_Z);
	}

	public boolean isSortByZ_A() {
		waitForElementVisible(driver, NotebooksPageUI.SORT_BY_Z_A);
		return isElementSelected(driver, NotebooksPageUI.SORT_BY_Z_A);
	}

	public boolean isSortByHigh_Low() {
		waitForElementVisible(driver, NotebooksPageUI.SORT_BY_H_L);
		return isElementSelected(driver, NotebooksPageUI.SORT_BY_H_L);
	}

	public boolean isSortByLow_High() {
		waitForElementVisible(driver, NotebooksPageUI.SORT_BY_L_H);
		return isElementSelected(driver, NotebooksPageUI.SORT_BY_L_H);
	}

	public void selectToPageSizeProduct(String textNumb) {
		waitForElementVisible(driver, NotebooksPageUI.PAGE_SIZE);
		selectItemInCustomDropdown(driver, NotebooksPageUI.PAGE_SIZE, "xpath=//option", textNumb);
	}

	public boolean isPageSizeProductSelected_3() {
		waitForElementVisible(driver, NotebooksPageUI.PAGE_SIZE_3);
		return isElementSelected(driver, NotebooksPageUI.PAGE_SIZE_3);
	}

	public boolean isPageSizeProductSelected_6() {
		waitForElementVisible(driver, NotebooksPageUI.PAGE_SIZE_6);
		return isElementSelected(driver, NotebooksPageUI.PAGE_SIZE_6);
	}

	public boolean isPageSizeProductSelected_9() {
		waitForElementVisible(driver, NotebooksPageUI.PAGE_SIZE_9);
		return isElementSelected(driver, NotebooksPageUI.PAGE_SIZE_9);
	}

	public boolean isEnableNextPageIcon() {
		waitForElementVisible(driver, NotebooksPageUI.NEXT_PAGE_ICON);
		return isElementEnable(driver, NotebooksPageUI.NEXT_PAGE_ICON);
	}

	public void clickToNextPageIcon() {
		waitForElementVisible(driver, NotebooksPageUI.NEXT_PAGE_BUTTON);
		clickToElement(driver, NotebooksPageUI.NEXT_PAGE_BUTTON);
	}

	public boolean isEnablePreviousIcon() {
		waitForElementVisible(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
		return isElementEnable(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
	}

	public void clickToPreviousIcon() {
		waitForElementVisible(driver, NotebooksPageUI.PREVIOUS_PAGE_BUTTON);
		clickToElement(driver, NotebooksPageUI.PREVIOUS_PAGE_BUTTON);
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

	public String getAddToCartSuccessMessage() {
		waitForElementVisible(driver, NotebooksPageUI.ADD_CART_SUCCESS_MESSAGE);
		return getElementText(driver, NotebooksPageUI.ADD_CART_SUCCESS_MESSAGE);
	}

}
