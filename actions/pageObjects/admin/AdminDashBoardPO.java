package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUIs.admin.AdminDashBoardPageUI;

public class AdminDashBoardPO extends BasePage {
	private WebDriver driver;

	public AdminDashBoardPO(WebDriver driver) {
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

}