package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import nopcommerce.user.PageGeneratorManager;
import pageUI.user.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void checkToGenderTextbox(String textID) {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO_BY_ID, textID);
		checkToDefaultCheckboxOrRadio(driver, CustomerInfoPageUI.GENDER_RADIO_BY_ID, textID);
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, CustomerInfoPageUI.LOGOUT_LINK);
		clickToElement(driver, CustomerInfoPageUI.LOGOUT_LINK);

	}

	public OrderPageObject clickToOrdersButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.ORDER_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.ORDER_BUTTON);
		return PageGeneratorManager.getPageGeneratorManager().getOrderPage(driver);
	}

}
