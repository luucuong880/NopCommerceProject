package nopcommerce.user;

import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import pageObject.user.AddressPageObject;
import pageObject.user.ChangePasswordPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MenuPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.ProductReviewPageObject;
import pageObject.user.SubMenuPageObject;
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

		emailAddress = RegisterComplete.emailAddress;

		newEmailAddress = userData.getNewEmailAddress() + generateFakeNumber() + "@gmail.play";
		newPassword = "456789";
		newCompany = "RedSkull";
		newCity = "Gotham";
		newAddress = "325 Lightning";
		newZipCode = "813";
		newPhoneNumber = "0789654213";
		reviewTitle = "Order " + generateFakeNumber();
		reviewText = "Good product " + generateFakeNumber();

		loginPage = homePage.clickToLoginLink();

		loginPage.setCookies(driver, RegisterComplete.cookies);
		loginPage.sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);

		customerInfoPage = homePage.openMyAccountLink();
	}

	@Test
	public void My_Account_01_Customer_Info() {
		log.info("Customer Info Step - 01: Verify Customer Info Steppage title is Displayed");
		verifyTrue(customerInfoPage.isPageTitleByTextDisplayed(driver, "Customer info"));

		log.info("Customer Info Step - 02: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());

		log.info("Customer Info Step - 03: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());

		log.info("Customer Info Step - 04: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("Customer Info Step - 05: Check to 'Gender' Radio textbox");
		customerInfoPage.checkToGenderTextbox("gender-male");

		log.info("Customer Info Step - 06: Select Day Of Birth");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDay());

		log.info("Customer Info Step - 07: Select Month Of Birth");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());

		log.info("Customer Info Step - 08: Select Year Of Birth");
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Customer Info Step - 09: Input to 'Company' textbox");
		customerInfoPage.inputToTextboxByID(driver, "Company", "AutomationFC");

		log.info("Customer Info Step - 10: Click to 'Save' button");
		customerInfoPage.clickSaveButton();

		log.info("Customer Info Step - 11: Get Success Save Message");
		verifyEquals(customerInfoPage.getSuccessMessage(driver), "The customer info has been updated successfully.");

		log.info("Customer Info Step - 12: Close Success Save Message");
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
		addressPage.clickButtonByClass(driver, "Save");

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
	public void My_Account_03_Address_Add_New_Full_Data_And_Delete() {
		log.info("Address Step - 13: Reload 'Add New Address' page");
		addressPage.refreshCurrentPage(driver);
		addressPage = PageGeneratorManager.getPageGeneratorManager().getAddressPage(driver);

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
		addressPage.clickButtonByClass(driver, "Save");

		log.info("Address Step - 24: Get Success Save Message");
		Assert.assertEquals(addressPage.getSuccessMessage(driver), "The new address has been added successfully.");

		log.info("Address Step - 25: Close Success Message");
		addressPage.closeSuccessMessage(driver);

		log.info("Address Step - 26: Verify 'Email' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("email"), "Email: " + emailAddress);

		log.info("Address Step - 27: Verify 'Phone' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("phone"), "Phone number: 0987546234");

		log.info("Address Step - 28: Verify 'Company' value is correctly");
		Assert.assertEquals(addressPage.getTextboxValueByClass("company"), "AutomationFC");

		log.info("Address Step - 29: Verify 'Address' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("address1"), userData.getAddress());

		log.info("Address Step - 30: Verify 'City' and 'Zip/code' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("city-state-zip"), "Ho Chi Minh, 700000");

		log.info("Address Step - 31: Verify 'Country' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("country"), userData.getCountry());

		log.info("Address Step - 32: Verify 'Edit' button is Displayed");
		verifyTrue(addressPage.isButtonDisplayed("Edit"));

		log.info("Address Step - 32: Verify 'Delete' button is Displayed");
		verifyTrue(addressPage.isButtonDisplayed("Delete"));

		log.info("Address Step - 33: Click to 'Delete' button");
		addressPage.clickButtonByClass(driver, "Delete");

		log.info("Address Step - 34: Verify Alert text message is Displayed");
		verifyEquals(addressPage.getAlertMessageDisplayed(), "Are you sure?");

		log.info("Address Step - 35: Accept Alert Message");
		addressPage.acceptAlert();

		log.info("Address Step - 36: Get Message body text");
		verifyEquals(addressPage.getBodyMessageText(), "No addresses");
	}

	@Test
	public void My_Account_04_Address_Add_New_Address() {
		log.info("Address Step - 37: Click to 'Add New' button");
		addressPage.clickToAddNewButton();
		addressPage = PageGeneratorManager.getPageGeneratorManager().getAddressPage(driver);

		log.info("Address Step - 38: Input to 'First Name' textbox");
		addressPage.inputToTextboxByID(driver, "Address_FirstName", userData.getFirstName());

		log.info("Address Step - 39: Input to 'Last Name' textbox");
		addressPage.inputToTextboxByID(driver, "Address_LastName", userData.getLastName());

		log.info("Address Step - 40: Input to 'Email' textbox");
		addressPage.inputToTextboxByID(driver, "Address_Email", newEmailAddress);

		log.info("Address Step - 41: Input to 'Company' textbox");
		addressPage.inputToTextboxByID(driver, "Address_Company", newCompany);

		log.info("Address Step - 42: Select 'Country' dropdown");
		addressPage.selectToDropdownByName(driver, "Address.CountryId", userData.getCountry());

		log.info("Address Step - 43: Input to 'City' textbox");
		addressPage.inputToTextboxByID(driver, "Address_City", newCity);

		log.info("Address Step - 44: Input to 'Address' textbox");
		addressPage.inputToTextboxByID(driver, "Address_Address1", newAddress);

		log.info("Address Step - 45: Input to 'Zip/Code' textbox");
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", newZipCode);

		log.info("Address Step - 46: Input to 'Phone' textbox");
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", newPhoneNumber);

		log.info("Address Step - 47: Click to 'Save' button");
		addressPage.clickButtonByClass(driver, "Save");

		log.info("Address Step - 48: Get Success Save Message");
		Assert.assertEquals(addressPage.getSuccessMessage(driver), "The new address has been added successfully.");

		log.info("Address Step - 49: Close Success Message");
		addressPage.closeSuccessMessage(driver);

		log.info("Address Step - 50: Verify 'Email' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("email"), "Email: " + newEmailAddress);

		log.info("Address Step - 51: Verify 'Phone' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("phone"), "Phone number: " + newPhoneNumber);

		log.info("Address Step - 52: Verify 'Company' value is correctly");
		Assert.assertEquals(addressPage.getTextboxValueByClass("company"), newCompany);

		log.info("Address Step - 53: Verify 'Address' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("address1"), newAddress);

		log.info("Address Step - 54: Verify 'City' and 'Zip/code' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("city-state-zip"), "Gotham, 813");

		log.info("Address Step - 55: Verify 'Country' value is correctly");
		verifyEquals(addressPage.getTextboxValueByClass("country"), userData.getCountry());

		log.info("Address Step - 56: Verify 'Edit' button is Displayed");
		verifyTrue(addressPage.isButtonDisplayed("Edit"));

		log.info("Address Step - 57: Verify 'Delete' button is Displayed");
		verifyTrue(addressPage.isButtonDisplayed("Delete"));
	}

	@Test
	public void My_Account_05_Change_Password() {
		log.info("Change Password Step - 01: Open 'Change Password' page");
		changePasswordPage = (ChangePasswordPageObject) addressPage.openPageAtMyAccountByName(driver, "Change password");

		log.info("Change Password Step - 02: Click to 'Change Password' button");
		changePasswordPage.clickButtonByClass(driver, "Change password");

		log.info("Change Password Step - 03: Get Error Message at 'Old Password' field");
		Assert.assertEquals(changePasswordPage.getErrorMessageWithDynamicValue(driver, "OldPassword-error"), "Old password is required.");

		log.info("Change Password Step - 04: Get Error Message at 'New Password' field");
		Assert.assertEquals(changePasswordPage.getErrorMessageWithDynamicValue(driver, "NewPassword-error"), "Password is required.");

		log.info("Change Password Step - 05: Get Error Message at 'Cofirm Password' field");
		Assert.assertEquals(changePasswordPage.getErrorMessageWithDynamicValue(driver, "ConfirmNewPassword-error"), "Password is required.");

		log.info("Change Password Step - 06: Click to 'Change Password' button");
		changePasswordPage.clickButtonByClass(driver, "Change password");

		log.info("Change Password Step - 05: Input to 'New Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "NewPassword", "123");

		log.info("Change Password Step - 07: Input to 'Confirm New Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", "123");

		log.info("Change Password Step - 08: Get Error Message at 'New Password' field");
		Assert.assertEquals(changePasswordPage.getErrorMessageWithDynamicValue(driver, "NewPassword-error"), "Password must meet the following rules:\n" + "must have at least 6 characters");

		log.info("Change Password Step - 09: Reload 'Change Password' page");
		changePasswordPage.refreshCurrentPage(driver);
		changePasswordPage = PageGeneratorManager.getPageGeneratorManager().getChangePasswordPage(driver);

		log.info("Change Password Step - 10: Input to 'Old Passwrod' textbox");
		changePasswordPage.inputToTextboxByID(driver, "OldPassword", "789456");

		log.info("Change Password Step - 11: Input to 'New Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "NewPassword", "123456");

		log.info("Change Password Step - 12: Input to 'Confirm New Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", "123456");

		log.info("Change Password Step - 13: Click to 'Change Password' button");
		changePasswordPage.clickButtonByClass(driver, "Change password");

		log.info("Change Password Step - 14: Get Error Message At 'Change Password' page");
		Assert.assertEquals(changePasswordPage.getErrorMessageAtPage(), "Old password doesn't match");

		log.info("Change Password Step - 15: Input to 'Old Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "OldPassword", userData.getLoginPassword());

		log.info("Change Password Step - 16: Input to 'New Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "NewPassword", newPassword);

		log.info("Change Password Step - 17: Input to 'Confirm New Password' textbox");
		changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", newPassword);

		log.info("Change Password Step - 18: Click to 'Change Password' button");
		changePasswordPage.clickButtonByClass(driver, "Change password");

		log.info("Change Password Step - 19: Get Success Save Message");
		Assert.assertEquals(changePasswordPage.getSuccessMessage(driver), "Password was changed");

		log.info("Change Password Step - 20: Close Success Message");
		changePasswordPage.closeSuccessMessage(driver);
	}

	@Test
	public void My_Account_06_My_Product_Review() {
		log.info("My Product Review Step - 01: Open 'Computers' page");
		menuPage = (MenuPageObject) changePasswordPage.openMenuPage(driver, "Computers");

		log.info("My Product Review Step - 02: Open 'Log in' page And Login");
		loginPage = (LoginPageObject) menuPage.openPageAtHeaderLinks(driver, "ico-login");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		loginPage.inputToTextboxByID(driver, "Password", newPassword);
		homePage = loginPage.clickLoginButton();

		log.info("My Product Review Step - 03: Open 'Computers' page");
		menuPage = (MenuPageObject) homePage.openMenuPage(driver, "Computers");
		subMenuPage = (SubMenuPageObject) menuPage.openSubMenuPage("Desktop");

		log.info("My Product Review Step - 04: Click to Product Item");
		subMenuPage.clickToProductByText(driver, "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("My Product Review Step - 05: Click to 'Add your review' link");
		productReviewPage = subMenuPage.clickToAddReviewLink();

		log.info("My Product Review Step - 06: Input to Review Title and Review Text");
		productReviewPage.inputToTextboxByID(driver, "AddProductReview_Title", reviewTitle);
		productReviewPage.inputToReviewText(reviewText);

		log.info("My Product Review Step - 07: Click to Submit button");
		productReviewPage.clickButtonByClass(driver, "Submit review");

		log.info("My Product Review Step - 08: Verify Product Review message");
		verifyEquals(productReviewPage.getProductReviewMessage(), "Product review is successfully added.");

		log.info("My Product Review Step - 09: Open Customer Info Page");
		customerInfoPage = (CustomerInfoPageObject) productReviewPage.openPageAtHeaderLinks(driver, "ico-account");
		myProductReviewPage = (MyProductReviewPageObject) customerInfoPage.openPageAtMyAccountByName(driver, "My product reviews");

		log.info("My Product Review Step - 10: Verify Product Review is Displayed");
		verifyTrue(myProductReviewPage.isProductReviewDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));
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
	public static String emailAddress, newEmailAddress;
	private String newPassword, newCompany, newCity, newAddress, newZipCode, newPhoneNumber, reviewTitle, reviewText;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressPageObject addressPage;
	private ChangePasswordPageObject changePasswordPage;
	MenuPageObject menuPage;
	private SubMenuPageObject subMenuPage;
	private ProductReviewPageObject productReviewPage;
	private MyProductReviewPageObject myProductReviewPage;
	UserDataMapper userData;
}
