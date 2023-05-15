package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.CompareProductPageUI;

public class CompareProductPageObject extends BasePage {
	private WebDriver driver;

	public CompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCompareProductNameDisplayed(String textValue) {
		waitForElementVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_NAME, textValue);
		return isElementDisplayed(driver, CompareProductPageUI.COMPARE_PRODUCT_NAME, textValue);
	}

	public boolean isCompareProductNameUnDisplayed(String textValue) {
		waitForElementInVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_NAME, textValue);
		return isElementUndisplayed(driver, CompareProductPageUI.COMPARE_PRODUCT_NAME, textValue);
	}

	public boolean isCompareProductInfoDisplayed(String classValue, String textValue) {
		waitForElementVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
		return isElementDisplayed(driver, CompareProductPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
	}

	public boolean isCompareProductInfoUnDisplayed(String classValue, String textValue) {
		waitForElementInVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
		return isElementUndisplayed(driver, CompareProductPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
	}

	public Object getRemoveButtonSize() {
		waitForElementVisible(driver, CompareProductPageUI.REMOVE_BUTTON);
		return getElementSize(driver, CompareProductPageUI.REMOVE_BUTTON);
	}
}
