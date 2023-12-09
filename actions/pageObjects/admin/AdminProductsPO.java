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

	public void waitForAjaxBusyIconInvisible() {
		waitForElementInVisible(driver, AdminProductsPageUI.AJAX_BUSY_ICON);
	}

	public boolean isTrueIconDisplayed() {
		waitForElementVisible(driver, AdminProductsPageUI.TRUE_ICON);
		return isElementDisplayed(driver, AdminProductsPageUI.TRUE_ICON);
	}

	public boolean isProductDetailDisplayed() {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_DETAILS);
		return isElementDisplayed(driver, AdminProductsPageUI.PRODUCT_DETAILS);
	}

	public void reloadPage() {
		refreshPage(driver);
	}

	public void checkSubCategories() {
		waitForElementVisible(driver, AdminProductsPageUI.SUB_CATEGORIES);
		checkToDefaultCheckboxOrRadio(driver, AdminProductsPageUI.SUB_CATEGORIES);
	}

	public AdminEditProductPO clickToGoButton() {
		waitForElementClickable(driver, AdminProductsPageUI.GO_BUTTON);
		clickToElement(driver, AdminProductsPageUI.GO_BUTTON);
		return PageGeneraterManager.getAdminEditProductPage(driver);
	}

	public void clickToButtonByID(String buttonID) {
		waitForElementClickable(driver, AdminProductsPageUI.BUTTON_BY_ID, buttonID);
		clickToElement(driver, AdminProductsPageUI.BUTTON_BY_ID, buttonID);
	}

	public boolean isInfoProductsInTable(String text1, String text2) {
		waitForAllElementVisible(driver, AdminProductsPageUI.PRODUCTS_INFO, text1, text2);
		return isElementDisplayed(driver, AdminProductsPageUI.PRODUCTS_INFO, text1, text2);
	}

	public void selectDropDownByName(String idValue, String textValue) {
		waitForElementVisible(driver, AdminProductsPageUI.FIELD_SELECT_BY_NAME, idValue);
		selectItemInCustomDropdown(driver, AdminProductsPageUI.FIELD_SELECT_BY_NAME, "xpath=//option", textValue, idValue);
	}

	public String getEmptyDataTableText() {
		waitForElementVisible(driver, AdminProductsPageUI.EMPTY_DATA_TABLES);
		return getElementText(driver, AdminProductsPageUI.EMPTY_DATA_TABLES);
	}

	public String getProductDetailMessage() {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_DETAILS);
		return getElementText(driver, AdminProductsPageUI.PRODUCT_DETAILS);
	}

	public void clicktoSearchIcon() {
		waitForElementClickable(driver, AdminProductsPageUI.ICON_SEARCH);
		clickToElement(driver, AdminProductsPageUI.ICON_SEARCH);
	}

}
