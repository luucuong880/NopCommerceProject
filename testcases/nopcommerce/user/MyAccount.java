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

import pageObject.user.CustomerInfoPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class MyAccount extends BaseTest {
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

		registerPage = homePage.openRegisterPage();

		registerPage.inputToTextboxByID("FirstName", userData.getLoginUsername());
		registerPage.inputToTextboxByID("LastName", userData.getLastName());
		registerPage.inputToTextboxByID("Email", emailAddress);
		registerPage.inputToTextboxByID("Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID("ConfirmPassword", userData.getLoginPassword());

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
		log.info("Customer Info - 01: Check to 'Gender' Radio textbox");
		customerInfoPage.checkToGenderTextbox("gender-male");

		log.info("Customer Info - 02: Select Day Of Birth");
		customerInfoPage.selectDropDownByName("DateOfBirthDay", userData.getDate());

		log.info("Customer Info - 03: Select Month Of Birth");
		customerInfoPage.selectDropDownByName("DateOfBirthMonth", userData.getMonth());

		log.info("Customer Info - 04: Select Year Of Birth");
		customerInfoPage.selectDropDownByName("DateOfBirthYear", userData.getYear());

		log.info("Customer Info - 05: Input to 'Company' textbox");
		customerInfoPage.inputToTextboxByID("Company", "AutomationFC");
	}

	public void Login_02_Invalid_Email() {
	}

	public void Login_03_Unregister_Email() {

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
	private String emailAddress, invalidEmail, incorrectPassword, unregisterEmail;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	UserDataMapper userData;
}
