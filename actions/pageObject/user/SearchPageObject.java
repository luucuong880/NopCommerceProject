package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.SearchPageUI;

public class SearchPageObject extends BasePage {
	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchTextbox(String searchText) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchText);
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public Object getProductSize() {
		waitForElementVisible(driver, SearchPageUI.SIZE_OF_PRODUCT);
		return getElementSize(driver, SearchPageUI.SIZE_OF_PRODUCT);
	}

	public void checkToAdvancedSearch() {
		waitForElementVisible(driver, SearchPageUI.ADVANCED_SEARCH);
		checkToDefaultCheckboxOrRadio(driver, SearchPageUI.ADVANCED_SEARCH);
	}

	public boolean isAdvancedSearchDisplayed() {
		waitForElementVisible(driver, SearchPageUI.ADVANCED_SEARCH);
		return isElementDisplayed(driver, SearchPageUI.ADVANCED_SEARCH);
	}

	public void selectCategory(String textItem) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY);
		selectItemInCustomDropdown(driver, SearchPageUI.CATEGORY, "xpath=//option", textItem);
	}

	public boolean isCategorySelected() {
		waitForElementVisible(driver, SearchPageUI.CATEGORY_SELECTED);
		return isElementSelected(driver, SearchPageUI.CATEGORY_SELECTED);
	}

	public void checkToAutomaticallySearch() {
		waitForElementVisible(driver, SearchPageUI.AUTOMATICALLY_SEARCH);
		checkToDefaultCheckboxOrRadio(driver, SearchPageUI.AUTOMATICALLY_SEARCH);
	}

	public boolean isAutomaticallyDisplayed() {
		waitForElementVisible(driver, SearchPageUI.AUTOMATICALLY_SEARCH);
		return isElementDisplayed(driver, SearchPageUI.AUTOMATICALLY_SEARCH);
	}

	public void selectToManufacturer(String textItem) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTURER);
		selectItemInCustomDropdown(driver, SearchPageUI.MANUFACTURER, "xpath=//option", textItem);
	}

	public String getSearchErrorMessage() {
		waitForElementVisible(driver, SearchPageUI.ERROR_SEARCH_MESSAGE);
		return getElementText(driver, SearchPageUI.ERROR_SEARCH_MESSAGE);
	}

	public void refreshPage() {
		refreshCurrentPage(driver);

	}

	public String getSearchMessage() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_MESSAGE);
		return getElementText(driver, SearchPageUI.SEARCH_MESSAGE);
	}

}
