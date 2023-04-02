package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductReviewDisplayed() {
		waitForElementVisible(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_MESSAGE);
		return isElementDisplayed(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_MESSAGE);
	}

}
