package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUIs.admin.AdminEditProductPageUI;

public class EditProductPageObject extends BasePage {
	private WebDriver driver;

	public EditProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDetailsMessageDisplayed() {
		waitForElementVisible(driver, AdminEditProductPageUI.PRODUCT_DETAILS_MESSAGE);
		return isElementDisplayed(driver, AdminEditProductPageUI.PRODUCT_DETAILS_MESSAGE);
	}

}
