package nopcommerce.user;

import org.openqa.selenium.WebDriver;

import pageObject.user.AddressPageObject;
import pageObject.user.ApparelPageObject;
import pageObject.user.BooksPageObject;
import pageObject.user.ChangePasswordPageObject;
import pageObject.user.CheckoutPageObject;
import pageObject.user.CompareProductPageObject;
import pageObject.user.ComputersPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.DesktopPageObject;
import pageObject.user.DigitalPageObject;
import pageObject.user.ElectronicsPageObject;
import pageObject.user.GiftCardPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.JewelryPageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.NotebooksPageObject;
import pageObject.user.OrderPageObject;
import pageObject.user.ProductReviewPageObject;
import pageObject.user.RecentlyViewedProductsPageObject;
import pageObject.user.RegisterPageObject;
import pageObject.user.RewardPointPageObject;
import pageObject.user.SearchPageObject;
import pageObject.user.SoftwarePageObject;
import pageObject.user.WishListPageObject;
import pageUI.user.CartPageObject;

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

	public ComputersPageObject getComputersPage(WebDriver driver) {
		return new ComputersPageObject(driver);
	}

	public DesktopPageObject getDesktopPage(WebDriver driver) {
		return new DesktopPageObject(driver);
	}

	public MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}

	public NotebooksPageObject getNotebooksPage(WebDriver driver) {
		return new NotebooksPageObject(driver);
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

	public ElectronicsPageObject getElectronicsPage(WebDriver driver) {
		return new ElectronicsPageObject(driver);
	}

	public ApparelPageObject getApparelPage(WebDriver driver) {
		return new ApparelPageObject(driver);
	}

	public DigitalPageObject getDigitalPage(WebDriver driver) {
		return new DigitalPageObject(driver);
	}

	public BooksPageObject getBooksPage(WebDriver driver) {
		return new BooksPageObject(driver);
	}

	public JewelryPageObject getJewelryPage(WebDriver driver) {
		return new JewelryPageObject(driver);
	}

	public GiftCardPageObject getGiftCardPage(WebDriver driver) {
		return new GiftCardPageObject(driver);
	}

	public SoftwarePageObject getSoftwarePage(WebDriver driver) {
		return new SoftwarePageObject(driver);
	}

}
