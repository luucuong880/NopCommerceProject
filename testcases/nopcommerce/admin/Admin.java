package nopcommerce.admin;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.admin.AddNewAddressPageObject;
import pageObjects.admin.CreateNewCustomerPageObject;
import pageObjects.admin.CustomerInfoPageObject;
import pageObjects.admin.DashBoardPageObject;
import pageObjects.admin.EditPageObject;
import pageObjects.admin.EditProductPageObject;
import pageObjects.admin.LoginPageObject;
import pageObjects.admin.ProductsPageObject;

public class Admin extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		adminLoginPage = PageGeneraterManager.getAdminLoginPage(driver);

		userEmailAddress = "naruto" + generateFakeNumber() + "@hotmail.vn";
		userPassword = "123456";
		userFirstName = "Naruto";
		userLastName = "Uzumaki";
		company = "Automation FC";
		city = "Ho Chi Minh";
		address_1 = "456 Le Lai";
		address_2 = "123 Quang Trung";
		zipCode = "700000";
		country = "Viet Nam";
		phoneNumber = "0987654321";
		faxNumber = "+8487654321";

		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		adminLoginPage.inputToAdminEmailTextbox(adminEmailAddress);
		adminLoginPage.inputToAdminPasswordTextbox(adminPassword);
		adminDashBoardPage = adminLoginPage.clickToLoginButton();

		adminDashBoardPage = PageGeneraterManager.getAdminDashBoardPage(driver);

	}

	@Test
	public void Role_01_Search_Product() {
		adminDashBoardPage.waitForAjaxBusyInvisible();

		adminDashBoardPage.clickToCatalogButton();

		productsPage = adminDashBoardPage.clickToProductsButton();

		productsPage.inputToProductsNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		productsPage.clickToSearchButton();

		productsPage.waitForAjaxBusyIconInvisible();

		Assert.assertEquals(productsPage.getProductsNameText(), "Lenovo IdeaCentre 600 All-in-One PC");
		Assert.assertEquals(productsPage.getSKUText(), "LE_IC_600");
		Assert.assertEquals(productsPage.getPriceText(), "500");
		Assert.assertEquals(productsPage.getStockText(), "10000");
		Assert.assertTrue(productsPage.isTrueIconDisplayed());

	}

	@Test
	public void Role_02_Products_Category_Uncheck() {
		productsPage.inputToProductsNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		productsPage.selectCategory("Computers");

		Assert.assertTrue(productsPage.isCategorySelected());

		productsPage.clickToSearchButton();

		productsPage.waitForAjaxBusyIconInvisible();

		Assert.assertEquals(productsPage.getTableMessage(), "No data available in table");

	}

	@Test
	public void TC_03_Products_Category_Check() {
		productsPage.inputToProductsNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		productsPage.selectCategory("Computers");

		Assert.assertTrue(productsPage.isCategorySelected());

		productsPage.checkSubCategories();

		productsPage.clickToSearchButton();

		productsPage.waitForAjaxBusyIconInvisible();

	}

	@Test
	public void TC_04_Products_Child_Category() {
		productsPage.inputToProductsNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		productsPage.selectChildCategory("Computers >> Desktops");

		Assert.assertTrue(productsPage.isChildCategorySelected());

		productsPage.clickToSearchButton();

		productsPage.waitForAjaxBusyIconInvisible();

	}

	@Test
	public void TC_05_Products_Manufacturer() {
		productsPage.inputToProductsNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		productsPage.selectManufacturer("Apple");

		Assert.assertTrue(productsPage.isAppleManufacturerSelected());

		productsPage.clickToSearchButton();

		productsPage.waitForAjaxBusyIconInvisible();

		Assert.assertEquals(productsPage.getTableMessage(), "No data available in table");

		productsPage.reloadPage();
	}

	@Test
	public void TC_06_Product_SKU() {

		productsPage.inputToSKUTextbox("LE_IC_600");

		editProductPage = productsPage.clickToGoButton();

		Assert.assertTrue(editProductPage.isProductDetailsMessageDisplayed());
	}

	@Test
	public void TC_07_Create_New_Customer() {

		customerInfoPage = editProductPage.openAdminCustomerInfoPage(driver);

		customerInfoPage.waitForAjaxLoading();

		createNewCustomerPage = customerInfoPage.clickToAddNewButton();

		createNewCustomerPage.inputToEmailTextbox(userEmailAddress);
		createNewCustomerPage.inputToPasswordTextbox(userPassword);
		createNewCustomerPage.inputToFirstNameTextbox(userFirstName);
		createNewCustomerPage.inputToLastNameTextbox(userLastName);
		createNewCustomerPage.checkGenderRadio();
		Assert.assertTrue(createNewCustomerPage.isGenderSelectedDisplayed());
		createNewCustomerPage.inputToDateOfBirth("1/1/2000");
		createNewCustomerPage.inputToCompanyTextbox(company);
		createNewCustomerPage.checkActiveBox();
		Assert.assertTrue(createNewCustomerPage.isActiveDisplayed());
		createNewCustomerPage.inputToAdminComment("Add new Customer(Guests)");

		createNewCustomerPage.clickToSaveAndContinueButton();

		Assert.assertTrue(createNewCustomerPage.getSuccessMessage());

		customerInfoPage = createNewCustomerPage.clickToBackCustomerListButton();

	}

	@Test
	public void TC_08_Search_Customer_With_Email() {

		customerInfoPage.inputToEmailSearchTextbox(userEmailAddress);

		customerInfoPage.clickToSearchButton();

		Assert.assertTrue(customerInfoPage.isItemInTableDisplayed());

		customerInfoPage.reloadPage();

	}

	@Test
	public void TC_09_Search_Customer_With_First_Last_Name() {

		customerInfoPage.inputToFirstNameSearchTextbox(userFirstName);
		customerInfoPage.inputToLastNameSearchTextbox(userLastName);

		customerInfoPage.clickToSearchButton();

		customerInfoPage = PageGeneraterManager.getAdminCustomerInfoPage(driver);

		Assert.assertTrue(customerInfoPage.isItemInTableDisplayed());

		customerInfoPage.reloadPage();
	}

	@Test
	public void TC_10_Search_With_Company() {
		customerInfoPage.inputToCompanySearchTextbox(company);

		customerInfoPage.clickToSearchButton();

		customerInfoPage = PageGeneraterManager.getAdminCustomerInfoPage(driver);

		Assert.assertTrue(customerInfoPage.isItemInTableDisplayed());

		customerInfoPage.reloadPage();
	}

	@Test
	public void TC_11_Search_With_Full_Data() {
		customerInfoPage.inputToEmailSearchTextbox(userEmailAddress);
		customerInfoPage.inputToFirstNameSearchTextbox(userFirstName);
		customerInfoPage.inputToLastNameSearchTextbox(userLastName);
		customerInfoPage.selectMonthSearch("1");
		Assert.assertTrue(customerInfoPage.isMonthDisplayed());
		customerInfoPage.selectDaySearch("1");
		Assert.assertTrue(customerInfoPage.isDayDisplayed());
		customerInfoPage.inputToCompanySearchTextbox(company);

		customerInfoPage.clickToSearchButton();

		customerInfoPage = PageGeneraterManager.getAdminCustomerInfoPage(driver);

		Assert.assertTrue(customerInfoPage.isItemInTableDisplayed());
	}

	@Test
	public void TC_12_Edit_Customer() {
		editPage = customerInfoPage.clickToEditButton();

		editPage.inputToEmailTextbox("edit_" + userEmailAddress);
		editPage.inputToFirstNameTextbox("Edit " + userFirstName);
		editPage.inputToLastNameTextbox("Edit " + userLastName);
		editPage.inputToDayOfBirthTextbox("2/2/2000");
		editPage.inputToCompanyTextbox("edit " + company);
		editPage.inputToAdminCommentTextbox("Edit Customer(Guests)");

		customerInfoPage = editPage.clickToSaveButton();

		Assert.assertTrue(editPage.getSuccessMessage());

		customerInfoPage.inputToEmailSearchTextbox("edit_" + userEmailAddress);
		customerInfoPage.inputToFirstNameSearchTextbox("Edit " + userFirstName);
		customerInfoPage.inputToLastNameSearchTextbox("Edit " + userLastName);
		customerInfoPage.selectMonthSearch("2");
		Assert.assertTrue(customerInfoPage.isMonth2Displayed());
		customerInfoPage.selectDaySearch("2");
		Assert.assertTrue(customerInfoPage.isMonth2Displayed());
		customerInfoPage.inputToCompanySearchTextbox("Edit " + company);

		customerInfoPage.clickToSearchButton();

		customerInfoPage = PageGeneraterManager.getAdminCustomerInfoPage(driver);

		Assert.assertEquals(editPage.getCustomerRoleInDataTable(), "Registered");
	}

	@Test
	public void TC_13_Add_New_Address() {
		editPage = customerInfoPage.clickToEditButton();

		addNewAddressPage = editPage.openAddNewAddressPage();

		addNewAddressPage.inputToAllAndClickSaveButton(userFirstName, userLastName, userEmailAddress, company, city, address_1, address_2, zipCode, phoneNumber, faxNumber);

		Assert.assertTrue(addNewAddressPage.isCountrySelectedDisplayed());
		Assert.assertTrue(addNewAddressPage.isSuccessMessageDisplayed());

		editPage = addNewAddressPage.clickToBackCustomerLink();

		Assert.assertTrue(editPage.isFirstNameAddressDisplayed());
		Assert.assertTrue(editPage.isLastNameAddressDisplayed());
		Assert.assertTrue(editPage.isPhoneNumberAddressDisplayed());
		Assert.assertTrue(editPage.isFaxNumberAddressDisplayed());
		Assert.assertTrue(editPage.isAddressDisplayed());
	}

	@Test
	public void TC_14_Edit_Address() {
		customerInfoPage = editPage.openAdminCustomerInfoPage(driver);

		customerInfoPage.inputToFirstNameSearchTextbox("Edit " + userFirstName);
		customerInfoPage.inputToLastNameSearchTextbox("Edit " + userLastName);
		customerInfoPage.selectMonthSearch("2");
		Assert.assertTrue(customerInfoPage.isMonth2Displayed());
		customerInfoPage.selectDaySearch("2");
		Assert.assertTrue(customerInfoPage.isMonth2Displayed());
		customerInfoPage.inputToCompanySearchTextbox("Edit " + company);

		customerInfoPage.clickToSearchButton();

		editPage = customerInfoPage.clickToEditButton();

		addNewAddressPage = editPage.clickToEditButton();

		addNewAddressPage.inputEditAndClickSaveButton("Edit" + userFirstName, "Edit" + userLastName, userEmailAddress, "Edit" + company, country, city, address_1, address_2, zipCode, phoneNumber, faxNumber);

		Assert.assertTrue(addNewAddressPage.isCountry_2_SelectedDisplayed());
		Assert.assertTrue(addNewAddressPage.isSuccessMessageDisplayed());

		editPage = addNewAddressPage.clickToBackCustomerDetailsButton();

		editPage.clickToAddNewAddressButton();
		editPage = new EditPageObject(driver);

		Assert.assertTrue(editPage.isFirstNameAddressDisplayed());
		Assert.assertTrue(editPage.isLastNameAddressDisplayed());
		Assert.assertTrue(editPage.isPhoneNumberAddressDisplayed());
		Assert.assertTrue(editPage.isFaxNumberAddressDisplayed());
		Assert.assertTrue(editPage.isAddressDisplayed());
	}

	@Test
	public void TC_15_Delete_Address() {
		customerInfoPage = editPage.openAdminCustomerInfoPage(driver);

		customerInfoPage.inputToFirstNameSearchTextbox("Edit " + userFirstName);
		customerInfoPage.inputToLastNameSearchTextbox("Edit " + userLastName);
		customerInfoPage.selectMonthSearch("2");
		Assert.assertTrue(customerInfoPage.isMonth2Displayed());
		customerInfoPage.selectDaySearch("2");
		Assert.assertTrue(customerInfoPage.isMonth2Displayed());
		customerInfoPage.inputToCompanySearchTextbox("Edit " + company);

		customerInfoPage.clickToSearchButton();

		editPage = customerInfoPage.clickToEditButton();

		editPage.clickToDeleteButton();
		editPage.acceptAlertMessage();

		Assert.assertEquals(editPage.getDataTableMessage(), "No data available in table");

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	private WebDriver driver;
	private DashBoardPageObject adminDashBoardPage;
	private LoginPageObject adminLoginPage;
	private ProductsPageObject productsPage;
	private EditPageObject editPage;
	private CustomerInfoPageObject customerInfoPage;
	private EditProductPageObject editProductPage;
	private CreateNewCustomerPageObject createNewCustomerPage;
	private AddNewAddressPageObject addNewAddressPage;
	private String adminEmailAddress, adminPassword, userEmailAddress, userPassword, userFirstName, userLastName, company;
	private String city, address_1, address_2, zipCode, country, phoneNumber, faxNumber;

	@AfterClass
	public void afterClass() {

		driver.quit();
	}
}