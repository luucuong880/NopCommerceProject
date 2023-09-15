package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminProductsPageUI;

public class AdminProductsPO extends BasePage {
	private WebDriver driver;

	public AdminProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToProductsNameTextbox(String text) {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCTS_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.PRODUCTS_TEXTBOX, text);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductsPageUI.SEARCH_BUTTON);
	}

	public void waitForAjaxBusyIconInvisible() {
		waitForElementInVisible(driver, AdminProductsPageUI.AJAX_BUSY_ICON);
	}

	public String getProductsNameText() {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, AdminProductsPageUI.PRODUCT_NAME_TEXT);
	}

	public String getSKUText() {
		waitForElementVisible(driver, AdminProductsPageUI.SKU_TEXT);
		return getElementText(driver, AdminProductsPageUI.SKU_TEXT);
	}

	public String getPriceText() {
		waitForElementVisible(driver, AdminProductsPageUI.PRICE_TEXT);
		return getElementText(driver, AdminProductsPageUI.PRICE_TEXT);
	}

	public String getStockText() {
		waitForElementVisible(driver, AdminProductsPageUI.STOCK_TEXT);
		return getElementText(driver, AdminProductsPageUI.STOCK_TEXT);
	}

	public boolean isTrueIconDisplayed() {
		waitForElementVisible(driver, AdminProductsPageUI.TRUE_ICON);
		return isElementDisplayed(driver, AdminProductsPageUI.TRUE_ICON);
	}

	public void reloadPage() {
		refreshPage(driver);
	}

	public void selectCategory(String textItem) {
		waitForElementVisible(driver, AdminProductsPageUI.CATEGORY);
		selectItemInCustomDropdown(driver, AdminProductsPageUI.CATEGORY, "xpath=//option", textItem);
	}

	public boolean isCategorySelected() {
		waitForElementVisible(driver, AdminProductsPageUI.CATEGORY_DROPDOWN);
		return isElementSelected(driver, AdminProductsPageUI.CATEGORY_DROPDOWN);
	}

	public String getTableMessage() {
		waitForElementVisible(driver, AdminProductsPageUI.TABLE_MESSAGE);
		return getElementText(driver, AdminProductsPageUI.TABLE_MESSAGE);
	}

	public void checkSubCategories() {
		waitForElementVisible(driver, AdminProductsPageUI.SUB_CATEGORIES);
		checkToDefaultCheckboxOrRadio(driver, AdminProductsPageUI.SUB_CATEGORIES);
	}

	public void selectChildCategory(String text) {
		waitForElementVisible(driver, AdminProductsPageUI.CHILD_CATEGORY);
		selectItemInCustomDropdown(driver, AdminProductsPageUI.CHILD_CATEGORY, "xpath=//option", text);
	}

	public boolean isChildCategorySelected() {
		waitForElementVisible(driver, AdminProductsPageUI.CHILD_CATEGORY_DROPDOWN);
		return isElementSelected(driver, AdminProductsPageUI.CHILD_CATEGORY_DROPDOWN);
	}

	public void selectManufacturer(String string) {
		waitForElementVisible(driver, AdminProductsPageUI.MANUFACTURER);
		selectItemInCustomDropdown(driver, AdminProductsPageUI.MANUFACTURER, "xpath=//option", string);
	}

	public boolean isAppleManufacturerSelected() {
		waitForElementVisible(driver, AdminProductsPageUI.MANUFACTURER_DROPDOWN);
		return isElementSelected(driver, AdminProductsPageUI.MANUFACTURER_DROPDOWN);
	}

	public void inputToSKUTextbox(String string) {
		waitForElementClickable(driver, AdminProductsPageUI.SKU_TEXT_BOX);
		sendkeyToElement(driver, AdminProductsPageUI.SKU_TEXT_BOX, string);
	}

	public AdminEditProductPO clickToGoButton() {
		waitForElementClickable(driver, AdminProductsPageUI.GO_BUTTON);
		clickToElement(driver, AdminProductsPageUI.GO_BUTTON);
		return PageGeneraterManager.getAdminEditProductPage(driver);
	}

}
