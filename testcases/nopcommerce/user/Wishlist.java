package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

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
	public void Case_01_Add_To_Wishlist() {
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
		subMenuPage.clickToShareLink();

		log.info("Wishlist Step - 07: Verify Page Title Message");
		verifyEquals(subMenuPage.getPageTitleText(driver), "Wishlist of " + userData.getFirstName() + " " + userData.getLastName());
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
}
