package nopcommerce.user;

import org.openqa.selenium.WebDriver;

import pageObject.user.AddressPageObject;
import pageObject.user.CartPageObject;
import pageObject.user.ChangePasswordPageObject;
import pageObject.user.CheckoutPageObject;
import pageObject.user.CompareProductPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.FootersPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MenuPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.OrderPageObject;
import pageObject.user.ProductReviewPageObject;
import pageObject.user.RecentlyViewedProductsPageObject;
import pageObject.user.RegisterPageObject;
import pageObject.user.RewardPointPageObject;
import pageObject.user.SubMenuPageObject;
import pageObject.user.WishListPageObject;

public class PageGeneratorManager {

	public static PageGeneratorManager getPageGeneratorManager() {
		return new PageGeneratorManager();
	}

	public HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public SubMenuPageObject getSubMenuPage(WebDriver driver) {
		return new SubMenuPageObject(driver);
	}

	public MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public FootersPageObject getFootersPage(WebDriver driver) {
		return new FootersPageObject(driver);
	}

	public AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}

	public RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}

	public ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}

	public WishListPageObject getWishListPage(WebDriver driver) {
		return new WishListPageObject(driver);
	}

	public CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}

	public CompareProductPageObject getCompareProductPage(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}

	public RecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver) {
		return new RecentlyViewedProductsPageObject(driver);
	}

	public OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}

	public CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

	public MenuPageObject getMenuPage(WebDriver driver) {
		return new MenuPageObject(driver);
	}

}
