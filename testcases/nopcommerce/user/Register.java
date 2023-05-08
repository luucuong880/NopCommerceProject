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

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("testing") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		ConfigFactory.setProperty("env", envName);
		environment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);
		userData = UserDataMapper.getUserData();
		invalidEmail = userData.getEmailAddress() + generateFakeNumber() + "@faker@mail.com";
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakermail.com";
		invalidPassword = "4567892";
	}

	@Test
	public void Register_01_Without_Info() {
		log.info("Register Step - 01: Navigate to 'Register' page");
		registerPage = (RegisterPageObject) homePage.openPageAtHeaderLinks(driver, "ico-register");

		log.info("Register Step - 02: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 03: Get Error Message At 'First Name' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "FirstName-error"), "First name is required.");

		log.info("Register Step - 04: Get Error Message At 'Last Name' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "LastName-error"), "Last name is required.");

		log.info("Register Step - 05: Get Error Message At 'Email' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "Email-error"), "Email is required.");

		log.info("Register Step - 06: Get Error Message At 'Password' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "Password-error"), "Password is required.");

		log.info("Register Step - 07: Get Error Message At 'Cofirm Password' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "ConfirmPassword-error"), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register Step - 08: Reload 'Register' page");
		registerPage = (RegisterPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-register");

		log.info("Register Step - 08: Click to 'Gender' Radio button");
		registerPage.checkToRadioButtonByID(driver, "gender-male");

		log.info("Register Step - 09: Input to 'First Name' textbox");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register Step - 10: Input to 'Last Name' textbox");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register Step - 11: Select 'Date of birth Day' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthDay"), userData.getDate());

		log.info("Register Step - 12: Select 'Date of birth Month' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthMonth"), userData.getMonth());

		log.info("Register Step - 13: Select 'Date of birth Year' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthYear"), userData.getYear());

		log.info("Register Step - 14: Input to 'Email' textbox");
		registerPage.inputToTextboxByID(driver, "Email", invalidEmail);

		log.info("Register Step - 15: Input to 'Password' textbox");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register Step - 16: Input to 'Confirmpassword' textbox");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register Step - 17: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 18: Get Error Message At 'Email' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "Email-error"), "Wrong email");

	}

	@Test
	public void Register_03_Valid_Info() {

		log.info("Register Step - 19: Reload 'Register' page");
		registerPage = (RegisterPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-register");

		log.info("Register Step - 20: Click to 'Gender' Radio button");
		registerPage.checkToRadioButtonByID(driver, "gender-male");

		log.info("Register Step - 21: Input to 'First Name' textbox");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register Step - 22: Input to 'Last Name' textbox");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register Step - 23: Select 'Date of birth Day' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthDay"), userData.getDate());

		log.info("Register Step - 24: Select 'Date of birth Month' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthMonth"), userData.getMonth());

		log.info("Register Step - 25: Select 'Date of birth Year' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthYear"), userData.getYear());

		log.info("Register Step - 26: Input to 'Email' textbox");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register Step - 27: Input to 'Password' textbox");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register Step - 28: Input to 'Confirmpassword' textbox");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register Step - 29: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 30: Verify Register success message is displayed");
		verifyEquals(registerPage.registerSuccessMessage(), "Your registration completed");
	}

	@Test
	public void Register_04_Already_Email() {
		log.info("Register Step - 31: Open 'Register' page");
		registerPage.openPageAtHeaderLinks(driver, "ico-register");

		log.info("Register Step - 32: Click to 'Gender' Radio button");
		registerPage.checkToRadioButtonByID(driver, "gender-male");

		log.info("Register Step - 33: Input to 'First Name' textbox");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register Step - 34: Input to 'Last Name' textbox");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register Step - 35: Select 'Date of birth Day' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthDay"), userData.getDate());

		log.info("Register Step - 36: Select 'Date of birth Month' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthMonth"), userData.getMonth());

		log.info("Register Step - 37: Select 'Date of birth Year' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthYear"), userData.getYear());

		log.info("Register Step - 38: Input to 'Email' textbox");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register Step - 39: Input to 'Password' textbox");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register Step - 40: Input to 'Confirmpassword' textbox");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register Step - 41: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 42: Get Error Email Already Message");
		verifyEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {

		log.info("Register Step - 43: Reload 'Register' page");
		registerPage = (RegisterPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-register");

		log.info("Register Step - 44: Click to 'Gender' Radio button");
		registerPage.checkToRadioButtonByID(driver, "gender-male");

		log.info("Register Step - 45: Input to 'First Name' textbox");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register Step - 46: Input to 'Last Name' textbox");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register Step - 47: Select 'Date of birth Day' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthDay"), userData.getDate());

		log.info("Register Step - 48: Select 'Date of birth Month' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthMonth"), userData.getMonth());

		log.info("Register Step - 49: Select 'Date of birth Year' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthYear"), userData.getYear());

		log.info("Register Step - 50: Input to 'Email' textbox");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register Step - 51: Input to 'Password' textbox");
		registerPage.inputToTextboxByID(driver, "Password", "123");

		log.info("Register Step - 52: Input to 'Confirmpassword' textbox");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", "123");

		log.info("Register Step - 53: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 54: Get Error Message At 'Password' field");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "Password-error"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {

		log.info("Register Step - 55: Reload 'Register' page");
		registerPage = (RegisterPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-register");

		log.info("Register Step - 56: Click to 'Gender' Radio button");
		registerPage.checkToRadioButtonByID(driver, "gender-male");

		log.info("Register Step - 57: Input to 'First Name' textbox");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register Step - 58: Input to 'Last Name' textbox");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register Step - 59: Select 'Date of birth Day' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthDay"), userData.getDate());

		log.info("Register Step - 60: Select 'Date of birth Month' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthMonth"), userData.getMonth());

		log.info("Register Step - 61: Select 'Date of birth Year' value");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		verifyEquals(registerPage.getItemSelected(driver, "DateOfBirthYear"), userData.getYear());

		log.info("Register Step - 62: Input to 'Email' textbox");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register Step - 63: Input to 'Password' textbox");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register Step - 64: Input to 'Confirmpassword' textbox");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", invalidPassword);

		log.info("Register Step - 65: Click to 'Register' button");
		registerPage.clickToRegisterButton("register-button");

		log.info("Register Step - 66: Get Error Confirm Password Message");
		verifyEquals(registerPage.getErrorMessageWithDynamicValue(driver, "ConfirmPassword-error"), "The password and confirmation password do not match.");
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
	private String emailAddress, invalidEmail, invalidPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	UserDataMapper userData;
}
