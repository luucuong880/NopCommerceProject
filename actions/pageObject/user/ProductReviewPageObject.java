package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneraterManager;
import pageUI.user.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage {

	private WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToRiviewTitle(String titleText) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_TITLE, titleText);
	}

	public void inputToReviewText(String text) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_TEXT, text);
	}

	public void checkToRating() {
		waitForElementVisible(driver, ProductReviewPageUI.RATING);
		checkToDefaultCheckboxOrRadio(driver, ProductReviewPageUI.RATING);
	}

	public void clickToReviewSubmit() {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_SUBMIT_BUTTON);
		clickToElement(driver, ProductReviewPageUI.REVIEW_SUBMIT_BUTTON);
	}

	public CustomerInfoPageObject clickToMyAccountButton() {
		waitForElementClickable(driver, ProductReviewPageUI.MY_ACCOUNT_BUTTON);
		clickToElement(driver, ProductReviewPageUI.MY_ACCOUNT_BUTTON);
		return PageGeneraterManager.getCustomerInfoPage(driver);
	}
}
