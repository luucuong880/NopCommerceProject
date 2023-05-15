package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.FootersPageUI;

public class FootersPageObject extends BasePage {
	private WebDriver driver;

	public FootersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchTextbox(String searchText) {
		waitForElementVisible(driver, FootersPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, FootersPageUI.SEARCH_TEXTBOX, searchText);
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, FootersPageUI.SEARCH_BUTTON);
		clickToElement(driver, FootersPageUI.SEARCH_BUTTON);
	}

	public void checkToAdvancedSearch() {
		waitForElementVisible(driver, FootersPageUI.ADVANCED_SEARCH);
		checkToDefaultCheckboxOrRadio(driver, FootersPageUI.ADVANCED_SEARCH);
	}

	public boolean isAdvancedSearchDisplayed() {
		waitForElementVisible(driver, FootersPageUI.ADVANCED_SEARCH);
		return isElementDisplayed(driver, FootersPageUI.ADVANCED_SEARCH);
	}

	public void selectCategory(String textItem) {
		waitForElementVisible(driver, FootersPageUI.CATEGORY);
		selectItemInCustomDropdown(driver, FootersPageUI.CATEGORY, "xpath=//option", textItem);
	}

	public boolean isCategorySelected() {
		waitForElementVisible(driver, FootersPageUI.CATEGORY_SELECTED);
		return isElementSelected(driver, FootersPageUI.CATEGORY_SELECTED);
	}

	public void checkToAutomaticallySearch() {
		waitForElementVisible(driver, FootersPageUI.AUTOMATICALLY_SEARCH);
		checkToDefaultCheckboxOrRadio(driver, FootersPageUI.AUTOMATICALLY_SEARCH);
	}

	public boolean isAutomaticallyDisplayed() {
		waitForElementVisible(driver, FootersPageUI.AUTOMATICALLY_SEARCH);
		return isElementDisplayed(driver, FootersPageUI.AUTOMATICALLY_SEARCH);
	}

	public void selectToManufacturer(String textItem) {
		waitForElementVisible(driver, FootersPageUI.MANUFACTURER);
		selectItemInCustomDropdown(driver, FootersPageUI.MANUFACTURER, "xpath=//option", textItem);
	}

	public String getSearchErrorMessage() {
		waitForElementVisible(driver, FootersPageUI.ERROR_SEARCH_MESSAGE);
		return getElementText(driver, FootersPageUI.ERROR_SEARCH_MESSAGE);
	}

	public void refreshPage() {
		refreshCurrentPage(driver);

	}

	public String getSearchMessage() {
		waitForElementVisible(driver, FootersPageUI.SEARCH_MESSAGE);
		return getElementText(driver, FootersPageUI.SEARCH_MESSAGE);
	}

	public boolean isCompareProductNameDisplayed(String textValue) {
		waitForElementVisible(driver, FootersPageUI.COMPARE_PRODUCT_NAME, textValue);
		return isElementDisplayed(driver, FootersPageUI.COMPARE_PRODUCT_NAME, textValue);
	}

	public boolean isCompareProductNameUnDisplayed(String textValue) {
		return isElementUndisplayed(driver, FootersPageUI.COMPARE_PRODUCT_NAME, textValue);
	}

	public boolean isCompareProductInfoDisplayed(String classValue, String textValue) {
		waitForElementVisible(driver, FootersPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
		return isElementDisplayed(driver, FootersPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
	}

	public boolean isCompareProductInfoUnDisplayed(String classValue, String textValue) {
		return isElementUndisplayed(driver, FootersPageUI.COMPARE_PRODUCT_INFO, classValue, textValue);
	}

	public Object getRemoveButtonSize() {
		waitForElementVisible(driver, FootersPageUI.REMOVE_BUTTON);
		return getElementSize(driver, FootersPageUI.REMOVE_BUTTON);
	}

}
