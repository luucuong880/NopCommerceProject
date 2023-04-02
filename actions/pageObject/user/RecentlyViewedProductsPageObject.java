package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPageObject extends BasePage {
	private WebDriver driver;

	public RecentlyViewedProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getProductTitle() {
		waitForElementVisible(driver, RecentlyViewedProductsPageUI.PRODUCT_TITLE);
		return getElementSize(driver, RecentlyViewedProductsPageUI.PRODUCT_TITLE);
	}
}
