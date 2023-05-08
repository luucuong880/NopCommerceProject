package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.MenuPageUI;

public class MenuPageObject extends BasePage {
	private WebDriver driver;

	public MenuPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public SubMenuPageObject openSubMenuPage(String pageName) {
		waitForElementClickable(driver, MenuPageUI.LINK_BY_TEXT, pageName);
		clickToElement(driver, MenuPageUI.LINK_BY_TEXT, pageName);
		return PageGeneratorManager.getPageGeneratorManager().getSubMenuPage(driver);
	}

	public boolean isLinkByTextDisplayed(String textboxID) {
		waitForElementVisible(driver, MenuPageUI.LINK_BY_TEXT, textboxID);
		return isElementDisplayed(driver, MenuPageUI.LINK_BY_TEXT, textboxID);
	}

}
