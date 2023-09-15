package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUIs.admin.AdminEditProductPageUI;

public class AdminEditProductPO extends BasePage {
	private WebDriver driver;

	public AdminEditProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDetailsMessageDisplayed() {
		waitForElementVisible(driver, AdminEditProductPageUI.PRODUCT_DETAILS_MESSAGE);
		return isElementDisplayed(driver, AdminEditProductPageUI.PRODUCT_DETAILS_MESSAGE);
	}

}
