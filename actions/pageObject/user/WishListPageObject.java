package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneraterManager;
import pageUI.user.CartPageObject;
import pageUI.user.WishListPageUI;

public class WishListPageObject extends BasePage {
	private WebDriver driver;

	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductAddWishListSuccess() {
		waitForElementVisible(driver, WishListPageUI.PRODUCT_ADD_WISH_LIST_SUCCESS);
		return getElementText(driver, WishListPageUI.PRODUCT_ADD_WISH_LIST_SUCCESS);
	}

	public void clickToWishListLinkShare() {
		waitForElementClickable(driver, WishListPageUI.SHARE_LINK);
		clickToElement(driver, WishListPageUI.SHARE_LINK);
	}

	public void checkToAddToCartbox() {
		waitForElementVisible(driver, WishListPageUI.ADD_TO_CART_BOX);
		checkToDefaultCheckboxOrRadio(driver, WishListPageUI.ADD_TO_CART_BOX);
	}

	public boolean isAddToCartboxDisplayed() {
		waitForElementVisible(driver, WishListPageUI.ADD_TO_CART_BOX);
		return isElementDisplayed(driver, WishListPageUI.ADD_TO_CART_BOX);
	}

	public boolean isPageTitleDisplayed() {
		waitForElementVisible(driver, WishListPageUI.PAGE_TITLE);
		return isElementDisplayed(driver, WishListPageUI.PAGE_TITLE);
	}

	public boolean isWishListMessageDisplayed() {
		waitForElementVisible(driver, WishListPageUI.WISH_LIST_MESSAGE);
		return isElementDisplayed(driver, WishListPageUI.WISH_LIST_MESSAGE);
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, WishListPageUI.REMOVE_BUTTON);
		clickToElement(driver, WishListPageUI.REMOVE_BUTTON);
	}

	public void waitForSecond() {
		sleepInSecond(3);
	}

	public CartPageObject clickToAddCartButton() {
		waitForElementClickable(driver, WishListPageUI.ADD_CART_BUTTON);
		clickToElement(driver, WishListPageUI.ADD_CART_BUTTON);
		return PageGeneraterManager.getCartPage(driver);
	}

}
