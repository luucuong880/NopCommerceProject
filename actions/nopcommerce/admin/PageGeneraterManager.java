package nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AddNewAddressPageObject;
import pageObjects.admin.CreateNewCustomerPageObject;
import pageObjects.admin.CustomerInfoPageObject;
import pageObjects.admin.DashBoardPageObject;
import pageObjects.admin.EditPageObject;
import pageObjects.admin.EditProductPageObject;
import pageObjects.admin.LoginPageObject;
import pageObjects.admin.ProductsPageObject;

public class PageGeneraterManager {

	public static EditPageObject getAdminEditPage(WebDriver driver) {
		return new EditPageObject(driver);
	}

	public static CustomerInfoPageObject getAdminCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static EditProductPageObject getAdminEditProductPage(WebDriver driver) {
		return new EditProductPageObject(driver);
	}

	public static CreateNewCustomerPageObject getAdminCreateNewCustomerPage(WebDriver driver) {
		return new CreateNewCustomerPageObject(driver);
	}

	public static AddNewAddressPageObject getAdminAddNewAddressPage(WebDriver driver) {
		return new AddNewAddressPageObject(driver);
	}

	public static ProductsPageObject getProductsPage(WebDriver driver) {
		return new ProductsPageObject(driver);
	}

	public static DashBoardPageObject getAdminDashBoardPage(WebDriver driver) {
		return new DashBoardPageObject(driver);
	}

	public static LoginPageObject getAdminLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
