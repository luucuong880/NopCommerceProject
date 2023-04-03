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
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class Register extends BaseTest {

	Environment environment;

	@Parameters({ "envName", "browserName", "serverName", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("chrome") String browserName, @Optional("testing") String serverName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		ConfigFactory.setProperty("env", envName);
		environment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);

		homePage = PageGeneraterManager.getHomePage(driver);
		userData = UserDataMapper.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakermail.com";
	}

	@Test
	public void Input_01_Without_Info() {
		log.info("Register Step - 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register Step - 02: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 03: Get Error Message At 'First Name' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue("FirstName-error"), "First name is required.");

		log.info("Register Step - 04: Get Error Message At 'Last Name' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue("LastName-error"), "Last name is required.");

		log.info("Register Step - 05: Get Error Message At 'Email' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue("Email-error"), "Email is required.");

		log.info("Register Step - 06: Get Error Message At 'Password' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue("Password-error"), "Password is required.");

		log.info("Register Step - 07: Get Error Message At 'Cofirm Password' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue("ConfirmPassword-error"), "Password is required.");

	}

	@Test
	public void Input_02_Full_Info() {

		registerPage.refreshCurrentPage(driver);

		registerPage = PageGeneraterManager.getRegisterPage(driver);

		log.info("Register Step - 08: Click to 'Gender' Radio button");
		registerPage.clickToRadioButtonByID("gender-male");

		log.info("Register Step - 09: Input to 'First Name' textbox");
		registerPage.inputToTextboxByID("FirstName", userData.getFirstName());

		registerPage.inputToTextboxByID("FirstName", userData.getLoginUsername());
		registerPage.inputToTextboxByID("Password", userData.getLoginPassword());

		log.info("Register Step - 10: Input to 'Last Name' textbox");
		registerPage.inputToTextboxByID("LastName", userData.getLastName());

		log.info("Register Step - 11: Select 'Date of birth Day' value");
		registerPage.selectToDropdownByName("DateOfBirthDay", userData.getDate());

		log.info("Register Step - 12: Select 'Date of birth Month' value");
		registerPage.selectToDropdownByName("DateOfBirthMonth", userData.getMonth());

		log.info("Register Step - 13: Select 'Date of birth Year' value");
		registerPage.selectToDropdownByName("DateOfBirthYear", userData.getYear());

		log.info("Register Step - 14: Input to 'Email' textbox");
		registerPage.inputToTextboxByID("Email", emailAddress);

		log.info("Register Step - 15: Input to 'Password' textbox");
		registerPage.inputToTextboxByID("Password", userData.getPassword());

		log.info("Register Step - 16: Input to 'Confirmpassword' textbox");
		registerPage.inputToTextboxByID("ConfirmPassword", userData.getPassword());

		log.info("Register Step - 17: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 18: Verify Register success message is displayed");
		verifyTrue(registerPage.registerSuccessMessage());
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	UserDataMapper userData;
}
