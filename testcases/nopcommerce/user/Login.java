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
import pageObject.user.LoginPageObject;
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class Login extends BaseTest {
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
		unregisterEmail = userData.getEmailAddress() + generateFakeNumber() + "@fakermail.com";
		invalidEmail = userData.getEmailAddress() + generateFakeNumber() + "@kfc@kfc.com";
		incorrectPassword = "789654";

		registerPage = (RegisterPageObject) homePage.openPageAtHeaderLinks(driver, "ico-register");

		registerPage.checkToRadioButtonByID(driver, "gender-male");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getLoginUsername());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDay());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getLoginPassword());

		registerPage.clickToRegisterButton("register-button");

	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("Login Step - 01: Open 'Log in' page");
		loginPage = (LoginPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-login");

		log.info("Login Step - 02: Verify 'Login' page title");
		verifyEquals(loginPage.getMessagePageTitle(), "Welcome, Please Sign In!");

		log.info("Login Step - 03: Click To 'Login' button");
		loginPage.clickToButtonByText("Log in");

		log.info("Login Step - 04: Get Error Email Message");
		verifyEquals(loginPage.getErrorEmailMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		log.info("Login Step - 05: Reload 'Log in' page");
		loginPage = (LoginPageObject) homePage.openPageAtHeaderLinks(driver, "ico-login");

		log.info("Login Step - 06: Input to 'Email' textbox Invalid Email");
		loginPage.inputToTextboxByID(driver, "Email", invalidEmail);

		log.info("Login Step - 07: Click to 'Log in' button");
		loginPage.clickToButtonByText("Log in");

		log.info("Login Step - 08: Get Error Message at 'Email' textbox");
		verifyEquals(loginPage.getErrorEmailMessage(), "Wrong email");
	}

	@Test
	public void Login_03_Unregister_Email() {
		log.info("Login Step - 09: Reload 'Log in' page");
		loginPage = (LoginPageObject) homePage.openPageAtHeaderLinks(driver, "ico-login");

		log.info("Login Step - 10: Input to 'Email' textbox Unregister Email");
		loginPage.inputToTextboxByID(driver, "Email", unregisterEmail);

		log.info("Login Step - 11: Click to 'Log in' button");
		loginPage.clickToButtonByText("Log in");

		log.info("Login Step - 12: Get Error Message Unsuccessful");
		verifyEquals(loginPage.getMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Not_Entered_Password() {
		log.info("Login Step - 13: Reload 'Log in' page");
		loginPage = (LoginPageObject) homePage.openPageAtHeaderLinks(driver, "ico-login");

		log.info("Login Step - 14: Input to 'Email' textbox Email Address");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login Step - 14: Input to 'Password' textbox");
		loginPage.inputToTextboxByID(driver, "Password", "");

		log.info("Login Step - 15: Click to 'Log in' button");
		loginPage.clickToButtonByText("Log in");

		log.info("Login Step - 16: Get Error Message Unsuccessful");
		verifyEquals(loginPage.getMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Wrong_Entered_Password() {
		log.info("Login Step - 17: Reload 'Log in' page");
		loginPage = (LoginPageObject) homePage.openPageAtHeaderLinks(driver, "ico-login");

		log.info("Login Step - 18: Input to 'Email' textbox Email Address");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login Step - 19: Input to 'Password' textbox");
		loginPage.inputToTextboxByID(driver, "Password", incorrectPassword);

		log.info("Login Step - 20: Click to 'Log in' button");
		loginPage.clickToButtonByText("Log in");

		log.info("Login Step - 21: Get Error Message Unsuccessful");
		verifyEquals(loginPage.getMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Login_Success() {
		log.info("Login Step - 22: Reload 'Log in' page");
		loginPage = (LoginPageObject) homePage.openPageAtHeaderLinks(driver, "ico-login");

		log.info("Login Step - 23: Input to 'Email' textbox Email Address");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login Step - 24: Input to 'Password' textbox");
		loginPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());

		log.info("Login Step - 25: Click to 'Log in' button");
		loginPage.clickToButtonByText("Log in");

		log.info("Login Step - 26: Move to 'Home' page");
		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

		log.info("Login Step - 27: Verify 'My Account' link is Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
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
	private String emailAddress, invalidEmail, incorrectPassword, unregisterEmail;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	UserDataMapper userData;
}
