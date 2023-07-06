package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUI.wordpress.AdminDasboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDasboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDasboardPageUI.POST_MENU_LINK);
		return PageGeneraterManager.getAdminPostSearchPage(driver);
	}

	public AdminUserPO clickToUserMenuLink() {
		waitForElementClickable(driver, AdminDasboardPageUI.USER_MENU_LINK);
		clickToElement(driver, AdminDasboardPageUI.USER_MENU_LINK);
		return PageGeneraterManager.getAdminUserPage(driver);
	}
}
