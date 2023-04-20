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

	public void checkToRadioOrCheckboxButton(String textValue, String textValue1) {
		waitForElementClickable(driver, DesktopPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
		sleepInSecond(2);
	}

	public boolean isItemChecked(String textValue, String textValue1) {
		waitForElementVisible(driver, DesktopPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
		return isElementDisplayed(driver, DesktopPageUI.CHECKBOX_OR_RADIO_BUTTON, textValue, textValue1);
	}

	public String totalPrices() {
		waitForElementVisible(driver, DesktopPageUI.TOTAL_PRICES);
		return getElementText(driver, DesktopPageUI.TOTAL_PRICES);
	}

}
