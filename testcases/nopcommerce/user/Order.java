package nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import pageObject.user.CartPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MenuPageObject;
import pageObject.user.RegisterPageObject;
import pageObject.user.SubMenuPageObject;
import utilities.Environment;

public class Order extends BaseTest {
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

		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		registerPage.clickToRegisterButton("register-button");

		loginPage = (LoginPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-login");

		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		loginPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());

		loginPage.clickToButtonByText("Log in");

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

		menuPage = (MenuPageObject) homePage.openMenuPage(driver, "Computers");

		subMenuPage = menuPage.openSubMenuPage("Desktops");

		subMenuPage.clickToProductByText(driver, "Build your own computer");
	}

	@Test
	public void Order_01_Add_Product_To_Cart() {
		log.info("Add To Cart Step - 01: Select Attribute for product");
		subMenuPage.selectToDropdownByName(driver, "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");
		verifyEquals(subMenuPage.getItemSelected(driver, "product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
		subMenuPage.selectToDropdownByName(driver, "product_attribute_2", "2 GB");
		verifyEquals(subMenuPage.getItemSelected(driver, "product_attribute_2"), "2 GB");

		log.info("Add To Cart Step - 02: Check to Checkbox and Radio button");
		subMenuPage.checkToRadioButtonByID(driver, "product_attribute_3_6");
		subMenuPage.checkToRadioButtonByID(driver, "product_attribute_4_8");
		subMenuPage.checkToRadioButtonByID(driver, "product_attribute_5_10");

		log.info("Add To Cart Step - 03: Verify Product Price Displayed");
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "product-price"), "$1,300.00");

		log.info("Add To Cart Step - 04: Click to Add to Cart button");
		subMenuPage.clickToButtonByClassText("add-to-cart-panel", "Add to cart");

		log.info("Add To Cart Step - 05: Verify Success Add To Cart Message");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Add To Cart Step - 06: Verify Header link Message");
		verifyEquals(subMenuPage.getHeaderText(driver, "ico-cart"), "Shopping cart (1)");

		log.info("Add To Cart Step - 07: Verify Info Product At Shopping Cart");
		subMenuPage.hoverToHeaderLinks(driver, "ico-cart");
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "count"), "There are 1 item(s) in your cart.");
		verifyTrue(subMenuPage.isMessageByDynamicsClassDisplayed(driver, "product"));
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "totals"), "Sub-Total: $1,300.00");
	}

	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		log.info("Edit Step - 01: Open Shopping Cart page");
		cartPage = (CartPageObject) subMenuPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Edit Step - 02: Click to Edit button");
		subMenuPage = cartPage.clickToEditButton();

		log.info("Edit Step - 03: Select Attribute for product");
		subMenuPage.selectToDropdownByName(driver, "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");
		verifyEquals(subMenuPage.getItemSelected(driver, "product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
		subMenuPage.selectToDropdownByName(driver, "product_attribute_2", "4GB [+$20.00]");
		verifyEquals(subMenuPage.getItemSelected(driver, "product_attribute_2"), "4GB [+$20.00]");

		log.info("Edit Step - 04: Check to Checkbox and Radio button");
		subMenuPage.checkToRadioButtonByID(driver, "product_attribute_3_6");
		subMenuPage.checkToRadioButtonByID(driver, "product_attribute_4_8");
		subMenuPage.checkToRadioButtonByID(driver, "product_attribute_5_10");
		subMenuPage.inputToTextboxByID(driver, "product_enteredQuantity_1", "2");

		log.info("Edit Step - 05: Click to Update button");
		subMenuPage.clickToButtonByClassText("add-to-cart-panel", "Update");
		subMenuPage.sleepInSecond(2);

		log.info("Edit Step - 06: Verify Product Price Displayed");
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "product-price"), "$1,320.00");

		log.info("Edit Step - 07: Verify Success Add To Cart Message");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Edit Step - 08: Verify Header link Message");
		verifyEquals(subMenuPage.getHeaderText(driver, "ico-cart"), "Shopping cart (2)");

		log.info("Edit Step - 09: Verify Info Product At Shopping Cart");
		subMenuPage.hoverToHeaderLinks(driver, "ico-cart");
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "count"), "There are 2 item(s) in your cart.");
		verifyTrue(subMenuPage.isMessageByDynamicsClassDisplayed(driver, "product"));
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "totals"), "Sub-Total: $2,640.00");
	}

	@Test
	public void Order_03_Remove_Product_From_Shopping_Cart() {
		log.info("Remove Step - 01: Open Shopping Cart page");
		cartPage = (CartPageObject) subMenuPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Remove Step - 02: Click to Remove button");
		cartPage.clickToButton("remove-btn");

		log.info("Remove Step - 03: Verify Shopping Cart Message");
		verifyEquals(cartPage.getNoDataMessage(driver), "Your Shopping Cart is empty!");
	}

	@Test
	public void Order_04_Update_Shopping_Cart() {
		log.info("Update Step - 01: Open Sub Menu page");
		menuPage = (MenuPageObject) cartPage.openMenuPage(driver, "Computers");
		subMenuPage = menuPage.openSubMenuPage("Desktop");

		log.info("Update Step - 02: Click to Product");
		subMenuPage.clickToProductByText(driver, "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Update Step - 03: Verify Product Price Displayed");
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "product-price"), "$500.00");

		log.info("Update Step - 04: Click to Add to Cart button");
		subMenuPage.clickToButtonByClassText("add-to-cart-panel", "Add to cart");

		log.info("Update Step - 05: Verify Success Add To Cart Message");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Update Step - 06: Open Shopping Cart page");
		cartPage = (CartPageObject) subMenuPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Update Step - 07: Input to QTY textbox");
		cartPage.inputToQuantityTextbox("5");

		log.info("Update Step - 08: Click to Update Shopping Cart button");
		cartPage.clickToButton("button-2 update-cart-button");

		log.info("Update Step - 09: Verify Subtotal Message");
		verifyEquals(cartPage.getPriceByDynamicValue("product-subtotal"), "$2,500.00");
	}

	@Test
	public void Order_05_Payment_By_Cheque() {
		log.info("Cheque Payment Step - 01: Remove product from Cart page");
		cartPage.clickToButton("remove-btn");

		log.info("Cheque Payment Step - 02: Open Sub Menu page");
		menuPage = (MenuPageObject) cartPage.openMenuPage(driver, "Computers");
		subMenuPage = menuPage.openSubMenuPage("Notebooks");

		log.info("Cheque Payment Step - 03: Add Product to Cart shopping");
		subMenuPage.clickToProductByText(driver, "Apple MacBook Pro 13-inch");

		log.info("Cheque Payment Step - 04: Click to 'Add to Cart' button");
		subMenuPage.clickToButtonByClassText("add-to-cart-panel", "Add to cart");

		log.info("Cheque Payment Step - 05: Verify Success Add To Cart Message");
		verifyEquals(subMenuPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		subMenuPage.closeSuccessMessage(driver);

		log.info("Cheque Payment Step - 06: Verify Info Product At Shopping Cart");
		subMenuPage.hoverToHeaderLinks(driver, "ico-cart");
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "count"), "There are 2 item(s) in your cart.");
		verifyTrue(subMenuPage.isMessageByDynamicsClassDisplayed(driver, "product"));
		verifyEquals(subMenuPage.getMessageByDynamicsClass(driver, "totals"), "Sub-Total: $3,600.00");

		log.info("Cheque Payment Step - 07: Open Shopping Cart page");
		cartPage = (CartPageObject) subMenuPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Cheque Payment Step - 08: Verify Infomation");
		verifyEquals(cartPage.getTotalInfosMessage("order-subtotal"), "$3,600.00");
		verifyEquals(cartPage.getTotalInfosMessage("shipping-cost"), "$0.00");
		verifyEquals(cartPage.getTotalInfosMessage("tax-value"), "$0.00");
		verifyEquals(cartPage.getTotalInfosMessage("order-total"), "$3,600.00");
		verifyEquals(cartPage.getTotalInfosMessage("order-subtotal"), "$3,600.00");

		log.info("Cheque Payment Step - 09: Input/Select Infomation");
		cartPage.selectToDropdownByName(driver, "checkout_attribute_1", "No");
		cartPage.checkToRadioButtonByID(driver, "termsofservice");
	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	UserDataMapper userData;
	String emailAddress;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MenuPageObject menuPage;
	private SubMenuPageObject subMenuPage;
	private CartPageObject cartPage;
}
