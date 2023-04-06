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

	public void inputToTextboxByID(String textID, String textValue) {
		waitForElementVisible(driver, CustomerInfoPageUI.DYNAMIC_TEXTBOX_BY_ID, textID);
		sendkeyToElement(driver, CustomerInfoPageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, textID);
	}

	public void selectDropDownByName(String textName, String itemValue) {
		waitForElementVisible(driver, CustomerInfoPageUI.DYNAMIC_DROPDOWN_BY_NAME, textName);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, textName);
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, CustomerInfoPageUI.LOGOUT_LINK);
		clickToElement(driver, CustomerInfoPageUI.LOGOUT_LINK);

	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	public OrderPageObject clickToOrdersButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.ORDER_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.ORDER_BUTTON);
		return PageGeneratorManager.getPageGeneratorManager().getOrderPage(driver);
	}

}
