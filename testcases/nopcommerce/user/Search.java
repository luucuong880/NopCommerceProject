package nopcommerce.user;

import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import pageObject.user.FootersPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class Search extends BaseTest {
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

		registerPage.inputToTextboxByID(driver, "FirstName", userData.getLoginUsername());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getLoginPassword());

		registerPage.clickToRegisterButton("register-button");

		loginPage = (LoginPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-login");

		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		loginPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());

		homePage = loginPage.clickLoginButton();

	}

	@Test
	public void Search_01_With_Empty_Data() {
		log.info("Search Step - 01: Open Search page");
		searchPage = (FootersPageObject) homePage.openFooterPage(driver, "Search");

		log.info("Search Step - 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 03: Verify Warning message");
		verifyEquals(searchPage.getMessageByDynamicsClass(driver, "warning"), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_With_Data_Not_Exist() {
		log.info("Search Step - 04: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Macbook Pro 2050");

		log.info("Search Step - 05: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 06: Verify Warning message");
		verifyEquals(searchPage.getMessageByDynamicsClass(driver, "no-result"), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_03_With_Product_Name_Relative() {
		log.info("Search Step - 07: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Lenovo");

		log.info("Search Step - 08: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 09: Verify 2 Product is Displayed");
		verifyEquals(searchPage.getProductSize(driver), 2);
		verifyTrue(searchPage.isProductReviewDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(searchPage.isProductReviewDisplayed(driver, "Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Search_04_With_Product_Name_Absolute() {
		log.info("Search Step - 10: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Thinkpad X1 Carbon");

		log.info("Search Step - 11: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 12: Verify 2 Product is Displayed");
		verifyTrue(searchPage.isProductReviewDisplayed(driver, "Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Search_05_With_Parent_Categories() {
		log.info("Search Step - 13: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Apple Macbook Pro");

		log.info("Search Step - 14: Check to Advanced search checkbox");
		searchPage.checkToRadioButtonByID(driver, "advs");

		log.info("Search Step - 15: Select Category Item");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search Step - 16: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 17: Verify Warning message");
		verifyEquals(searchPage.getMessageByDynamicsClass(driver, "no-result"), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_06_With_Sub_Categories() {
		log.info("Search Step - 18: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Apple Macbook Pro");

		log.info("Search Step - 19: Check to Advanced search checkbox");
		searchPage.checkToRadioButtonByID(driver, "advs");

		log.info("Search Step - 20: Select Category Item");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search Step - 21: Check to Sub Categories checkbox");
		searchPage.checkToRadioButtonByID(driver, "isc");

		log.info("Search Step - 22: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 23: Verify 1 Product is Displayed");
		verifyEquals(searchPage.getProductSize(driver), 1);
		verifyTrue(searchPage.isProductReviewDisplayed(driver, "Apple MacBook Pro 13-inch"));

	}

	@Test
	public void Search_07_With_Incorrect_Manufacturer() {
		log.info("Search Step - 24: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Apple Macbook Pro");

		log.info("Search Step - 25: Check to Advanced search checkbox");
		searchPage.checkToRadioButtonByID(driver, "advs");

		log.info("Search Step - 26: Select Category Item");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search Step - 27: Check to Sub Categories checkbox");
		searchPage.checkToRadioButtonByID(driver, "isc");

		log.info("Search Step - 28: Select Manufacturer Item");
		searchPage.selectToDropdownByName(driver, "mid", "HP");

		log.info("Search Step - 29: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 30: Verify Warning message");
		verifyEquals(searchPage.getMessageByDynamicsClass(driver, "no-result"), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_08_With_Correct_Manufacturer() {
		log.info("Search Step - 31: Input to Search Keyword Field");
		searchPage.inputToTextboxByID(driver, "q", "Apple Macbook Pro");

		log.info("Search Step - 32: Check to Advanced search checkbox");
		searchPage.checkToRadioButtonByID(driver, "advs");

		log.info("Search Step - 33: Select Category Item");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search Step - 34: Check to Sub Categories checkbox");
		searchPage.checkToRadioButtonByID(driver, "isc");

		log.info("Search Step - 35: Select Manufacturer Item");
		searchPage.selectToDropdownByName(driver, "mid", "Apple");

		log.info("Search Step - 36: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search Step - 37: Verify 1 Product is Displayed");
		verifyEquals(searchPage.getProductSize(driver), 1);
		verifyTrue(searchPage.isProductReviewDisplayed(driver, "Apple MacBook Pro 13-inch"));
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

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
	private FootersPageObject searchPage;
}
