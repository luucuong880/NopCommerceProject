package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Environment;

public class Register extends BaseTest {

	Environment environment;

	@Parameters({ "envName", "browserName", "serverName", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("chrome") String browserName, @Optional("dev") String serverName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		String environmentName = System.getProperty("environment");
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);

		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	private WebDriver driver;
}
