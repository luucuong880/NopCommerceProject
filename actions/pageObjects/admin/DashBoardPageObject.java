package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminDashBoardPageUI;

public class DashBoardPageObject extends BasePage {
	private WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}

	public void waitForAjaxBusyInvisible() {
		waitForElementInVisible(driver, AdminDashBoardPageUI.AJAX_BUSY_ICON);
	}

	public void clickToCatalogButton() {
		waitForElementClickable(driver, AdminDashBoardPageUI.CATALOG_BUTTON);
		clickToElement(driver, AdminDashBoardPageUI.CATALOG_BUTTON);
	}

	public ProductsPageObject clickToProductsButton() {
		waitForElementClickable(driver, AdminDashBoardPageUI.PRODUCTS_BUTTON);
		clickToElement(driver, AdminDashBoardPageUI.PRODUCTS_BUTTON);
		return PageGeneraterManager.getProductsPage(driver);
	}
}