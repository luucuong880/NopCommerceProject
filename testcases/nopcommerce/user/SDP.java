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

import pageObject.user.HomePageObject;
import pageObject.user.MenuPageObject;
import pageObject.user.SubMenuPageObject;
import utilities.Environment;

public class SDP extends BaseTest {
	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("testing") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		ConfigFactory.setProperty("env", envName);
		environment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

	}

	@Test
	public void Sort_01_With_Name() {
		log.info("Sort With Name Step - 01: Open Product Menu page");
		menuPage = (MenuPageObject) homePage.openMenuPage(driver, "Computers");
		subMenuPage = menuPage.openSubMenuPage("Notebooks");

		log.info("Sort With Name Step - 02: Select Sort with Name: A to Z");
		subMenuPage.selectToDropdownByName(driver, "products-orderby", "Name: A to Z");

		log.info("Sort With Name Step - 03: Verify Item is Selected");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-orderby"), "Name: A to Z");

		log.info("Sort With Name Step - 04: Verify Product Item is Sorted A to Z");
		verifyTrue(subMenuPage.isProductNameSortByAscending(driver));

		log.info("Sort With Name Step - 05: Select Sort with Name: Z to A");
		subMenuPage.selectToDropdownByName(driver, "products-orderby", "Name: Z to A");

		log.info("Sort With Name Step - 06: Verify Item is Selected");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-orderby"), "Name: Z to A");

		log.info("Sort With Name Step - 07: Verify Product Item is Sorted Z to A");
		verifyTrue(subMenuPage.isProductNameSortByDescending(driver));
	}

	@Test
	public void Sort_02_With_Price() {
		log.info("Sort With Price Step - 01: Select Sort with Price: Low to High");
		subMenuPage.selectToDropdownByName(driver, "products-orderby", "Price: Low to High");

		log.info("Sort With Price Step - 02: Verify Item is Selected");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-orderby"), "Price: Low to High");

		log.info("Sort With Price Step - 03: Verify Product Item is Sorted Low to High");
		verifyTrue(subMenuPage.isProductPriceSortByAscending(driver));

		log.info("Sort With Price Step - 04: Select Sort with Price: High to Low");
		subMenuPage.selectToDropdownByName(driver, "products-orderby", "Price: High to Low");

		log.info("Sort With Price Step - 05: Verify Item is Selected");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-orderby"), "Price: High to Low");

		log.info("Sort With Price Step - 06: Verify Product Item is Sorted High to Low");
		verifyTrue(subMenuPage.isProductPriceSortByDescending(driver));
	}

	@Test
	public void Sort_03_With_Display_3_Product_Item() {
		log.info("Sort With Display Step - 01: Select Sort Position");
		subMenuPage.selectToDropdownByName(driver, "products-orderby", "Position");

		log.info("Sort With Display Step - 02: Verify Item is Selected");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-orderby"), "Position");

		log.info("Sort With Display Step - 03: Select Product page size with 3");
		subMenuPage.selectToDropdownByName(driver, "products-pagesize", "3");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-pagesize"), "3");

		log.info("Sort With Display Step - 04: Verify 3 Product is Displayed");
		verifyEquals(subMenuPage.getProductSize(driver), 3);

		log.info("Sort With Display Step - 05: Verify 'Next icon' paging is Displayed");
		verifyTrue(subMenuPage.isPageButtonDisplayed("Next"));

		log.info("Sort With Display Step - 06: Click to 'Next page' button");
		subMenuPage.clickButtonByText(driver, "Next");

		log.info("Sort With Display Step - 07: Verify 'Previous icon' paging is Displayed");
		verifyTrue(subMenuPage.isPageButtonDisplayed("Previous"));

	}

	@Test
	public void Sort_04_With_Display_6_Product_Item() {
		log.info("Sort With Display Step - 08: Select Product page size with 6");
		subMenuPage.selectToDropdownByName(driver, "products-pagesize", "6");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-pagesize"), "6");

		log.info("Sort With Display Step - 09: Verify 6 Product is Displayed");
		verifyEquals(subMenuPage.getProductSize(driver), 6);

		log.info("Sort With Display Step - 10: Verify paging button is Undisplayed");
		verifyTrue(subMenuPage.isPageButtonUnDisplayed("current-page"));
	}

	@Test
	public void Sort_05_With_Display_9_Product_Item() {
		log.info("Sort With Display Step - 08: Select Product page size with 9");
		subMenuPage.selectToDropdownByName(driver, "products-pagesize", "9");
		verifyEquals(subMenuPage.getItemSelected(driver, "products-pagesize"), "9");

		log.info("Sort With Display Step - 09: Verify 6 Product is Displayed");
		verifyEquals(subMenuPage.getProductSize(driver), 6);

		log.info("Sort With Display Step - 10: Verify paging button is Undisplayed");
		verifyTrue(subMenuPage.isPageButtonUnDisplayed("current-page"));
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
	private HomePageObject homePage;
	private MenuPageObject menuPage;
	private SubMenuPageObject subMenuPage;
	UserDataMapper userData;
}
