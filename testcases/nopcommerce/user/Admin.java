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

		registerPage = (RegisterPageObject) homePage.openPageAtHeaderLinks(driver, "ico-register");

		registerPage.checkToRadioButtonByID(driver, "gender-male");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getLoginUsername());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getLoginPassword());

		registerPage.clickToRegisterButton("register-button");

	}

	@Test
	public void Login_01_Empty_Data() {

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
	UserDataMapper userData;
}
