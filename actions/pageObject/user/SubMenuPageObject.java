package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.SubMenuPageUI;

public class SubMenuPageObject extends BasePage {
	private WebDriver driver;

	public SubMenuPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductReviewPageObject clickToAddReviewLink() {
		waitForElementClickable(driver, SubMenuPageUI.REVIEW_LINK);
		clickToElement(driver, SubMenuPageUI.REVIEW_LINK);
		return PageGeneratorManager.getPageGeneratorManager().getProductReviewPage(driver);
	}

	public boolean isPageButtonDisplayed(String classValue) {
		waitForElementVisible(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
		return isElementDisplayed(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
	}

	public boolean isPageButtonUnDisplayed(String classValue) {
		waitForElementInVisible(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
		return isElementUndisplayed(driver, SubMenuPageUI.PAGE_BUTTON, classValue);
	}

	public void clickToButtonByClassText(String classValue, String textValue) {
		waitForElementClickable(driver, SubMenuPageUI.BUTTON_BY_DINAMICS, classValue, textValue);
		clickToElement(driver, SubMenuPageUI.BUTTON_BY_DINAMICS, classValue, textValue);
	}

	public void clickAddToButtonsByTextProduct(String textValue, String textValue1) {
		waitForElementVisible(driver, SubMenuPageUI.ADD_TO_CART_BUTTON, textValue, textValue1);
		clickToElementByJS(driver, SubMenuPageUI.ADD_TO_CART_BUTTON, textValue, textValue1);
	}

}
