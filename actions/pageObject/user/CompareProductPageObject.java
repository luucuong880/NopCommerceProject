package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.CompareProductPageUI;

public class CompareProductPageObject extends BasePage {
	private WebDriver driver;

	public CompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isClearListButtonDisplayed() {
		waitForElementVisible(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
		return isElementDisplayed(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	public boolean isRemoveButtonDisplayed() {
		waitForElementVisible(driver, CompareProductPageUI.REMOVE_BUTTON);
		return isElementDisplayed(driver, CompareProductPageUI.REMOVE_BUTTON);
	}

	public boolean isCompareProductNameDisplayed() {
		waitForElementVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_NAME);
		return isElementDisplayed(driver, CompareProductPageUI.COMPARE_PRODUCT_NAME);
	}

	public String getPriceOfLenovoPC() {
		waitForElementVisible(driver, CompareProductPageUI.PRICE_OF_LENOVO);
		return getElementText(driver, CompareProductPageUI.PRICE_OF_LENOVO);
	}

	public String getPriceOfBuilOwnComputer() {
		waitForElementVisible(driver, CompareProductPageUI.PRICE_OF_BOC);
		return getElementText(driver, CompareProductPageUI.PRICE_OF_BOC);
	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	public String getCompareProductMessage() {
		waitForElementVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_MESSAGE);
		return getElementText(driver, CompareProductPageUI.COMPARE_PRODUCT_MESSAGE);
	}

	public void waitSeconds() {
		sleepInSecond(3);
	}
}
