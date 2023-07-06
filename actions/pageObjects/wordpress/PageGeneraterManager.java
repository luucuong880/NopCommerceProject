package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManager {
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminPostAddnewPO getAdminPostAddnewPage(WebDriver driver) {
		return new AdminPostAddnewPO(driver);
	}

	public static AdminUserPO getAdminUserPage(WebDriver driver) {
		return new AdminUserPO(driver);
	}

	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}

	public static UserSearchPostPO getUserSearchPostPage(WebDriver driver) {
		return new UserSearchPostPO(driver);
	}

}
