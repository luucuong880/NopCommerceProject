package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import pageObject.user.CartPageObject;
import pageObject.user.FootersPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MenuPageObject;
import pageObject.user.RegisterPageObject;
import pageObject.user.SubMenuPageObject;
import pageObject.user.WishListPageObject;
import utilities.Environment;

public class Wishlist extends BaseTest {
	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("testing") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		ConfigFactory.setProperty("env", envName);
		environment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakermail.com";

		registerPage = (RegisterPageObject) homePage.openPageAtHeaderLinks(driver, "ico-register");

		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		registerPage.clickToRegisterButton("register-button");

		loginPage = (LoginPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-login");

		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		loginPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());

		loginPage.clickToButtonByText("Log in");

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

		menuPage = (MenuPageObject) homePage.openMenuPage(driver, "Computers");

		subMenuPage = menuPage.openSubMenuPage("Desktops");

		subMenuPage.clickToProductByText(driver, "Digital Storm VANQUISH 3 Custom Performance PC");
	}

	@Test
	public void Case_01_Add_Product_To_Wishlist() {
		log.info("Wishlist Step - 01: Click to Add to wishlist button");
		subMenuPage.clickToButtonByClassText("add-to-wishlist", "Add to wishlist");

		log.info("Wishlist Step - 02: Verify Message Title");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your wishlist");

		log.info("Wishlist Step - 03: Close Message Title");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Wishlist Step - 04: Open Wishlist page");
		wishListPage = (WishListPageObject) subMenuPage.openPageAtHeaderLinks(driver, "ico-wishlist");

		log.info("Wishlist Step - 05: Verify Product Added Success");
		verifyTrue(wishListPage.isProductReviewDisplayed(driver, "Digital Storm VANQUISH 3 Custom Performance PC"));

		log.info("Wishlist Step - 06: Click to 'Sharing' link");
		wishListPage.clickToWishListLinkShare();

		log.info("Wishlist Step - 07: Verify Page Title Message");
		verifyEquals(wishListPage.getPageTitleText(driver), "Wishlist of " + userData.getFirstName() + " " + userData.getLastName());
	}

	@Test
	public void Case_02_Add_Product_To_Cart_From_Wishlist() {
		log.info("Cart Step - 01: Back To Wishlist page");
		wishListPage.backToPage(driver);

		log.info("Cart Step - 02: Check To Add to Cart Checkbox");
		wishListPage.checkToAddToCartbox();

		log.info("Cart Step - 03: Click To Add to Cart Button");
		cartPage = wishListPage.clickToAddCartButton();

		log.info("Cart Step - 04: Verify Product Added to Cart page");
		verifyEquals(cartPage.getPageTitleText(driver), "Shopping cart");
		verifyEquals(cartPage.getProductsName(), "Digital Storm VANQUISH 3 Custom Performance PC");

		log.info("Cart Step - 05: Verify Wislist page is empty");
		wishListPage = (WishListPageObject) cartPage.openPageAtHeaderLinks(driver, "ico-wishlist");
		verifyEquals(wishListPage.getNoDataMessage(driver), "The wishlist is empty!");
	}

	@Test
	public void Case_03_Remove_Product_From_Wishlist() {
		log.info("Remove Step - 01: Open Desktop Sub Menu Page");
		menuPage = (MenuPageObject) wishListPage.openMenuPage(driver, "Computers");
		subMenuPage = menuPage.openSubMenuPage("Notebooks");

		log.info("Remove Step - 02: Click To Add Wishlist Product Button");
		subMenuPage.clickAddToButtonsByTextProduct("Asus N551JK-XO076H Laptop", "Add to wishlist");

		log.info("Remove Step - 03: Verify Message Title");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your wishlist");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Remove Step - 04: Open Wishlist page");
		wishListPage = (WishListPageObject) subMenuPage.openPageAtHeaderLinks(driver, "ico-wishlist");

		log.info("Remove Step - 05: Click to Remove button");
		wishListPage.clickToRemoveButton();

		log.info("Remove Step - 06: Verify Wislist page is empty");
		verifyEquals(wishListPage.getNoDataMessage(driver), "The wishlist is empty!");
		verifyTrue(wishListPage.isProductReviewUnDisplayed(driver, "Digital Storm VANQUISH 3 Custom Performance PC"));
	}

	@Test
	public void Case_04_Add_Product_To_Compare() {
		log.info("Compare Step - 01: Open Sub menu page");
		menuPage = (MenuPageObject) wishListPage.openMenuPage(driver, "Computers");
		subMenuPage = menuPage.openSubMenuPage("Notebooks");

		log.info("Compare Step - 02: Add 2 product to Compare");
		subMenuPage.clickAddToButtonsByTextProduct("Apple MacBook Pro 13-inch", "Add to compare list");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your product comparison");
		subMenuPage.closeSuccessMessage(driver);

		subMenuPage.clickAddToButtonsByTextProduct("Asus N551JK-XO076H Laptop", "Add to compare list");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your product comparison");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Compare Step - 03: Open Compare product list page");
		footersPage = (FootersPageObject) subMenuPage.openFooterPage(driver, "Compare products list");

		log.info("Compare Step - 04: Verify Info list Displayed");
		verifyEquals(footersPage.getRemoveButtonSize(), 2);
		verifyTrue(footersPage.isCompareProductNameDisplayed("Asus N551JK-XO076H Laptop"));
		verifyTrue(footersPage.isCompareProductNameDisplayed("Apple MacBook Pro 13-inch"));
		verifyTrue(footersPage.isCompareProductInfoDisplayed("product-price", "$1,500.00"));
		verifyTrue(footersPage.isCompareProductInfoDisplayed("product-price", "$1,800.00"));

		log.info("Compare Step - 05: Click to Clear list button");
		footersPage.clickButtonByText(driver, "Clear list");

		log.info("Compare Step - 06: Verify Message Displayed");
		verifyEquals(footersPage.getNoDataMessage(driver), "You have no items to compare.");

		log.info("Compare Step - 07: Verify 2 product is Undisplayed");
		verifyTrue(footersPage.isCompareProductNameUnDisplayed("Asus N551JK-XO076H Laptop"));
		verifyTrue(footersPage.isCompareProductNameUnDisplayed("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void Case_05_Recently_View_Products() {
		log.info("Recently Step - 01: Open Sub menu page");
		menuPage = (MenuPageObject) footersPage.openMenuPage(driver, "Computers");
		subMenuPage = menuPage.openSubMenuPage("Notebooks");

		log.info("Recently Step - 02: View products");
		subMenuPage.clickToProductByText(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");
		subMenuPage.backToPage(driver);

		subMenuPage.clickToProductByText(driver, "Apple MacBook Pro 13-inch");
		subMenuPage.backToPage(driver);

		subMenuPage.clickToProductByText(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		subMenuPage.backToPage(driver);

		subMenuPage.clickToProductByText(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		subMenuPage.backToPage(driver);

		subMenuPage.clickToProductByText(driver, "Asus N551JK-XO076H Laptop");
		subMenuPage.backToPage(driver);

		subMenuPage.clickToProductByText(driver, "HP Spectre XT Pro UltraBook");
		subMenuPage.backToPage(driver);

		log.info("Recently Step - 02: Open Recently Review page");
		footersPage = (FootersPageObject) subMenuPage.openFooterPage(driver, "Recently viewed products");

		log.info("Recently Step - 03: Verify 3 Products last view Displayed");
		verifyTrue(footersPage.isProductReviewDisplayed(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook"));
		verifyTrue(footersPage.isProductReviewDisplayed(driver, "Asus N551JK-XO076H Laptop"));
		verifyTrue(footersPage.isProductReviewDisplayed(driver, "HP Spectre XT Pro UltraBook"));
	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	UserDataMapper userData;
	String emailAddress;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MenuPageObject menuPage;
	private SubMenuPageObject subMenuPage;
	private WishListPageObject wishListPage;
	private CartPageObject cartPage;
	private FootersPageObject footersPage;
}
