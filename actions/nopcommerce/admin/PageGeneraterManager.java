package nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminAddNewAddressPO;
import pageObjects.admin.AdminCreateNewCustomerPO;
import pageObjects.admin.AdminCustomerInfoPO;
import pageObjects.admin.AdminDashBoardPO;
import pageObjects.admin.AdminEditPO;
import pageObjects.admin.AdminEditProductPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.admin.AdminProductsPO;

public class PageGeneraterManager {

	public static PageGeneraterManager getPageGeneraterManager() {
		return new PageGeneraterManager();
	}

	public static AdminEditPO getAdminEditPage(WebDriver driver) {
		return new AdminEditPO(driver);
	}

	public static AdminCustomerInfoPO getAdminCustomerInfoPage(WebDriver driver) {
		return new AdminCustomerInfoPO(driver);
	}

	public static AdminEditProductPO getAdminEditProductPage(WebDriver driver) {
		return new AdminEditProductPO(driver);
	}

	public static AdminCreateNewCustomerPO getAdminCreateNewCustomerPage(WebDriver driver) {
		return new AdminCreateNewCustomerPO(driver);
	}

	public static AdminAddNewAddressPO getAdminAddNewAddressPage(WebDriver driver) {
		return new AdminAddNewAddressPO(driver);
	}

	public static AdminProductsPO getProductsPage(WebDriver driver) {
		return new AdminProductsPO(driver);
	}

	public static AdminDashBoardPO getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPO(driver);
	}

	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
}
