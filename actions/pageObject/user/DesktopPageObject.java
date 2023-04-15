package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.DesktopPageUI;

public class DesktopPageObject extends BasePage {
	private WebDriver driver;

	public DesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToViewModButton(String textValue) {
		waitForElementClickable(driver, DesktopPageUI.VIEW_MOD_BUTTON, textValue);
		clickToElement(driver, DesktopPageUI.VIEW_MOD_BUTTON, textValue);
	}

}
