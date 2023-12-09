package nopcommerce.admin;

import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.AdminDataMapper;
import com.nopcommerce.data.UserDataMapper;

import nopcommerce.user.BaseTest;
import nopcommerce.user.PageGeneratorManager;
import pageObject.user.HomePageObject;
import pageObject.user.RegisterPageObject;
import pageObjects.admin.AdminCustomerPageObjec;
import pageObjects.admin.AdminDashBoardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.admin.AdminProductsPO;
import utilities.Environment;

public class Admin extends BaseTest {
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
		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		dateOfBirth = userData.getMonth() + "/" + userData.getDay() + "/" + userData.getYear();

		registerPage = (RegisterPageObject) homePage.openPageAtHeaderLinks(driver, "ico-register");

		registerPage.checkToRadioButtonByID(driver, "gender-male");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDay());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getLoginPassword());

		registerPage.clickToRegisterButton("register-button");

		adminLoginPage = registerPage.openAdminLoginPage();

	}

	@Test
	public void Admin_01_Search_With_Product_Name() {
		log.info("Search Step - 01: Login with empty data");
		adminLoginPage.loginAsAdmin("", "");

		log.info("Search Step - 02: Verify Email Error message");
		verifyEquals(adminLoginPage.getErrorEmailMessage(), "Please enter your email");

		log.info("Search Step - 03: Login to Dashboard page");
		adminLoginPage = adminLoginPage.reloadAdminLoginPage(driver);
		adminDasboardPage = adminLoginPage.clickToLoginButton();

		log.info("Search Step - 04: Open Products page at Dasboard page");
		adminProductsPage = (AdminProductsPO) adminDasboardPage.chosePageAtTreeviewMenu(driver, "nav-icon fas fa-book", "Products");
		adminProductsPage.clicktoSearchIcon();

		log.info("Search Step - 05: Click to Search Button");
		adminProductsPage.inputToFieldTextByID(driver, "SearchProductName", "Apple MacBook Pro 13-inch");
		adminProductsPage.clickToButtonByID("search-products");
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 06: Verify 1 Item is Displayed in Table");
		verifyTrue(adminProductsPage.isInfoProductsInTable("Product name", "Apple MacBook Pro 13-inch"));
		verifyTrue(adminProductsPage.isInfoProductsInTable("SKU", "AP_MBP_13"));
		verifyTrue(adminProductsPage.isInfoProductsInTable("Price", "1800"));
		verifyTrue(adminProductsPage.isInfoProductsInTable("Stock quantity", "10000"));
	}

	@Test
	public void Admin_02_Search_With_Product_Name_Parent_Category_Unchecked() {
		log.info("Search Step - 01: Refresh Products page");
		adminProductsPage.reloadPage();
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 02: Search with Products name Category Uncheck Subcategory");
		adminProductsPage.inputToFieldTextByID(driver, "SearchProductName", "Apple MacBook Pro 13-inch");
		adminProductsPage.selectDropDownByName("SearchCategoryId", "Electronics");

		log.info("Search Step - 03: Click to Search Button");
		adminProductsPage.clickToButtonByID("search-products");
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 04: Verify DataTable Empty");
		verifyEquals(adminProductsPage.getEmptyDataTableText(), "No data available in table");

	}

	@Test
	public void Admin_03_Search_With_Product_Name_Parent_Category_Checked() {
		log.info("Search Step - 01: Refresh Products page");
		adminProductsPage.reloadPage();
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 02: Search with Products name Category Check Subcategory");
		adminProductsPage.inputToFieldTextByID(driver, "SearchProductName", "Apple MacBook Pro 13-inch");
		adminProductsPage.selectDropDownByName("SearchCategoryId", "All");
		adminProductsPage.checkSubCategories();

		log.info("Search Step - 03: Click to Search Button");
		adminProductsPage.clickToButtonByID("search-products");
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 04: Verify 1 Item is Displayed in Table");
		verifyTrue(adminProductsPage.isInfoProductsInTable("Product name", "Apple MacBook Pro 13-inch"));
	}

	@Test
	public void Admin_04_Search_With_Product_Name_Manufactuer() {
		log.info("Search Step - 01: Refresh Products page");
		adminProductsPage.reloadPage();
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 02: Search with Products name Category Uncheck Subcategory");
		adminProductsPage.inputToFieldTextByID(driver, "SearchProductName", "Apple MacBook Pro 13-inch");
		adminProductsPage.selectDropDownByName("SearchCategoryId", "All");

		log.info("Search Step - 03: Select Manufacturer is Apple");
		adminProductsPage.selectDropDownByName("SearchVendorId", "Vendor 2");

		log.info("Search Step - 04: Click to Search Button");
		adminProductsPage.clickToButtonByID("search-products");
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Search Step - 05: Verify DataTable Empty");
		verifyEquals(adminProductsPage.getEmptyDataTableText(), "No data available in table");
	}

	@Test
	public void Admin_05_Go_Directly_To_Product_SKU() {
		log.info("SKU Step - 01: Refresh Products page");
		adminProductsPage.reloadPage();
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("SKU Step - 02: Input to Go directly textbox");
		adminProductsPage.inputToFieldTextByID(driver, "GoDirectlyToSku", "AP_MBP_13");

		log.info("SKU Step - 03: Click to Go Button");
		adminProductsPage.clickToGoButton();
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("SKU Step - 04: Verify Product Details is Diplayed and get Text Message");
		verifyTrue(adminProductsPage.isProductDetailDisplayed());
		verifyEquals(adminProductsPage.getProductDetailMessage(), "Edit product details - Apple MacBook Pro 13-inch back to product list");
	}

	@Test
	public void Admin_06_Create_New_Customer() {
		log.info("Customer Step - 01: Open Customers page");
		adminCustomerPage = (AdminCustomerPageObjec) adminProductsPage.chosePageAtTreeviewMenu(driver, "nav-icon far fa-user", "Customers");

		log.info("Customer Step - 02: Click to Add new button");
		adminCustomerPage.clickToAddNewButton(driver);

		log.info("Customer Step - 03: Input Information at Add a new Customer tab");
		adminCustomerPage.inputToFieldTextByID(driver, "Email", emailAddress);
		adminCustomerPage.inputToFieldTextByID(driver, "Password", userData.getLoginPassword());
		adminCustomerPage.inputToFieldTextByID(driver, "FirstName", firstName);
		adminCustomerPage.inputToFieldTextByID(driver, "LastName", lastName);
		adminCustomerPage.checkToCheckboxOrRadioButton(driver, "Gender_Male");
		adminCustomerPage.inputToFieldTextByID(driver, "DateOfBirth", dateOfBirth);
		adminCustomerPage.inputToFieldTextByID(driver, "Company", "Automation FC");
		adminCustomerPage.clickToCloseIcon(driver);
		adminCustomerPage.inputToFieldTextByClass(driver, "SelectedCustomerRoleIds_taglist", "Guests");
		adminCustomerPage.inputToAdminComment("Add new Customer (Guests)");

		log.info("Customer Step - 04: Click to 'Save and continue Edit' button");
		adminCustomerPage.clickToButtonByName(driver, "save-continue");
		adminProductsPage.waitForAjaxBusyIconInvisible();

		log.info("Customer Step - 05: Get Success message text");
		verifyEquals(adminCustomerPage.getSuccessMessageText(driver), "The new customer has been added successfully.");
		adminCustomerPage.clickToButtonByClass("alert alert-success alert-dismissable");

		log.info("Customer Step - 06: Verify New information was successfully created");
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
	private String emailAddress, dateOfBirth, firstName, lastName;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private AdminLoginPO adminLoginPage;
	private AdminDashBoardPO adminDasboardPage;
	private AdminProductsPO adminProductsPage;
	private AdminCustomerPageObjec adminCustomerPage;
	UserDataMapper userData;
	AdminDataMapper adminData;
}
