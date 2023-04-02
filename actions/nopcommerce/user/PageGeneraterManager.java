package nopcommerce.user;

import org.openqa.selenium.WebDriver;

import pageObject.user.AddressPageObject;
import pageObject.user.ChangePasswordPageObject;
import pageObject.user.CheckoutPageObject;
import pageObject.user.CompareProductPageObject;
import pageObject.user.ComputersPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.DesktopPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.NotebooksPageObject;
import pageObject.user.OrderPageObject;
import pageObject.user.ProductReviewPageObject;
import pageObject.user.RecentlyViewedProductsPageObject;
import pageObject.user.RegisterPageObject;
import pageObject.user.RewardPointPageObject;
import pageObject.user.SearchPageObject;
import pageObject.user.WishListPageObject;
import pageUI.user.CartPageObject;

public class PageGeneraterManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static ComputersPageObject getComputersPage(WebDriver driver) {
		return new ComputersPageObject(driver);
	}

	public static DesktopPageObject getDesktopPage(WebDriver driver) {
		return new DesktopPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}

	public static NotebooksPageObject getNotebooksPage(WebDriver driver) {
		return new NotebooksPageObject(driver);
	}

	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}

	public static WishListPageObject getWishListPage(WebDriver driver) {
		return new WishListPageObject(driver);
	}

	public static CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}

	public static CompareProductPageObject getCompareProductPage(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}

	public static RecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver) {
		return new RecentlyViewedProductsPageObject(driver);
	}

	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}

	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

}
