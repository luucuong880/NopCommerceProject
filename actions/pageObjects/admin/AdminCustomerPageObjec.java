package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminCreateNewCustomerPageUI;

public class AdminCustomerPageObjec extends BasePage {
	private WebDriver driver;

	public AdminCustomerPageObjec(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAdminComment(String string) {
		waitForElementVisible(driver, AdminCreateNewCustomerPageUI.ADMIN_COMMENT);
		sendkeyToElement(driver, AdminCreateNewCustomerPageUI.ADMIN_COMMENT, string);
	}

	public AdminCustomerInfoPO clickToBackCustomerListButton() {
		waitForElementClickable(driver, AdminCreateNewCustomerPageUI.BACK_CUSTOMER_BUTTON);
		clickToElement(driver, AdminCreateNewCustomerPageUI.BACK_CUSTOMER_BUTTON);
		sleepInSecond(3);
		return PageGeneraterManager.getAdminCustomerInfoPage(driver);
	}

	public void clickToCloseSuccessMessage() {
		waitForElementClickable(driver, AdminCreateNewCustomerPageUI.CLOSE_BUTTON);
		clickToElement(driver, AdminCreateNewCustomerPageUI.CLOSE_BUTTON);
	}

	public void clickToButtonByClass(String classValue) {
		waitForElementClickable(driver, AdminCreateNewCustomerPageUI.DYNAMIC_CLASS, classValue);
		clickToElement(driver, AdminCreateNewCustomerPageUI.DYNAMIC_CLASS, classValue);
	}

}
