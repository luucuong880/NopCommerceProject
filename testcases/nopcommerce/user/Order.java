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
import pageObject.user.CheckoutPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MenuPageObject;
import pageObject.user.OrderPageObject;
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

		infoCheckoutMessage = "Mail Personal or Business Check, Cashier's Check or money order to:" + "\n" + "\n" + "NOP SOLUTIONS" + "\n" + "your address here," + "\n" + "New York, NY 10001" + "\n" + "USA" + "\n"
				+ "Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check."
				+ "\n" + "P.S. You can edit this text from admin panel.";

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
		verifyEquals(cartPage.getTotalInfosMessage("earn-reward-points"), "360 points");

		log.info("Cheque Payment Step - 09: Input/Select Infomation");
		cartPage.selectToDropdownByName(driver, "checkout_attribute_1", "No");
		verifyEquals(cartPage.getItemSelected(driver, "checkout_attribute_1"), "No");
		cartPage.checkToRadioButtonByID(driver, "termsofservice");

		log.info("Cheque Payment Step - 10: Click to Checkout button and Open Checkout page");
		checkoutPage = cartPage.openCheckoutPage("button-1 checkout-button");

		log.info("Cheque Payment Step - 11: Input/Select Information at Checkout page");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", "Viet Nam");
		verifyEquals(checkoutPage.getItemSelected(driver, "BillingNewAddress.CountryId"), "Viet Nam");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", userData.getCity());
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", userData.getAddress());
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", userData.getZipcode());
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", userData.getPhone());

		log.info("Cheque Payment Step - 12: Click to Continue button");
		checkoutPage.clickToContinueButton("billing-buttons-container");

		log.info("Cheque Payment Step - 13: Click to Continue button at Shipping method step");
		checkoutPage.clickToContinueButton("shipping-method-buttons-container");

		log.info("Cheque Payment Step - 14: Click to Continue button at Payment method step");
		checkoutPage.clickToContinueButton("payment-method-buttons-container");

		log.info("Cheque Payment Step - 15: Verify Information at Payment Information step");
		verifyEquals(checkoutPage.getMessageByDynamicsClass(driver, "info"), infoCheckoutMessage);

		log.info("Cheque Payment Step - 16: Click to Continue button at Payment Information step");
		checkoutPage.clickToContinueButton("payment-info-buttons-container");

		log.info("Cheque Payment Step - 17: Verify Info Billing Address");
		verifyEquals(checkoutPage.getBillingShippingAddress("billing-info-wrap", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(checkoutPage.getBillingShippingAddress("billing-info-wrap", "email"), "Email: " + emailAddress);
		verifyEquals(checkoutPage.getBillingShippingAddress("billing-info-wrap", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(checkoutPage.getBillingShippingAddress("billing-info-wrap", "address1"), userData.getAddress());
		verifyEquals(checkoutPage.getBillingShippingAddress("billing-info-wrap", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(checkoutPage.getBillingShippingAddress("billing-info-wrap", "country"), userData.getCountry());
		verifyEquals(checkoutPage.getBillingShippingAddress("payment-method-info", "payment-method"), "Payment Method: Check / Money Order");

		log.info("Cheque Payment Step - 18: Verify Info Shipping Address");
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-info-wrap", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-info-wrap", "email"), "Email: " + emailAddress);
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-info-wrap", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-info-wrap", "address1"), userData.getAddress());
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-info-wrap", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-info-wrap", "country"), userData.getCountry());
		verifyEquals(checkoutPage.getBillingShippingAddress("shipping-method-info", "shipping-method"), "Shipping Method: Ground");

		log.info("Cheque Payment Step - 19: Verify Info product at Checkout page");
		verifyEquals(checkoutPage.getProductNameText(), "Apple MacBook Pro 13-inch");
		verifyEquals(checkoutPage.getInfoText("sku-number"), "AP_MBP_13");
		verifyEquals(checkoutPage.getInfoText("product-unit-price"), "$1,800.00");
		verifyEquals(checkoutPage.getInfoText("product-quantity"), "2");
		verifyEquals(checkoutPage.getInfoText("product-subtotal"), "$3,600.00");
		verifyEquals(checkoutPage.getMessageByDynamicsClass(driver, "selected-checkout-attributes"), "Gift wrapping: No");

		log.info("Cheque Payment Step - 20: Verify Total Info at Checkout page");
		verifyEquals(checkoutPage.getTotalsInfoText("order-subtotal"), "$3,600.00");
		verifyEquals(checkoutPage.getTotalsInfoText("shipping-cost"), "$0.00");
		verifyEquals(checkoutPage.getTotalsInfoText("tax-value"), "$0.00");
		verifyEquals(checkoutPage.getTotalsInfoText("order-total"), "$3,600.00");
		verifyEquals(checkoutPage.getTotalsInfoText("earn-reward-points"), "360 points");

		log.info("Cheque Payment Step - 21: Click to Confirm button");
		checkoutPage.clickToConfirmButton();
		checkoutPage.sleepInSecond(2);

		log.info("Cheque Payment Step - 22: Verify Success Message");
		verifyEquals(checkoutPage.getPageTitleText(driver), "Thank you");
		verifyEquals(checkoutPage.getTitleSuccessMessage(), "Your order has been successfully processed!");
		verifyTrue(checkoutPage.isOrderNumberDisplayed());

		log.info("Cheque Payment Step - 23: Open Customer Info page");
		customerInfoPage = (CustomerInfoPageObject) checkoutPage.openPageAtHeaderLinks(driver, "ico-account");

		log.info("Cheque Payment Step - 24: Open Oreders page");
		orderPage = (OrderPageObject) customerInfoPage.openPageAtMyAccountByName(driver, "Orders");

		log.info("Cheque Payment Step - 25: Verify 'Details' button is Displayed");
		verifyTrue(orderPage.isDetailsButtonDisplayed());

		log.info("Cheque Payment Step - 26: Click to 'Details' button");
		orderPage.clickToDetailButton();

		log.info("Cheque Payment Step - 27: Verify Order Overview Content text");
		verifyEquals(orderPage.getOrderOverviewText("order-status"), "Order Status: Pending");
		verifyEquals(orderPage.getOrderOverviewText("order-total"), "Order Total: $3,600.00");

		log.info("Cheque Payment Step - 28: Verify Info Billing Address");
		verifyEquals(orderPage.getBillingShippingAddress("billing-info-wrap", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(orderPage.getBillingShippingAddress("billing-info-wrap", "email"), "Email: " + emailAddress);
		verifyEquals(orderPage.getBillingShippingAddress("billing-info-wrap", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(orderPage.getBillingShippingAddress("billing-info-wrap", "address1"), userData.getAddress());
		verifyEquals(orderPage.getBillingShippingAddress("billing-info-wrap", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(orderPage.getBillingShippingAddress("billing-info-wrap", "country"), userData.getCountry());
		verifyEquals(orderPage.getBillingShippingAddress("payment-method-info", "payment-method"), "Payment Method: Check / Money Order");
		verifyEquals(orderPage.getBillingShippingAddress("payment-method-info", "payment-method-status"), "Payment Status: Pending");

		log.info("Cheque Payment Step - 29: Verify Info Shipping Address");
		verifyEquals(orderPage.getBillingShippingAddress("shipping-info-wrap", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(orderPage.getBillingShippingAddress("shipping-info-wrap", "email"), "Email: " + emailAddress);
		verifyEquals(orderPage.getBillingShippingAddress("shipping-info-wrap", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(orderPage.getBillingShippingAddress("shipping-info-wrap", "address1"), userData.getAddress());
		verifyEquals(orderPage.getBillingShippingAddress("shipping-info-wrap", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(orderPage.getBillingShippingAddress("shipping-info-wrap", "country"), userData.getCountry());
		verifyEquals(orderPage.getBillingShippingAddress("shipping-method-info", "shipping-method"), "Shipping Method: Ground");
		verifyEquals(orderPage.getBillingShippingAddress("shipping-method-info", "shipping-status"), "Shipping Status: Not yet shipped");

		log.info("Cheque Payment Step - 30: Verify Info product at Order page");
		verifyEquals(orderPage.getInfoText("sku"), "AP_MBP_13");
		verifyEquals(orderPage.getInfoText("product"), "Apple MacBook Pro 13-inch");
		verifyEquals(orderPage.getInfoText("unit-price"), "$1,800.00");
		verifyEquals(orderPage.getInfoText("quantity"), "2");
		verifyEquals(orderPage.getInfoText("total"), "$3,600.00");
		verifyEquals(orderPage.getMessageByDynamicsClass(driver, "selected-checkout-attributes"), "Gift wrapping: No");

		log.info("Cheque Payment Step - 31: Verify Total Info at Order page");
		verifyEquals(orderPage.getTotalsInfoText("Sub-Total:"), "$3,600.00");
		verifyEquals(orderPage.getTotalsInfoText("Shipping:"), "$0.00");
		verifyEquals(orderPage.getTotalsInfoText("Tax:"), "$0.00");
		verifyEquals(orderPage.getTotalsInfoText("Order Total:"), "$3,600.00");
	}

	@Test
	public void Order_06_Payment_By_Card() {

	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	UserDataMapper userData;
	String emailAddress, infoCheckoutMessage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MenuPageObject menuPage;
	private SubMenuPageObject subMenuPage;
	private CartPageObject cartPage;
	private CheckoutPageObject checkoutPage;
	private CustomerInfoPageObject customerInfoPage;
	private OrderPageObject orderPage;
}
