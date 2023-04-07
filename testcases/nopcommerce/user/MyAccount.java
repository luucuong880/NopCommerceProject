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

import pageObject.user.AddressPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class MyAccount extends BaseTest {
	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("testing") String serverName, @Optional("h_chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
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

		customerInfoPage = homePage.openMyAccountPage();
	}

	@Test
	public void My_Account_01_Customer_Info() {
		log.info("Customer Info Step- 01: Verify Customer Info Steppage title is Displayed");
		verifyTrue(customerInfoPage.isPageTitleByTextDisplayed(driver, "Customer info"));

		log.info("Customer Info Step- 02: Check to 'Gender' Radio textbox");
		customerInfoPage.checkToGenderTextbox("gender-male");

		log.info("Customer Info Step- 03: Select Day Of Birth");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());

		log.info("Customer Info Step- 04: Select Month Of Birth");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());

		log.info("Customer Info Step- 05: Select Year Of Birth");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Customer Info Step- 06: Input to 'Company' textbox");
		customerInfoPage.inputToTextboxByID(driver, "Company", "AutomationFC");

		log.info("Customer Info Step- 07: Click to 'Save' button");
		customerInfoPage.clickToSaveButton(driver);

		log.info("Customer Info Step- 08: Get Success Save Message");
		verifyEquals(customerInfoPage.getSuccessSaveMessage(driver), "The customer info has been updated successfully.");

		log.info("Customer Info Step- 09: Close Success Save Message");
		customerInfoPage.closeSuccessMessage(driver);
	}

	@Test
	public void My_Account_02_Address_Add_New_Empty_Data() {
		log.info("Address Step - 01: Open 'Address' page ");
		addressPage = (AddressPageObject) customerInfoPage.openPageAtMyAccountByName(driver, "Addresses");

		log.info("Address Step - 02: Verify Address page title is Displayed");
		verifyTrue(addressPage.isPageTitleByTextDisplayed(driver, "Addresses"));

		log.info("Address Step - 03: Click to 'Add New' button");
		addressPage.clickToAddNewButton();

		log.info("Address Step - 04: Verify Add New Address Message is Displayed");
		verifyTrue(addressPage.isPageTitleByTextDisplayed(driver, "Add new address"));

		log.info("Address Step - 05: Click to 'Save' button");
		addressPage.clickToSaveButton(driver);

		log.info("Address Step - 06: Get Error Message at 'First Name' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_FirstName-error"), "First name is required.");

		log.info("Address Step - 07: Get Error Message at 'Last Name' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_LastName-error"), "Last name is required.");

		log.info("Address Step - 08: Get Error Message at 'Email' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_Email-error"), "Email is required.");

		log.info("Address Step - 09: Get Error Message at 'City' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_City-error"), "City is required");

		log.info("Address Step - 10: Get Error Message at 'Address' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_Address1-error"), "Street address is required");

		log.info("Address Step - 11: Get Error Message at 'Zip/Code' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_ZipPostalCode-error"), "Zip / postal code is required");

		log.info("Address Step - 12: Get Error Message at 'Phone' field");
		verifyEquals(addressPage.getErrorMessageWithDynamicValue(driver, "Address_PhoneNumber-error"), "Phone is required");

	}

	@Test
	public void My_Account_03_Address_Add_New_Full_Data() {
		log.info("Address Step - 13: Reload 'Add New Address' page");
		addressPage.refreshCurrentPage(driver);

		log.info("Address Step - 14: Input to 'First Name' textbox");
		addressPage.inputToTextboxByID(driver, "Address_FirstName", userData.getFirstName());

		log.info("Address Step - 15: Input to 'Last Name' textbox");
		addressPage.inputToTextboxByID(driver, "Address_LastName", userData.getLastName());

		log.info("Address Step - 16: Input to 'Email' textbox");
		addressPage.inputToTextboxByID(driver, "Address_Email", emailAddress);

		log.info("Address Step - 17: Input to 'Company' textbox");
		addressPage.inputToTextboxByID(driver, "Address_Company", "AutomationFC");

		log.info("Address Step - 18: Select 'Country' dropdown");
		addressPage.selectToDropdownByName(driver, "Address.CountryId", userData.getCountry());

		log.info("Address Step - 19: Input to 'City' textbox");
		addressPage.inputToTextboxByID(driver, "Address_City", userData.getCity());

		log.info("Address Step - 20: Input to 'Address' textbox");
		addressPage.inputToTextboxByID(driver, "Address_Address1", userData.getAddress());

		log.info("Address Step - 21: Input to 'Zip/Code' textbox");
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", userData.getZipcode());

		log.info("Address Step - 22: Input to 'Phone' textbox");
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", userData.getPhone());

		log.info("Address Step - 23: Click to 'Save' button");
		addressPage.clickToSaveButton(driver);

		log.info("Address Step - 24: Get Success Save Message");
		verifyEquals(addressPage.getSuccessSaveMessage(driver), "The new address has been added successfully.");

		log.info("Address Step - 25: Close Success Message");
		addressPage.closeSuccessMessage(driver);

	}

	public void Login_04_Not_Entered_Password() {
	}

	public void Login_05_Wrong_Entered_Password() {
	}

	public void Login_06_Login_Success() {
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
	private CustomerInfoPageObject customerInfoPage;
	private AddressPageObject addressPage;
	UserDataMapper userData;
}
