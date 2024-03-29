package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify 'My Account' link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getPageGeneratorManager().getLoginPage(driver);
	}

	public CustomerInfoPageObject openMyAccountLink() {
		String myAccountLink = getElementAttribute(driver, HomePageUI.MY_ACCOUNT_LINK, "href");
		openPageUrl(driver, myAccountLink);
		return PageGeneratorManager.getPageGeneratorManager().getCustomerInfoPage(driver);
	}

}
