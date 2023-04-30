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

import pageObject.user.CartPageObject;
import pageObject.user.CheckoutPageObject;
import pageObject.user.ComputersPageObject;
import pageObject.user.CustomerInfoPageObject;
import pageObject.user.DesktopPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.NotebooksPageObject;
import pageObject.user.OrderPageObject;
import pageObject.user.RegisterPageObject;
import utilities.Environment;

public class Computers extends BaseTest {
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
		newFirstName = "Johnny";
		newLastName = "Deep";
		newEmail = newFirstName + newLastName + "@hotmail.com";
		newCity = "Ha Noi";
		newZipCode = "113000";
		newAddress = "456 Hai Ba Trung";
		newPhone = "0789564213";
		cardHolderName = "Gaylord Ryan";
		cardNumber = "4485587734773155";
		cardCode = "599";
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakermail.com";

		registerPage = (RegisterPageObject) homePage.openPageAtHeaderLinks(driver, "ico-register");

		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		registerPage.inputToTextboxByID(driver, "Password", userData.getLoginPassword());
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getLoginPassword());

		registerPage.clickToRegisterButton("register-button");

		loginPage = (LoginPageObject) registerPage.openPageAtHeaderLinks(driver, "ico-login");

		loginPage.inputToTextboxByID("Email", emailAddress);
		loginPage.inputToTextboxByID("Password", userData.getLoginPassword());

		loginPage.clickToButtonByText("Log in");

		homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);

	}

	@Test
	public void Computers_01_Desktop() {
		log.info("Desktop Step - 01: Open 'Computers' page");
		computersPage = (ComputersPageObject) homePage.openPageAtTopMenuByText(driver, "Computers");

		log.info("Desktop Step - 02: Verify 'Desktop' link is Displayed");
		verifyTrue(computersPage.isLinkByTextDisplayed(driver, "Desktop"));

		log.info("Desktop Step - 02: Verify 'Notebooks' link is Displayed");
		verifyTrue(computersPage.isLinkByTextDisplayed(driver, "Notebooks"));

		log.info("Desktop Step - 02: Verify 'Software' link is Displayed");
		verifyTrue(computersPage.isLinkByTextDisplayed(driver, "Software"));

		log.info("Desktop Step - 03: Open 'Desktop' page");
		desktopPage = (DesktopPageObject) computersPage.openCategoriesOfComputerPage(driver, "Desktop");

		log.info("Desktop Step - 04: Verify page title is Displayed");
		verifyTrue(desktopPage.isPageTitleByTextDisplayed(driver, "Desktops"));

		log.info("Desktop Step - 05: Click to 'List' button");
		desktopPage.clickToViewModButton("List");

		log.info("Desktop Step - 06: Click to 'Grid' button");
		desktopPage.clickToViewModButton("Grid");

		log.info("Desktop Step - 07: Click to 'Build your own computer' add to cart button");
		desktopPage.clickAddToCartButtonByText(driver, "Build your own computer");
		desktopPage = PageGeneratorManager.getPageGeneratorManager().getDesktopPage(driver);

		log.info("Desktop Step - 08: Select 'Processor' item");
		desktopPage.selectToDropdownByName(driver, "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");

		log.info("Desktop Step - 09: Verify Item Selected");
		verifyEquals(desktopPage.getItemSelected(driver, "product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

		log.info("Desktop Step - 10: Select 'Processor' item");
		desktopPage.selectToDropdownByName(driver, "product_attribute_2", "2 GB");

		log.info("Desktop Step - 11: Verify Item Selected");
		verifyEquals(desktopPage.getItemSelected(driver, "product_attribute_2"), "2 GB");

		log.info("Desktop Step - 12: Check 'HDD' radio button");
		desktopPage.checkToRadioOrCheckboxButton("HDD", "320 GB");

		log.info("Desktop Step - 13: Verify 'HDD' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("HDD", "320 GB"));

		log.info("Desktop Step - 14: Check 'OS' radio button");
		desktopPage.checkToRadioOrCheckboxButton("OS", "Vista Home [+$50.00]");

		log.info("Desktop Step - 15: Verify 'OS' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("OS", "Vista Home [+$50.00]"));

		log.info("Desktop Step - 16: Check 'Software' radio button");
		desktopPage.checkToRadioOrCheckboxButton("Software", "Microsoft Office [+$50.00]");

		log.info("Desktop Step - 17: Verify 'Software' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("Software", "Microsoft Office [+$50.00]"));

		log.info("Desktop Step - 18: Verify Total prices");
		verifyEquals(desktopPage.totalPrices(), "$1,300.00");

		log.info("Desktop Step - 19: Click to 'Add to cart' button");
		desktopPage.clickButtonByText(driver, "Add to cart");

		log.info("Desktop Step - 20: Verify Success Message Added");
		verifyEquals(desktopPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Desktop Step - 21: Close The title Message");
		desktopPage.closeSuccessMessage(driver);

	}

	@Test
	public void Computers_02_Shopping_Cart() {
		log.info("Shopping Cart Step - 01: Open 'Shopping Cart' page");
		cartPage = (CartPageObject) desktopPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Shopping Cart Step - 02: Verify 'Product' name is Displayed");
		verifyEquals(cartPage.getProductsName(), "Build your own computer");

		log.info("Shoping Cart Step - 03: Verify 'Processor' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("Processor: 2.2 GHz Intel Pentium Dual-Core E2200"));

		log.info("Shopping Cart Step - 04: Verify 'RAM' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("RAM: 2 GB"));

		log.info("Shopping Cart Step - 05: Verify 'HDD' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("HDD: 320 GB"));

		log.info("Shopping Cart Step - 06: Verify 'OS' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("OS: Vista Home [+$50.00]"));

		log.info("Shopping Cart Step - 07: Verify 'Software' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("Software: Microsoft Office [+$50.00]"));

		log.info("Shopping Cart Step - 08: Verify 'Price' is Displayed");
		verifyEquals(cartPage.getPriceByDynamicValue("product-unit-price"), "$1,300.00");
		verifyEquals(cartPage.getPriceByDynamicValue("product-subtotal"), "$1,300.00");

		log.info("Shopping Cart Step - 09: Verify 'Edit' button is displayed");
		verifyTrue(cartPage.isEditButtonDisplayed());

		log.info("Shopping Cart Step - 10: Verify 'Remove' button is displayed");
		verifyTrue(cartPage.isButtonDisplayed("remove-btn"));

	}

	@Test
	public void Computers_03_Edit_Products() {
		log.info("Edit Step - 01: Click to 'Edit' button at 'Cart' page");
		desktopPage = cartPage.clickToEditButton();

		log.info("Edit Step - 02: Select 'Processor' item");
		desktopPage.selectToDropdownByName(driver, "product_attribute_1", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("Edit Step - 03: Verify Item Selected");
		verifyEquals(desktopPage.getItemSelected(driver, "product_attribute_1"), "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("Edit Step - 04: Select 'Processor' item");
		desktopPage.selectToDropdownByName(driver, "product_attribute_2", "8GB [+$60.00]");

		log.info("Edit Step - 05: Verify Item Selected");
		verifyEquals(desktopPage.getItemSelected(driver, "product_attribute_2"), "8GB [+$60.00]");

		log.info("Edit Step - 06: Check 'HDD' radio button");
		desktopPage.checkToRadioOrCheckboxButton("HDD", "400 GB [+$100.00]");

		log.info("Edit Step - 07: Verify 'HDD' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("HDD", "400 GB [+$100.00]"));

		log.info("Edit Step - 08: Check 'OS' radio button");
		desktopPage.checkToRadioOrCheckboxButton("OS", "Vista Premium [+$60.00]");

		log.info("Edit Step - 09: Verify 'OS' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("OS", "Vista Premium [+$60.00]"));

		log.info("Edit Step - 10: Check 'Software' radio button");
		desktopPage.checkToRadioOrCheckboxButton("Software", "Microsoft Office [+$50.00]");

		log.info("Edit Step - 11: Verify 'Software' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("Software", "Microsoft Office [+$50.00]"));

		log.info("Edit Step - 12: Check 'Software' radio button");
		desktopPage.checkToRadioOrCheckboxButton("Software", "Acrobat Reader [+$10.00]");

		log.info("Edit Step - 13: Verify 'Software' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("Software", "Acrobat Reader [+$10.00]"));

		log.info("Edit Step - 14: Check 'Software' radio button");
		desktopPage.checkToRadioOrCheckboxButton("Software", "Total Commander [+$5.00]");

		log.info("Edit Step - 15: Verify 'Software' radio button is Displayed");
		verifyTrue(desktopPage.isItemChecked("Software", "Total Commander [+$5.00]"));

		log.info("Edit Step - 16: Verify Total prices");
		verifyEquals(desktopPage.totalPrices(), "$1,500.00");

		log.info("Edit Step - 17: Click to 'Update' button");
		desktopPage.clickButtonByText(driver, "Update");

		log.info("Edit Step - 18: Verify Success Message Added");
		verifyEquals(desktopPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Edit Step - 19: Close The title Message");
		desktopPage.closeSuccessMessage(driver);

		log.info("Edit Step - 20: Open 'Shopping Cart' page");
		cartPage = (CartPageObject) desktopPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Edit Step - 21: Verify 'Product' name is Displayed");
		verifyEquals(cartPage.getProductsName(), "Build your own computer");

		log.info("Edit Step - 22: Verify 'Processor' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"));

		log.info("Edit Step - 23: Verify 'RAM' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("RAM: 8GB [+$60.00]"));

		log.info("Edit Step - 24: Verify 'HDD' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("HDD: 400 GB [+$100.00]"));

		log.info("Edit Step - 25: Verify 'OS' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("OS: Vista Premium [+$60.00]"));

		log.info("Edit Step - 26: Verify 'Software' name is Displayed");
		verifyTrue(cartPage.isProductsAttributeDisplayed("Software: Microsoft Office [+$50.00]"));
		verifyTrue(cartPage.isProductsAttributeDisplayed("Software: Acrobat Reader [+$10.00]"));
		verifyTrue(cartPage.isProductsAttributeDisplayed("Software: Total Commander [+$5.00]"));

		log.info("Edit Step - 27: Input to 'Quantity' field");
		cartPage.inputToQuantityTextbox("5");

		log.info("Edit Step - 28: Click to 'Update' button");
		cartPage.clickButtonByText(driver, "Update shopping cart");

		log.info("Edit Step - 29: Verify 'Price' and 'Total Price' is displayed");
		verifyEquals(cartPage.getPriceByDynamicValue("product-unit-price"), "$1,500.00");
		verifyEquals(cartPage.getPriceByDynamicValue("product-subtotal"), "$7,500.00");

		log.info("Edit Step - 30: Click to 'Remove' button");
		cartPage.clickToButton("remove-btn");

		log.info("Edit Step - 31: Verify Empty Message is Displayed");
		verifyEquals(cartPage.getOrderMessage(), "Your Shopping Cart is empty!");
	}

	@Test
	public void Computers_04_Notebooks() {
		log.info("Notebooks Step - 01: Open 'Computers' page");
		computersPage = (ComputersPageObject) cartPage.openPageAtTopMenuByText(driver, "Computers");

		log.info("Notebooks Step - 02: Open 'Notebooks' page");
		notebookPage = (NotebooksPageObject) computersPage.openCategoriesOfComputerPage(driver, "Notebooks");

		log.info("Notebooks Step - 03: Count all products at page");
		verifyEquals(notebookPage.getProductSize(), 6);

		log.info("Notebooks Step - 04: Select Sort by Name: A to Z");
		notebookPage.selectToDropdownByName(driver, "products-orderby", "Name: A to Z");

		log.info("Notebooks Step - 05: Verify Sort by Name is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-orderby"), "Name: A to Z");

		log.info("Notebooks Step - 06: Select Sort by Name: Z to A");
		notebookPage.selectToDropdownByName(driver, "products-orderby", "Name: Z to A");

		log.info("Notebooks Step - 07: Verify Sort by Name is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-orderby"), "Name: Z to A");

		log.info("Notebooks Step - 08: Select Sort by Price: Low to High");
		notebookPage.selectToDropdownByName(driver, "products-orderby", "Price: Low to High");

		log.info("Notebooks Step - 09: Verify Sort by Price is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-orderby"), "Price: Low to High");

		log.info("Notebooks Step - 10: Select Sort by Price: High to Low");
		notebookPage.selectToDropdownByName(driver, "products-orderby", "Price: High to Low");

		log.info("Notebooks Step - 11: Verify Sort by Price is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-orderby"), "Price: High to Low");

		log.info("Notebooks Step - 12: Select display 3 per page");
		notebookPage.selectToDropdownByName(driver, "products-pagesize", "3");

		log.info("Notebooks Step - 13: Verify 3 per page is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-pagesize"), "3");

		log.info("Notebooks Step - 14: Count all products at page");
		verifyEquals(notebookPage.getProductSize(), 3);

		log.info("Notebooks Step - 15: Verify 'Next' page button is displayed");
		verifyTrue(notebookPage.isPageButtonDisplayed("next-page"));

		log.info("Notebooks Step - 16: Click to 'Next' page button");
		notebookPage.clickToPagerButton("next-page");

		log.info("Notebooks Step - 17: Count all products at page");
		verifyEquals(notebookPage.getProductSize(), 3);

		log.info("Notebooks Step - 18: Verify 'Previous' page button is displayed");
		verifyTrue(notebookPage.isPageButtonDisplayed("previous-page"));

		log.info("Notebooks Step - 19: Select display 6 per page");
		notebookPage.selectToDropdownByName(driver, "products-pagesize", "6");

		log.info("Notebooks Step - 20: Verify 6 per page is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-pagesize"), "6");

		log.info("Notebooks Step - 21: Count all products at page");
		verifyEquals(notebookPage.getProductSize(), 6);

		log.info("Notebooks Step - 22: Select display 9 per page");
		notebookPage.selectToDropdownByName(driver, "products-pagesize", "9");

		log.info("Notebooks Step - 23: Verify 9 per page is Displayed");
		verifyEquals(notebookPage.getItemSelected(driver, "products-pagesize"), "9");

		log.info("Notebooks Step - 24: Count all products at page");
		verifyEquals(notebookPage.getProductSize(), 6);

	}

	@Test
	public void Computers_05_Checkout_Payment_By_Cheque() {
		log.info("Checkout Cheque Step - 01: Add Apple MacBook Pro to Cart");
		notebookPage.clickAddToCartButtonByText(driver, "Apple MacBook Pro 13-inch");

		log.info("Checkout Cheque Step - 02: Verify Quantity Message");
		verifyEquals(notebookPage.getQuantityMessage(driver, "min-qty-notification"), "This product has a minimum quantity of 2");

		log.info("Checkout Cheque Step - 02: Click to 'Add to cart' button");
		notebookPage.clickToAddToCartButton();

		log.info("Checkout Cheque Step - 03: Verify Success Message Added");
		verifyEquals(notebookPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Checkout Cheque Step - 04: Close The title Message");
		notebookPage.closeSuccessMessage(driver);

		log.info("Checkout Cheque Step - 05: Open 'Shopping Cart' page");
		cartPage = (CartPageObject) notebookPage.openPageAtHeaderLinks(driver, "ico-cart");

		log.info("Checkout Cheque Step - 06: Verify 'Product' name is Displayed");
		verifyEquals(cartPage.getProductsName(), "Apple MacBook Pro 13-inch");

		log.info("Checkout Cheque Step - 07: Verify 'Price' and 'Total Price' is displayed");
		verifyEquals(cartPage.getPriceByDynamicValue("product-unit-price"), "$1,800.00");
		verifyEquals(cartPage.getPriceByDynamicValue("product-subtotal"), "$3,600.00");

		log.info("Checkout Cheque Step - 08: Input to 'Quantity' field");
		cartPage.inputToQuantityTextbox("5");

		log.info("Checkout Cheque Step - 09: Click to 'Update' button");
		cartPage.clickButtonByText(driver, "Update shopping cart");

		log.info("Checkout Cheque Step - 10: Verify 'Price' and 'Total Price' is displayed");
		verifyEquals(cartPage.getPriceByDynamicValue("product-unit-price"), "$1,800.00");
		verifyEquals(cartPage.getPriceByDynamicValue("product-subtotal"), "$9,000.00");

		log.info("Checkout Cheque Step - 11: Select Gift Wrapping");
		cartPage.selectToDropdownByName(driver, "checkout_attribute_1", "Yes [+$10.00]");

		log.info("Checkout Cheque Step - 12: Verify Gift Wrapping is displayed");
		verifyEquals(cartPage.getItemSelected(driver, "checkout_attribute_1"), "Yes [+$10.00]");

		log.info("Checkout Cheque Step - 13: Verify Gift Wrapping Message");
		verifyEquals(cartPage.getQuantityMessage(driver, "selected-checkout-attributes"), "Gift wrapping: Yes [+$10.00]");

		log.info("Checkout Cheque Step - 14: Verify Order Subtotal text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "order-subtotal"), "$9,010.00");

		log.info("Checkout Cheque Step - 15: Verify Shipping Cost text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "shipping-cost"), "$0.00");

		log.info("Checkout Cheque Step - 16: Verify Tax Value text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "tax-value"), "$0.00");

		log.info("Checkout Cheque Step - 17: Verify Order Total text");
		verifyEquals(cartPage.getOrderSubtotal(), "$9,010.00");

		log.info("Checkout Cheque Step - 18: Verify Earn Reward Point text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "earn-reward-points"), "901 points");

		log.info("Checkout Cheque Step - 18: Check to 'Term of service' Checkbox");
		cartPage.clickToRadioButtonByID(driver, "termsofservice");

		log.info("Checkout Cheque Step - 19: Click to 'Checkout' button");
		checkoutPage = cartPage.openCheckoutPage("button-1 checkout-button");

		log.info("Checkout Cheque Step - 20: Verify 'First Name' value is correctly");
		Assert.assertEquals(checkoutPage.getTextboxValueByID(driver, "BillingNewAddress_FirstName"), userData.getFirstName());

		log.info("Checkout Cheque Step - 21: Verify 'Last Name' value is correctly");
		Assert.assertEquals(checkoutPage.getTextboxValueByID(driver, "BillingNewAddress_LastName"), userData.getLastName());

		log.info("Checkout Cheque Step - 22: Verify 'Email' value is correctly");
		Assert.assertEquals(checkoutPage.getTextboxValueByID(driver, "BillingNewAddress_Email"), emailAddress);

		log.info("Checkout Cheque Step - 23: Select Country Name");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", userData.getCountry());

		log.info("Checkout Cheque Step - 24: Verify Country Name is Selected");
		verifyEquals(checkoutPage.getItemSelected(driver, "BillingNewAddress.CountryId"), userData.getCountry());

		log.info("Checkout Cheque Step - 25: Input to 'City' field");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", userData.getCity());

		log.info("Checkout Cheque Step - 26: Input to 'Address' field");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", userData.getAddress());

		log.info("Checkout Cheque Step - 27: Input to 'Zip/Code' field");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", userData.getZipcode());

		log.info("Checkout Cheque Step - 28: Input to 'Phone' field");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", userData.getPhone());

		log.info("Checkout Cheque Step - 29: Click to 'Continue' button");
		checkoutPage.clickToConfirmButton("billing-buttons-container");

		log.info("Checkout Cheque Step - 30: Click 'Next day air' radio button");
		checkoutPage.clickToRadioButtonByID(driver, "shippingoption_2");

		log.info("Checkout Cheque Step - 31: Click to 'Continue' button");
		checkoutPage.clickToConfirmButton("shipping-method-buttons-container");

		log.info("Checkout Cheque Step - 32: Click 'Check/Monney Order' radio button");
		checkoutPage.clickToRadioButtonByID(driver, "paymentmethod_0");

		log.info("Checkout Cheque Step - 33: Click to 'Continue' button");
		checkoutPage.clickToConfirmButton("payment-method-buttons-container");

		log.info("Checkout Cheque Step - 34: Count Infomation message");
		verifyEquals(checkoutPage.getMessageSize(), 4);

		log.info("Chekcout Cheque Step - 35: Click to 'Continue' button");
		checkoutPage.clickToConfirmButton("payment-info-buttons-container");

		log.info("Checkout Cheque Step - 36: Verify Billing Info");
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Billing Address", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Billing Address", "email"), "Email: " + emailAddress);
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Billing Address", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Billing Address", "address1"), userData.getAddress());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Billing Address", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Billing Address", "country"), userData.getCountry());

		log.info("Checkout Cheque Step - 37: Verify Shipping Info");
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Shipping Address", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Shipping Address", "email"), "Email: " + emailAddress);
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Shipping Address", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Shipping Address", "address1"), userData.getAddress());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Shipping Address", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "Shipping Address", "country"), userData.getCountry());

		log.info("Checkout Cheque Step - 38: Click to 'Continue' button");
		checkoutPage.clickButtonByText(driver, "Confirm");
		checkoutPage.sleepInSecond(2);

		log.info("Checkout Cheque Step - 39: Verify page title message");
		verifyEquals(checkoutPage.getPageTitleText(driver), "Thank you");

		log.info("Checkout Cheque Step - 40: Verify title success message");
		verifyEquals(checkoutPage.getTitleSuccessMessage(), "Your order has been successfully processed!");

	}

	@Test
	public void Computers_06_Checkout_Payment_By_Credit_Card() {
		log.info("Checkout Credit Step - 01: Open 'Customer Info' page");
		customerInfoPage = (CustomerInfoPageObject) checkoutPage.openPageAtHeaderLinks(driver, "ico-account");

		log.info("Checkout Credit Step - 02: Open 'Orders' page");
		orderPage = (OrderPageObject) customerInfoPage.openPageAtMyAccountByName(driver, "Orders");

		log.info("Checkout Credit Step - 03: Verify 'Details' button is displayed");
		verifyTrue(orderPage.isButtonDisplayed(driver, "Details"));

		log.info("Checkout Credit Step - 04: Click to 'Details' button");
		orderPage.clickButtonByText(driver, "Details");

		log.info("Checkout Credit Step - 05: Verify Billing Info");
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "billing-info-wrap", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "billing-info-wrap", "email"), "Email: " + emailAddress);
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "billing-info-wrap", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "billing-info-wrap", "address1"), userData.getAddress());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "billing-info-wrap", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "billing-info-wrap", "country"), userData.getCountry());

		log.info("Checkout Credit Step - 06: Verify Shipping Info");
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "shipping-info-wrap", "name"), userData.getFirstName() + " " + userData.getLastName());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "shipping-info-wrap", "email"), "Email: " + emailAddress);
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "shipping-info-wrap", "phone"), "Phone: " + userData.getPhone());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "shipping-info-wrap", "address1"), userData.getAddress());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "shipping-info-wrap", "city-state-zip"), userData.getCity() + "," + userData.getZipcode());
		verifyEquals(checkoutPage.getBillingShippingAddress(driver, "shipping-info-wrap", "country"), userData.getCountry());

		log.info("Checkout Credit Step - 07: Verify Payment Info");
		verifyEquals(checkoutPage.getPaymentShippingStatus(driver, "billing-info-wrap", "payment-method"), "Check / Money Order");
		verifyEquals(checkoutPage.getPaymentShippingStatus(driver, "billing-info-wrap", "payment-method-status"), " Pending");

		verifyEquals(checkoutPage.getPaymentShippingStatus(driver, "shipping-info-wrap", "shipping-method"), "Next Day Air");
		verifyEquals(checkoutPage.getPaymentShippingStatus(driver, "shipping-info-wrap", "shipping-method-status"), "Not yet shipped");

		log.info("Checkout Credit Step - 09: Verify 'Re-order' button is displayed");
		verifyTrue(checkoutPage.isButtonDisplayed(driver, "Re-order"));

		log.info("Checkout Credit Step - 10: Click to 'Re-order' button");
		checkoutPage.clickButtonByText(driver, "Re-order");
		cartPage = PageGeneratorManager.getPageGeneratorManager().getCartPage(driver);

		log.info("Checkout Credit Step - 11: Input to 'Quantity' field");
		cartPage.inputToQuantityTextbox("10");

		log.info("Checkout Credit Step - 12: Click to 'Update' button");
		cartPage.clickButtonByText(driver, "Update shopping cart");

		log.info("Checkout Credit Step - 13: Verify 'Price' and 'Total Price' is displayed");
		verifyEquals(cartPage.getPriceByDynamicValue("product-unit-price"), "$1,800.00");
		verifyEquals(cartPage.getPriceByDynamicValue("product-subtotal"), "$18,000.00");

		log.info("Checkout Credit Step - 14: Verify Gift Wrapping is displayed");
		verifyEquals(cartPage.getItemSelected(driver, "checkout_attribute_1"), "No");

		log.info("Checkout Credit Step - 15: Verify Gift Wrapping Message");
		verifyEquals(cartPage.getQuantityMessage(driver, "selected-checkout-attributes"), "Gift wrapping: No");

		log.info("Checkout Credit Step - 16: Verify Order Subtotal text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "order-subtotal"), "$18,000.00");

		log.info("Checkout Credit Step - 17: Verify Shipping Cost text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "shipping-cost"), "$0.00");

		log.info("Checkout Credit Step - 18: Verify Tax Value text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "tax-value"), "$0.00");

		log.info("Checkout Credit Step - 19: Verify Order Total text");
		verifyEquals(cartPage.getOrderSubtotal(), "$18,000.00");

		log.info("Checkout Credit Step - 20: Verify Earn Reward Point text");
		verifyEquals(cartPage.getTotalInfosMessage(driver, "earn-reward-points"), "1800 points");

		log.info("Checkout Credit Step - 21: Check to 'Term of service' Checkbox");
		cartPage.clickToRadioButtonByID(driver, "termsofservice");

		log.info("Checkout Credit Step - 22: Click to 'Checkout' button");
		checkoutPage = cartPage.openCheckoutPage("button-1 checkout-button");

		log.info("Checkout Credit Step - 23: Select New Address Shipping");
		checkoutPage.selectToDropdownByName(driver, "billing_address_id", "New Address");

		log.info("Checkout Credit Step - 24: Input New Address Info");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_FirstName", newFirstName);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_LastName", newLastName);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Email", newEmail);
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", "Viet Nam");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", newCity);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", newAddress);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", newZipCode);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", newPhone);
		checkoutPage.clickToConfirmButton("billing-buttons-container");

		log.info("Checkout Credit Step - 25: Select 2nd Day Air radio button");
		checkoutPage.clickToRadioButtonByID(driver, "shippingoption_2");
		checkoutPage.clickToConfirmButton("shipping-method-buttons-container");

		log.info("Checkout Credit Step - 26: Select Pay by Credit Card radio button");
		checkoutPage.clickToRadioButtonByID(driver, "paymentmethod_1");
		checkoutPage.clickToConfirmButton("payment-method-buttons-container");

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
	private String emailAddress, newFirstName, newLastName, newEmail, newCity, newAddress, newZipCode, newPhone;
	private String cardHolderName, cardNumber, cardCode;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private DesktopPageObject desktopPage;
	private ComputersPageObject computersPage;
	private CartPageObject cartPage;
	private NotebooksPageObject notebookPage;
	private CheckoutPageObject checkoutPage;
	private CustomerInfoPageObject customerInfoPage;
	private OrderPageObject orderPage;
	UserDataMapper userData;
}
