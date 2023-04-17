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

import pageObject.user.ComputersPageObject;
import pageObject.user.DesktopPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class Computers extends BaseTest {
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

		registerPage = homePage.openRegisterPage();

		registerPage.inputToTextboxByID(driver, "FirstName", userData.getLoginUsername());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getLoginPassword());

		registerPage.clickToRegisterButton("register-button");

		loginPage = registerPage.openLoginPage();

		loginPage.inputToTextboxByID("Email", emailAddress);
		loginPage.inputToTextboxByID("Password", userData.getLoginPassword());

		loginPage.clickToButtonByText("Log in");

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

	}

	@Test
	public void Computers_01_Desktop() {
		log.info("Desktop Step - 01: Open 'Computers' page");
		computersPage = (ComputersPageObject) homePage.openPageAtTopMenuByText(driver, "Computers");
		computersPage = PageGeneratorManager.getPageGeneratorManager().getComputersPage(driver);

		log.info("Desktop Step - 02: Verify 'Desktop' link is Displayed");
		verifyTrue(computersPage.isLinkByTextDisplayed(driver, "Desktop"));

		log.info("Desktop Step - 02: Verify 'Notebooks' link is Displayed");
		verifyTrue(computersPage.isLinkByTextDisplayed(driver, "Notebooks"));

		log.info("Desktop Step - 02: Verify 'Software' link is Displayed");
		verifyTrue(computersPage.isLinkByTextDisplayed(driver, "Software"));

		log.info("Desktop Step - 03: Open 'Desktop' page");
		desktopPage = (DesktopPageObject) computersPage.openCategoriesOfComputerPage(driver, "Desktop");

		log.info("Desktop Step - 04: Verify page title is Displayed");
		verifyTrue(desktopPage.isPageTitleByTextDisplayed(driver, "Desktops"));

		log.info("Desktop Step - 05: Click to 'List' button");
		desktopPage.clickToViewModButton("List");

		log.info("Desktop Step - 06: Click to 'Grid' button");
		desktopPage.clickToViewModButton("Grid");

		log.info("Desktop Step - 07: Click to 'Build your own computer' add to cart button");
		desktopPage.clickAddToCartButtonByText(driver, "Build your own computer");
		desktopPage = PageGeneratorManager.getPageGeneratorManager().getDesktopPage(driver);

		log.info("Desktop Step - 08: Select 'Processor' item");
		desktopPage.selectItemByDynamicsValue("Processor", "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");

		log.info("Desktop Step - 09: Verify Item Selected");
		verifyFalse(desktopPage.isItemSelected("Processor", "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200"));

		log.info("Desktop Step - 10: Select 'Processor' item");
		desktopPage.selectItemByDynamicsValue("RAM", "product_attribute_2", "2 GB");

		log.info("Desktop Step - 11: Verify Item Selected");
		verifyFalse(desktopPage.isItemSelected("RAM", "product_attribute_2", "2 GB"));

		log.info("Desktop Step - 12: Check 'HDD' radio button");
		desktopPage.checkToRadioOrCheckboxButton("HDD", "320 GB");

		log.info("Desktop Step - 13: Verify 'HDD' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("HDD", "320 GB"));

		log.info("Desktop Step - 14: Check 'OS' radio button");
		desktopPage.checkToRadioOrCheckboxButton("OS", "Vista Home [+$50.00]");

		log.info("Desktop Step - 15: Verify 'OS' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("OS", "Vista Home [+$50.00]"));

		log.info("Desktop Step - 16: Check 'Software' radio button");
		desktopPage.checkToRadioOrCheckboxButton("Software", "Microsoft Office [+$50.00]");

		log.info("Desktop Step - 17: Verify 'Software' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("Software", "Microsoft Office [+$50.00]"));

		log.info("Desktop Step - 18: Verify Total prices");
		verifyEquals(desktopPage.totalPrices(), "$1,300.00");

		log.info("Desktop Step - 19: Click to 'Add to cart' button");
		desktopPage.clickButtonByText(driver, "Add to cart");

		log.info("Desktop Step - 20: Verify Success Message Added");
		verifyEquals(desktopPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Desktop Step - 21: Close The title Message");
		desktopPage.closeSuccessMessage(driver);

	}

	public void My_Account_02_Address_Add_New_Empty_Data() {

	}

	public void My_Account_03_Address_Add_New_Full_Data_And_Delete() {
	}

	public void My_Account_04_Address_Add_New_Address() {
	}

	public void My_Account_05_Change_Password() {
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
	private String emailAddress;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private DesktopPageObject desktopPage;
	private ComputersPageObject computersPage;
	UserDataMapper userData;
}
